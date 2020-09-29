package com.smart.bracelet.utils;

import com.smart.bracelet.model.vo.debt.AuxiliaryDownload;
import com.smart.bracelet.model.vo.debt.DowLod;
import com.smart.bracelet.model.vo.debt.ReportAndRelativePersonShow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExportHelper {
    /**
     * 导出浏览器
     *
     * @param fileName 文件名
     * @param workbook HSSFWorkbook对象
     */
    public void WriteResponse(String fileName, HSSFWorkbook workbook,
                              HttpServletRequest request, HttpServletResponse response) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        fileName = fileName + df.format(new Date());//获取当前系统时间
        fileName += ".xls";

        //解决下载文件时文件名乱码问题    给名称加上编码格式UTF-8
        byte[] fileNameBytes = fileName.getBytes(StandardCharsets.UTF_8);
        fileName = new String(fileNameBytes, 0, fileNameBytes.length, StandardCharsets.ISO_8859_1);

        //下载文件的默认名称
        response.setHeader("content-Type", "application/vnd.ms-excel");
        //告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-disposition", "attachment; filename=" + fileName);
        workbook.write(response.getOutputStream());
    }


    /// <summary>
    /// 导出Excel  将数据写入到workbook中------辅助下载债务
    /// </summary>
    /// <returns></returns>
    public HSSFWorkbook ExportExcel1(List<DowLod> list) {
        try {
            //Excel实例
            HSSFWorkbook workbook = new HSSFWorkbook();
            //表实例
            Sheet sheet1 = workbook.createSheet("Sheet1");

            //创建行  标题行  下标（索引） 0
            Row row0 = sheet1.createRow(0);
            row0.createCell(0).setCellValue("序号");
            row0.createCell(1).setCellValue("报备人姓名");
            row0.createCell(2).setCellValue("身份证号码");
            row0.createCell(3).setCellValue("电话");
            row0.createCell(4).setCellValue("类型");
            row0.createCell(5).setCellValue("相对人姓名");
            row0.createCell(6).setCellValue("金额");
            if(list != null){
                //每一行数据
                for (int i = 0; i < list.size(); i++) {//行
                    //创建行  i+1是因为第一行已经被标题占了，所以这里从第二行开始，对应的下标为1
                    Row row = sheet1.createRow(i + 1);
                    //创建单元格
                    row.createCell(0).setCellValue(i+1);
                    row.createCell(1).setCellValue(list.get(i).getDebtName());
                    row.createCell(2).setCellValue(list.get(i).getIdCard());
                    row.createCell(3).setCellValue(list.get(i).getPriPhone());
                    String type = list.get(i).getType();
                    if("1".equals(type)){
                        row.createCell(4).setCellValue("债权人");
                    }else if("2".equals(type)){
                        row.createCell(4).setCellValue("债务人");
                    }else if("3".equals(type)){
                        row.createCell(4).setCellValue("债权债务人");
                    }
                    row.createCell(5).setCellValue(list.get(i).getPersonName());
                    row.createCell(6).setCellValue(list.get(i).getMoeny());
                }
            }
            return workbook;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("导出Excel错误信息：" + e.getMessage());
            throw e;
        }
    }

    /// <summary>
    /// 导出Excel  将数据写入到workbook中--------辅助财务下载
    /// </summary>
    /// <returns></returns>
    public HSSFWorkbook ExportExcel2(List<AuxiliaryDownload> list) {
        try {
            //Excel实例
            HSSFWorkbook workbook = new HSSFWorkbook();
            //表实例
            Sheet sheet1 = workbook.createSheet("Sheet1");

            //创建行  标题行  下标（索引） 0
            Row row0 = sheet1.createRow(0);
            row0.createCell(0).setCellValue("债权人" );
            row0.createCell(1).setCellValue("债务人");
            row0.createCell(2).setCellValue("时间");
            row0.createCell(3).setCellValue("合同编号");
            row0.createCell(4).setCellValue("录入费");
            row0.createCell(5).setCellValue("策划方案服务费");
            row0.createCell(6).setCellValue("贷销款");
            row0.createCell(7).setCellValue("债权转让金额");
            row0.createCell(8).setCellValue("债权处理年限");
            row0.createCell(9).setCellValue("分公司名称");
            row0.createCell(10).setCellValue("类型");
            if(list != null) {
                //每一行数据
                for (int i = 0; i < list.size(); i++) {//行
                    //创建行  i+1是因为第一行已经被标题占了，所以这里从第二行开始，对应的下标为1
                    Row row = sheet1.createRow(i + 1);
                    //创建单元格
                    row.createCell(0).setCellValue(i + 1);
                    row.createCell(1).setCellValue(list.get(i).getDebtName());
                    row.createCell(2).setCellValue(list.get(i).getPersonName());
                    row.createCell(3).setCellValue(list.get(i).getCreateTime());
                    row.createCell(4).setCellValue(list.get(i).getAssignmentAgreementNo());
                    row.createCell(5).setCellValue(list.get(i).getBbCost());
                    row.createCell(6).setCellValue(list.get(i).getZxCost());
                    row.createCell(7).setCellValue(list.get(i).getHcCost());
                    row.createCell(8).setCellValue(list.get(i).getDebtYaer());
                    row.createCell(9).setCellValue(list.get(i).getCompanyName());
                    String debtType = list.get(i).getDebtType();
                    if ("1".equals(debtType)) {
                        row.createCell(10).setCellValue("一次性提取转让债权等额资产");
                    } else if ("2".equals(debtType)) {
                        row.createCell(10).setCellValue("第三方商贸公司代理销售");
                    } else if ("3".equals(debtType)) {
                        row.createCell(10).setCellValue("第三方电子商务公司线上代理销售");
                    } else if ("4".equals(debtType)) {
                        row.createCell(10).setCellValue("其他");
                    }
                }
            }
            return workbook;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("导出Excel错误信息：" + e.getMessage());
            throw e;
        }
    }
}