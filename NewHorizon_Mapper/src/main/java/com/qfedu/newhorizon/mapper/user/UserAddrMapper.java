package com.qfedu.newhorizon.mapper.user;

import com.qfedu.newhorizon.domain.user.UserAddr;

public interface UserAddrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAddr record);

    int insertSelective(UserAddr record);

    UserAddr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAddr record);

    int updateById(UserAddr record);
}