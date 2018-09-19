package com.qfedu.newhorizon.controller.user;


import com.qfedu.newhorizon.common.result.R;

import com.qfedu.newhorizon.domain.user.City;
import com.qfedu.newhorizon.domain.user.Province;
import com.qfedu.newhorizon.service.user.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Address;
import java.util.List;

@RestController

public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping("provincelist.do")

    public R queryAll() {
        return new R(1000,"success",addressService.queryAll());
    }

    @RequestMapping("citylist.do")
    public R queryCity(Integer pid) {
        if(pid!=null){
            return new R (0,"success",addressService.queryByPid(pid));
        }
      return R.ERROR();

    }
}
