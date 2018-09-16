package com.qfedu.newhorizon.controller.fdfs;

import com.qfedu.newhorizon.common.result.RO;
import com.qfedu.newhorizon.common.tools.FdfsTool;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 　　　Create  By  Ｍｒ.Ｈａｎ
 * 　                 　　　　　　　------ On 2018/9/11 16:58
 */
@Controller
public class FdfsController {

    @Autowired
    private FdfsTool fs;

    private static final String ADDR_IP = "http://10.8.163.82/";

    @RequestMapping("/upload.do")
    public @ResponseBody
    RO upload(@RequestParam("file") MultipartFile file) throws IOException, MyException {
        try {
            byte[] data = file.getBytes();
            String originalFilename = file.getOriginalFilename();
            String endName = originalFilename.substring(originalFilename.lastIndexOf("."));
            return RO.creat(1,ADDR_IP + fs.upload(data, endName, null));
        }catch (Exception e){
            e.printStackTrace();
            return RO.creat(0, e.toString());
        }
    }
}
