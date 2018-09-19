package com.qfedu.newhorizon.service.user;

import com.qfedu.newhorizon.domain.user.City;
import com.qfedu.newhorizon.domain.user.Province;

import java.util.List;

public interface AddressService {
    List<Province> queryAll();

    List<City> queryByPid(int pid);
}
