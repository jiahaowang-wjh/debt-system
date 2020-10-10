package com.smart.bracelet.controller.doc;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.smart.bracelet.model.po.user.PubUser;
import com.smart.bracelet.service.user.PubUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 下载excel
 */
@RestController
@RequestMapping("/exc")
@Validated
public class ExpController {

    @Autowired
    private PubUserService pubUserService;


    @RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws UnsupportedEncodingException {
        List<PubUser> list = new ArrayList<>();
        PubUser pubUser = pubUserService.selectByPrimaryKey(7986466421102532621L);
        list.add(pubUser);
// 通过工具类创建writer，默认创建xls格式

        ExcelWriter writer = ExcelUtil.getWriter();

//自定义标题别名

        writer.addHeaderAlias("userId", "用户ID");

        writer.addHeaderAlias("personId", "人员ID");

        writer.addHeaderAlias("loginName", "登录名");

        writer.addHeaderAlias("passwordMd5", "密码");

        writer.addHeaderAlias("isenable", "是否有效");

        writer.addHeaderAlias("note", "备注");

        writer.addHeaderAlias("userType", "用户类型");

// 合并单元格后的标题行，使用默认标题样式

        writer.merge(2, "辅助下载");

// 一次性写出内容，使用默认样式，强制输出标题

        writer.write(list, true);

//out为OutputStream，需要写出到的目标流

//response为HttpServletResponse对象

        response.setContentType("application/vnd.ms-excel;charset=utf-8");

//test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码

        String name = new String("辅助财务下载".getBytes("gbk"),"utf-8");

        response.setHeader("Content-Disposition", "attachment;filename=" + name + ".xls");

        ServletOutputStream out = null;

        try {

            out = response.getOutputStream();

            writer.flush(out, true);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

// 关闭writer，释放内存

            writer.close();

        }

//此处记得关闭输出Servlet流

        IoUtil.close(out);

    }
}
