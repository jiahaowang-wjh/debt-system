package com.smart.bracelet.utils;

import com.aspose.words.Document;
import com.aspose.words.License;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * TODO:
 *
 * @author liuzq
 * @version 1.0
 * @date 2020/9/23
 **/
@Slf4j
public class PdfUtil {

    private static boolean getLicense() {
        boolean result = false;
        try {
            //读取license.xml文件
            InputStream is = PdfUtil.class.getResourceAsStream("/pdfxml/license.xml");
            License lic = new License();
            lic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 替换模板并保存为PDF
     *
     * @param readPath 所要读取的模板位置
     * @param savePath 最后pdf保存位置
     * @param map      所要替换的模板内容
     * @author liuzq
     * @date 2020/9/20
     */
    public static void fillInWordAndSaveAsPdf(String readPath, String savePath, Map<String, String> map) {
        try {
            //取得模板文件
            InputStream ins = new FileInputStream(readPath);
            XWPFDocument document = new XWPFDocument(ins);
            //取得段落
            Iterator<XWPFParagraph> iterator = document.getParagraphsIterator();
            Iterator<Map.Entry<String, String>> entryIterator;
            XWPFParagraph para;
            List<XWPFRun> runs;
            String runString;
            Map.Entry<String, String> entry;
            while (iterator.hasNext()) {
                para = iterator.next();
                //取得文本集合
                runs = para.getRuns();
                for (int i = 0; i < runs.size(); i++) {
                    //取得文本
                    XWPFRun run = runs.get(i);
                    runString = run.toString().trim();
                    entryIterator = map.entrySet().iterator();
                    while (entryIterator.hasNext()) {
                        entry = entryIterator.next();
                        if (entry.getKey().equals(runString)) {
                            //替换模板内容(从文本开始处填充内容即可替换原有文本)
                            run.setText(entry.getValue(), 0);
                        }
                    }
                }
            }
            //判断license.xml是否加载成功，否则将会有水印
            if (getLicense()) {
                //二进制OutputStream
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                document.write(baos);
                ByteArrayInputStream in = new ByteArrayInputStream(baos.toByteArray());
                //新建一个pdf文档，用于保存填充后的模板
                File file = new File(savePath);
                FileOutputStream fos = new FileOutputStream(file);
                Document doc = new Document(in);
                //转换为pdf
                doc.save(fos, com.aspose.words.SaveFormat.PDF);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
