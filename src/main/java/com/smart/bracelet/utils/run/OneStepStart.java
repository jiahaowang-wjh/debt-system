package com.smart.bracelet.utils.run;

import com.smart.bracelet.utils.comm.DeclareDetails;
import com.smart.bracelet.utils.exception.DefineException;
import com.alibaba.fastjson.JSONObject;
import com.smart.bracelet.utils.helper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description 签署流程测试启动
 * @author 宫清
 * @date 2019年7月21日 下午9:38:31
 * @since JDK1.7
 */
public class OneStepStart {

	private static final Logger LOGGER = LoggerFactory.getLogger(OneStepStart.class);

	static {
		// 声明条款
		DeclareDetails.showImportantMessage();
	}

	// -------------------------------------------公有方法start-------------------------------------------------------

	public static void main(String[] args) {

		try {
			String filePath = "E:\\test1.pdf";

			LOGGER.info("---------------------获取token start------------------------------");
			TokenHelper.getTokenData();

			LOGGER.info("---------------------创建个人账号start-------------------------------");
//			JSONObject personAcctJson = AccountHelper.createPersonAcct("ZS0003", "熊长河", null, "500101198909037814", "17830015877", null);
//			JSONObject personAcctJson = AccountHelper.createPersonAcct("ZS0005", "蒋莎莉", null, "500381200010121623", "15113893188", null);
			JSONObject personAcctJson = AccountHelper.createPersonAcct("ZS0006", "龚长虹", null, "50038119861112167X", "15683946116", null);
			String acctId = personAcctJson.getString("accountId");
//
//			JSONObject personAcctJson = AccountHelper.createPersonAcct("ZS0008", "邓丽清", null, "440981198801011427", "15218801056", null);
//			String acctId = personAcctJson.getString("accountId");
//
//			//设置静默签署
////			AccountHelper.setAutoSign(acctId,"2021-09-07 23:59:59");
//
////			JSONObject copierAcctJson = AccountHelper.createPersonAcct("LS123", "李四", null, "34240119920313****", "1508886****", null);
////			String copierAcctId = copierAcctJson.getString("accountId");
//
			LOGGER.info("---------------------创建机构账号start----------------------------------");
//			JSONObject orgAcctJson = AccountHelper.createOrgAcct("AAAAAA", acctId, "重庆米呀米电子商务有限公司", null, "91500107MA616WHU2M");
//			JSONObject orgAcctJson = AccountHelper.createOrgAcct("BBBBBB", acctId, "深圳市方博商贸管理有限公司", null, "91440300MA5G44JB4K");
			JSONObject orgAcctJson = AccountHelper.createOrgAcct("CCCCCC", acctId, "深圳市金隆盛投资管理有限公司", null, "914403003595944902");
			String orgId = orgAcctJson.getString("orgId");

			LOGGER.info("---------------------创建机构印章start----------------------------------");
//			JSONObject orgSealJson = SealHelper.createOrgTemplateSeal(orgId, "重庆米呀米电子商务有限公司", "RED", null, null, null, "91500107MA616WHU2M", "TEMPLATE_ROUND", "STAR");
//			JSONObject orgSealJson = SealHelper.createOrgTemplateSeal(orgId, "深圳市方博商贸管理有限公司", "RED", null, null, null, "91440300MA5G44JB4K", "TEMPLATE_ROUND", "STAR");
			JSONObject orgSealJson = SealHelper.createOrgTemplateSeal(orgId, "深圳市金隆盛投资管理有限公司", "RED", null, null, null, "914403003595944902", "TEMPLATE_ROUND", "STAR");
			String orgSealId = orgSealJson.getString("sealId");
			System.out.println(orgSealId);
//
//			LOGGER.info("---------------------通过上传方式创建文件start-----------------------------");
//			String fileName = "劳动合同.pdf";
//			JSONObject uploadJson = FileTemplateHelper.createFileByUpload(filePath, fileName, acctId);
//			String uploadUrl = uploadJson.getString("uploadUrl");
//			String fileId = uploadJson.getString("fileId");
//
//			LOGGER.info("---------------------文件流上传文件start---------------------------------");
//			FileTemplateHelper.streamUpload(filePath, uploadUrl);
//
//			LOGGER.info("---------------------一步发起签署start---------------------------------");
//			JSONObject flowJson = SignHelper.oneStepFlow(acctId, fileId, fileName, acctId);
//			String flowId = flowJson.getString("flowId");
//
//			LOGGER.info("---------------------签署流程开启 start-----------------------------");
//			SignHelper.startSignFlow(flowId);

//			LOGGER.info("---------------------签署完成后，通知回调，平台方进行签署流程归档 start-----------------------------");
//			SignHelper.archiveSignFlow(flowId);
//
//			LOGGER.info("---------------------归档后，获取文件下载地址 start-----------------------------");
//			SignHelper.downloadFlowDoc(flowId);
//			String fileId = "c05c28697a3c4f4a926e307b665400ce";
//			String flowId = "ec4a78ba2fdc472b8c6facb05b1b4022";
//			SignHelper.archiveSignFlow(flowId);
//			JSONObject json = SignHelper.qryDocuments(flowId,"");
//			LOGGER.info(json.toJSONString());
		} catch (DefineException e) {
			e.getE().printStackTrace();
		}

	}
}
