package com.qfedu.newhorizon.provider.user;

import com.qfedu.newhorizon.domain.user.City;
import com.qfedu.newhorizon.domain.user.Province;
import com.qfedu.newhorizon.mapper.user.CityMapper;
import com.qfedu.newhorizon.mapper.user.ProvinceMapper;
import com.qfedu.newhorizon.service.user.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AddressServiceProvider")
public class AddressProvider implements AddressService {
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<Province> queryAll() {
        return provinceMapper.selectAll();
    }

    @Override
    public List<City> queryByPid(int pid) {
        return cityMapper.selectByPid(pid);
    }
}
