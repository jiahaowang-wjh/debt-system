package com.smart.bracelet.service.doc.impl;

import com.smart.bracelet.enums.DocReplaceEnum;
import com.smart.bracelet.enums.DocumentPath;
import com.smart.bracelet.service.doc.BusWordConversionService;
import com.smart.bracelet.utils.IdUtils;

import com.smart.bracelet.utils.PdfUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzq
 * @version 1.0
 * @date 2020/9/20
 **/
@Service
@Slf4j
public class BusWordConversionServiceImpl implements BusWordConversionService {

    /**
     * 填充Word并保存为指定格式
     *
     * @author liuzq
     * @date 2020/9/20
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormat() {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE.getPath() + DocumentPath.WORD_TEMPLATE.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE.getPath() + DocumentPath.PDF_SAVE.getName() + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        map.put(DocReplaceEnum.DEBT_NAME.getName(), "张三");
        map.put(DocReplaceEnum.DEBT_ID_CARD.getName(), "510364198712021816");
        map.put(DocReplaceEnum.ID_CARD_ADDRESS.getName(), "重庆市渝中区xxxx");
        map.put(DocReplaceEnum.PHONE_NUMBER.getName(), "18765453643");
        map.put(DocReplaceEnum.SITUATION.getName(), "1");
        map.put(DocReplaceEnum.AMOUNT.getName(), "100");
        map.put(DocReplaceEnum.AMOUNT_IN_WORDS.getName(), "壹佰");
        map.put(DocReplaceEnum.PRINCIPAL.getName(), "10000");
        map.put(DocReplaceEnum.INTEREST.getName(), "100");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

}
