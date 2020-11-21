package com.smart.bracelet.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smart.bracelet.enums.DocCode;
import com.smart.bracelet.enums.OrgInfo;
import com.smart.bracelet.model.po.doc.BusElectronSeal;
import com.smart.bracelet.utils.exception.DefineException;
import com.smart.bracelet.utils.helper.AccountHelper;
import com.smart.bracelet.utils.helper.FileTemplateHelper;
import com.smart.bracelet.utils.helper.SignHelper;
import com.smart.bracelet.utils.helper.TokenHelper;

/**
 * 文档工具类
 */
public class DocUtils {

    /**
     * 创建个人账号
     * @return
     */
    public static String creatUser(String userId, BusElectronSeal busElectronSeal) throws DefineException {
        //token start
        TokenHelper.getTokenData();
        //创建个人账号
        JSONObject personAcctJson = AccountHelper.createPersonAcct(userId, busElectronSeal.getParta(), null, busElectronSeal.getPartaCard(), busElectronSeal.getPartaTel(), null);
        String acctId = personAcctJson.getString("accountId");
        return acctId;
    }

    /**
     * 电子签章
     * @param docType
     * @param busElectronSeal
     */
    public static String fileCrete(String docType,BusElectronSeal busElectronSeal,String acctId)throws Exception {
        //token start
        TokenHelper.getTokenData();

        //枚举
        DocCode docCode = null;
        if("1".equals(docType)){//报备费发票
            docCode = DocCode.INPUT_FEE;
        }else if ("2".equals(docType)){//咨询服务费发票
            docCode = DocCode.CONSULTING_SERVICE_FEE;
        }else if ("3".equals(docType)){//货款费发票
            docCode = DocCode.PAYMENT_FEE;
            //设置静默签署
            AccountHelper.setAutoSign(OrgInfo.ELEC_AA.getAccountId(),"2121-09-07 23:59:59");
        }else if ("4".equals(docType)){//信息分析暨尽调协议
            docCode = DocCode.AGREE_ON;
        }else if ("5".equals(docType)){//策划方案服务协议
            docCode = DocCode.PLAN_SERVICE_AGREEMENT;
        }else if ("6".equals(docType)){//债权转让协议
            docCode = DocCode.ASSIGNMENT_AGREEMENT;
            //设置静默签署
            AccountHelper.setAutoSign(OrgInfo.ELEC_AA.getAccountId(),"2121-09-07 23:59:59");
        }else if ("7".equals(docType)){//债权转让确认书
            docCode = DocCode.ASSIGNMENT_CONFIRMATION;
        }else if ("8".equals(docType)){//债权转让通知书
            docCode = DocCode.ASSIGNMENT_NOTICE;
        }else if ("9".equals(docType)){//债权确认书
            docCode = DocCode.ASSIGNMENT_CONFIRM;
            //设置静默签署
            AccountHelper.setAutoSign(OrgInfo.ELEC_AA.getAccountId(),"2121-09-07 23:59:59");
        }else if ("10".equals(docType)){//催款函
            docCode = DocCode.COLLECTION_LETTER;
            //设置静默签署
            AccountHelper.setAutoSign(OrgInfo.ELEC_AA.getAccountId(),"2121-09-07 23:59:59");
        }else if ("11".equals(docType)){//委托代理销售合同
            docCode = DocCode.SALES_CONTRACT;
            //设置静默签署
            AccountHelper.setAutoSign(OrgInfo.ELEC_BB.getAccountId(),"2121-09-07 23:59:59");
        }else if ("12".equals(docType)){//和解协议
            docCode = DocCode.SETTLEMENT_AGREEMENT;
            //设置静默签署
            AccountHelper.setAutoSign(OrgInfo.ELEC_AA.getAccountId(),"2121-09-07 23:59:59");
        }
        //设置静默签署
        AccountHelper.setAutoSign(acctId,"2121-09-07 23:59:59");
        //通过上传方式创建文件
        String fileName = docCode.getDocName()+".pdf";
        String filePath = busElectronSeal.getFilePath();
        JSONObject uploadJson = FileTemplateHelper.createFileByUpload(filePath, fileName, acctId);
        String uploadUrl = uploadJson.getString("uploadUrl");
        String fileId = uploadJson.getString("fileId");
        //文件流上传文件
        FileTemplateHelper.streamUpload(filePath, uploadUrl);
        //一步发起签署
        JSONObject flowJson = SignHelper.oneStepFlow(acctId, fileId, fileName, acctId,docType);
        String flowId = flowJson.getString("flowId");
        //签署流程开启
        SignHelper.startSignFlow(flowId);
        new Thread().sleep(2000);
        //签署完成后，通知回调，平台方进行签署流程归档
        SignHelper.archiveSignFlow(flowId);
        new Thread().sleep(1000);
        //流程文档下载
        JSONObject json = SignHelper.qryDocuments(flowId,"");
        JSONArray docs = JSONArray.parseArray(json.getString("docs"));
        JSONObject docCon = (JSONObject) docs.get(0);
        String fileUrl = docCon.getString("fileUrl");
        return flowId+","+fileUrl;
    }

    /**
     * 创建用户ID
     * @param content
     * @return
     */
    public static String creatUserId (Integer content){
        String contentStr =content.toString();
        String returnStr ="";
        for(int i=6-contentStr.length();i>0;i--){
            returnStr+="0";
        }
        returnStr+=content;
        return "SSTZ"+returnStr;
    }

    /**
     * 电子签章
     * @param flowId
     */
    public static String getFile(String flowId)throws Exception {
        //token start
        TokenHelper.getTokenData();

        //流程文档下载
        JSONObject json = SignHelper.qryDocuments(flowId,"");
        JSONArray docs = JSONArray.parseArray(json.getString("docs"));
        JSONObject docCon = (JSONObject) docs.get(0);
        String fileUrl = docCon.getString("fileUrl");
        return fileUrl;
    }
}
