package com.example.demo.web;


import com.example.demo.dto.FileInfo;
import com.example.demo.service.UploadServcie;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/web")
public class UploadFileController {
    Logger logger = LoggerFactory.getLogger(UploadFileController.class);

    @Autowired
    private UploadServcie uploadServcie;

    @RequestMapping("/upload")
    public String uploadFile(){
         //跳转到登录页面
        return "upload";
    }


    @RequestMapping("/linux")
    @ResponseBody
    public String upload2File(@RequestParam("file") MultipartFile file){
      //文件上传
        String originalFilename = file.getOriginalFilename();
        String filePath = "D:\\logs\\upload\\";
        File uploadFile = new File(filePath, originalFilename);
        try {
            file.transferTo(uploadFile);
            logger.info("文件上传成功");
        } catch (IOException e) {
            logger.info("文件上传失败");
            e.printStackTrace();
            return "upload failed";
        }
        //将服务器存放位置，存到数据库中
        UUID uuid = UUID.randomUUID();
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileId(uuid.toString());
        fileInfo.setPositon(uploadFile.getAbsolutePath());
        logger.info("上传的对象信息："+fileInfo.toString());
        uploadServcie.insertFile(fileInfo);
        return "upload successful";
    }

}
