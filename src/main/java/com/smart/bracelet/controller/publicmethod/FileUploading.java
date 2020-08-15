package com.smart.bracelet.controller.publicmethod;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

@RestController
@RequestMapping("/api/fileUploading/")
@Validated
public class FileUploading {

    @Value("${fileImgPath}")
    private String fileImgPath;

    //处理文件上传
    @PostMapping("/uploading")
    public @ResponseBody
    String uploading(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            String filename = uploadFile(file.getBytes(), fileImgPath, file.getOriginalFilename());
            return filename;
        } catch (Exception e) {
            e.printStackTrace();
            return "文件上传失败";
        }
    }



    @PostMapping("/download")
    public String  testDownload(HttpServletResponse response,String fileName) throws UnsupportedEncodingException {
        String subName = fileName.substring(fileName.indexOf(".")+1);
        response.setHeader("content-type", subName);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        byte[] buff = new byte[1024];
        //创建缓冲输入流
        BufferedInputStream bis = null;
        OutputStream outputStream = null;

        try {
            outputStream = response.getOutputStream();
            //这个路径为待下载文件的路径
            bis = new BufferedInputStream(new FileInputStream(new File(fileImgPath + fileName )));
            int read = bis.read(buff);

            //通过while循环写入到指定了的文件夹中
            while (read != -1) {
                outputStream.write(buff, 0, buff.length);
                outputStream.flush();
                read = bis.read(buff);
            }
        } catch ( IOException e ) {
            e.printStackTrace();
            //出现异常返回给页面失败的信息
            return "下载失败";
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "下载成功";
    }




    public String uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        String substring = fileName.substring(fileName.indexOf("."));
        String fileName2 = filePath + UUID.randomUUID().toString().toLowerCase().replace("-", "") + substring;
        FileOutputStream out = new FileOutputStream(fileName2);
        out.write(file);
        out.flush();
        out.close();
        return fileName2;
    }
}
