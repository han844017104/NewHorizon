package com.qfedu.newhorizon.provider.news;

import com.qfedu.newhorizon.common.redis.RedisUtil;
import com.qfedu.newhorizon.common.result.PageVo;
import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.common.result.TypeVo;
import com.qfedu.newhorizon.domain.news.New;
import com.qfedu.newhorizon.domain.newtype.NewType;
import com.qfedu.newhorizon.domain.newtype.NewTypeMain;
import com.qfedu.newhorizon.mapper.news.NewMapper;
import com.qfedu.newhorizon.mapper.newtype.NewTypeMapper;
import com.qfedu.newhorizon.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/18  17:00
 */
@Service("newsServiceProvider")
public class NewsProvider implements NewsService {

    @Autowired
    private NewMapper newMapper;

    @Autowired
    private NewTypeMapper newTypeMapper;

    @Autowired
    private RedisUtil redisUtil;


    //按分类查询
    @Override
    public R selectByType(Integer type) {
        List<New> news = newMapper.selectByType(type);
        if(null != news && news.size() > 0){
            return new R(0,"ok",news);
        }
        return R.ERROR();
    }

    //分类分页查询
    @Override
    public R selectByPage(Integer page, Integer limit, Integer type) {
        PageVo pageVo = newMapper.selectByPage((page - 1) * limit, limit, type);
        if(null != pageVo){
            return new R(0,"ok",pageVo);
        }
        return R.ERROR();
    }

    //id查询详情
    @Override
    public R selectById(Integer nid) {
        New aNew = newMapper.selectById(nid);
        if(null != aNew){
            return new R(0,"ok",aNew);
        }
        return R.ERROR();
    }

    //所有分类
    @Override
    public R selectAll() {
        //查询结果
        List<NewTypeMain> newTypes = newTypeMapper.selectAll();
        //返回结果
       List<TypeVo> typeVos = new ArrayList<>();
        if(newTypes != null && newTypes.size() > 0){
            for(NewTypeMain n : newTypes){
                TypeVo typeVo = new TypeVo();
                //父类添加
                if(n.getFatherid() == -1){
                    typeVo.setFather(n);
                    typeVos.add(typeVo);
                }else{
                    //子类循环找父类
                    for(TypeVo t : typeVos){
                        if(t.getFather().getFatherid() == n.getFatherid()){
                            t.getChildrens().add(n);
                        }
                    }
                }
            }

            return new R(0,"ok",typeVos);
        }
        return R.ERROR();
    }

    //一级分类
    @Override
    public R selectFather() {
        return null;
    }
}
