package com.smart.bracelet.controller.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@RestController
@RequestMapping("/api/fileUploading/")
@Validated
public class FileUploading {

    @Value("${filePath}")
    private String filePath;

    //处理文件上传
    @PostMapping("/uploading")
    public @ResponseBody
    String uploading(@RequestParam("file")MultipartFile file,HttpServletRequest request) {
        try {
            String filename = uploadFile(file.getBytes(), filePath, file.getOriginalFilename());
            return filename;
        } catch (Exception e) {
            e.printStackTrace();
            return "文件上传失败";
        }
    }

    public String  uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        String fileName2 = filePath+UUID.randomUUID().toString().toLowerCase().replace("-","")+".jpg";
        FileOutputStream out = new FileOutputStream(fileName2);
        out.write(file);
        out.flush();
        out.close();
        return fileName2;
    }
}
