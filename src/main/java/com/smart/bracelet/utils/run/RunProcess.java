package com.smart.bracelet.utils.run;

import com.smart.bracelet.utils.comm.DeclareDetails;
import com.smart.bracelet.utils.exception.DefineException;
import com.smart.bracelet.utils.helper.*;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description 签署流程测试启动
 * @author 宫清
 * @date 2019年7月21日 下午9:38:31
 * @since JDK1.7
 */
public class RunProcess {

	private static final Logger LOGGER = LoggerFactory.getLogger(RunProcess.class);

	static {
		// 声明条款
		DeclareDetails.showImportantMessage();
	}

	// -------------------------------------------公有方法start-------------------------------------------------------

	public static void main(String[] args) {

		try {
			String filePath = "files/test.pdf";
			
			LOGGER.info("---------------------获取token start------------------------------");
			TokenHelper.getTokenData();

			LOGGER.info("---------------------创建个人账号start-------------------------------");
			JSONObject personAcctJson = AccountHelper.createPersonAcct("AABB", "宫清", null, "34240119900412423X", "1508886****", null);
			String acctId = personAcctJson.getString("accountId");
			
//			LOGGER.info("---------------------创建个人模板印章start-------------------------------");
//			JSONObject personSealJson = SealHelper.createPersonTemplateSeal(acctId, "测试个人印章", "RED", null, null, "YGYJFCS");
//			String personSealId = personAcctJson.getString("sealId");
			
			LOGGER.info("---------------------创建机构账号start----------------------------------");
			JSONObject orgAcctJson = AccountHelper.createOrgAcct("BBBB", acctId, "天之云信息科技有限公司", null, "52227058XT51M4AL62");
			String orgId = orgAcctJson.getString("orgId");
			
			LOGGER.info("---------------------创建机构印章start----------------------------------");
			JSONObject orgSealJson = SealHelper.createOrgTemplateSeal(orgId, "天之云公司印章", "BLUE", null, null, null, null, "TEMPLATE_ROUND", "STAR");
			String orgSealId = orgSealJson.getString("sealId");
			
			LOGGER.info("---------------------通过上传方式创建文件start-----------------------------");
			JSONObject uploadJson = FileTemplateHelper.createFileByUpload(filePath, "劳动合同.pdf", orgId);
			String uploadUrl = uploadJson.getString("uploadUrl");
			String fileId = uploadJson.getString("fileId");
			
			LOGGER.info("---------------------文件流上传文件start---------------------------------");
			FileTemplateHelper.streamUpload(filePath, uploadUrl);
			
			LOGGER.info("---------------------签署流程创建 start---------------------------------");
			//可通过SignParamUtil.createSignFlowStart()进行组装入参，具体使用中根据实际情况传参
			JSONObject flowJson = SignHelper.createSignFlow();
			String flowId = flowJson.getString("flowId");
			
			LOGGER.info("---------------------流程文档添加 start---------------------------------");
			SignHelper.addFlowDoc(flowId, fileId);
			
			LOGGER.info("---------------------添加平台自动盖章签署区 start---------------------------");
			String testSealId = "e6ecb2fd-e4ec-4c04-be97-85c3d46a960e"; //模拟环境是使用固定的天谷印章
			SignHelper.addPlatformAutoSignArea(flowId, Lists.newArrayList(fileId), Lists.newArrayList(testSealId));
			
			LOGGER.info("---------------------添加手动盖章签署区 start-----------------------------");
			SignHelper.addSignerHandSignArea(flowId, Lists.newArrayList(fileId), Lists.newArrayList(acctId), null);
			
			LOGGER.info("---------------------签署流程开启 start-----------------------------");
			SignHelper.startSignFlow(flowId);
			
//			LOGGER.info("---------------------签署完成后，通知回调，平台方进行签署流程归档 start-----------------------------");
//			SignHelper.archiveSignFlow(flowId);
//			
//			LOGGER.info("---------------------归档后，获取文件下载地址 start-----------------------------");
//			SignHelper.downloadFlowDoc(flowId);
			
		} catch (DefineException e) {
			e.getE().printStackTrace();
		}

	}
}
