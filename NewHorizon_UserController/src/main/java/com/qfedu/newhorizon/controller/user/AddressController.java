package com.qfedu.newhorizon.controller.user;

import com.qfedu.newhorizon.domain.user.City;
import com.qfedu.newhorizon.domain.user.Province;
import com.qfedu.newhorizon.service.user.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping("provincelist.do")
    public List<Province> queryAll() {
        return addressService.queryAll();
    }

    @RequestMapping("citylist.do")
    public List<City> queryCity(int pid) {
        return addressService.queryByPid(pid);
    }
}
