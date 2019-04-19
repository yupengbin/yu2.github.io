/**
 * @author Tony
 * @date 2018-01-10
 * @project rest_demo
 */
package com.nsu.CloudCompute.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.apache.http.auth.AUTH;

import com.nsu.CloudCompute.client.AbsRestClient;
import com.nsu.CloudCompute.client.JsonReqClient;

public class RestTest {

	static AbsRestClient InstantiationRestAPI() {
		
		return new JsonReqClient();
		
		
	}
	
	public static void testSendSms(String sid, String token, String appid, String templateid, String param, String mobile, String uid){
		try {
			String result=InstantiationRestAPI().sendSms(sid, token, appid, templateid, param, mobile, uid);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testSendSmsBatch(String sid, String token, String appid, String templateid, String param, String mobile, String uid){
		try {
			String result=InstantiationRestAPI().sendSmsBatch(sid, token, appid, templateid, param, mobile, uid);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testAddSmsTemplate(String sid, String token, String appid, String type, String template_name, String autograph, String content){
		try {
			String result=InstantiationRestAPI().addSmsTemplate(sid, token, appid, type, template_name, autograph, content);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	
	public static void testGetSmsTemplate(String sid, String token, String appid, String templateid, String page_num, String page_size){
		try {
			String result=InstantiationRestAPI().getSmsTemplate(sid, token, appid, templateid, page_num, page_size);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void testEditSmsTemplate(String sid, String token, String appid, String templateid, String type, String template_name, String autograph, String content){
		try {
			String result=InstantiationRestAPI().editSmsTemplate(sid, token, appid, templateid, type, template_name, autograph, content);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void testDeleterSmsTemplate(String sid, String token, String appid, String templateid){
		try {
			String result=InstantiationRestAPI().deleterSmsTemplate(sid, token, appid, templateid);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 娴嬭瘯璇存槑  鍚姩main鏂规硶鍚庯紝璇峰湪鎺у埗鍙拌緭鍏ユ暟�?��(鏁板瓧�?�瑰�? 鐩稿簲鐨勮皟鐢ㄦ柟娉�?)锛屽洖杞﹂敭缁撴�?
	 * 鍙傛暟鍚嶇О鍚箟锛岃鍙傝�價est api 鏂囨�?
	 * @throws IOException 
	 * @method main
	 */
	public static void main(String[] args) throws IOException {
		Random random=new Random();
		StringBuffer stringBuffer=new StringBuffer();
		for(int i=0;i<4;i++){
		int a=random.nextInt(10);
		stringBuffer.append(""+a);
		
		}
		
		System.out.println(stringBuffer);
		
		
		new RestTest().fun(stringBuffer.toString(),"13678037335");
	}
	
	public void fun(String pa,String phoneNum) throws IOException{
		
		//System.out.println("璇疯緭鍏ユ柟娉曞搴旂殑鏁板�?(渚嬪�?1),Enter閿粨鏉�?:");
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String methodNumber = "1";
		
		if (StringUtils.isBlank(methodNumber)){
			System.out.println("璇疯緭鍏ユ纭殑鏁板瓧锛屼笉鍙负绌�");
			return;
		}
	
		
		String URL="";
		
		
		
		if (methodNumber.equals("1")) {  //鎸囧畾妯℃澘鍗曞�?
			String sid = "5da995f771a0a6dbd1b4381b45292f39";
			String token = "b53c1f4f70b603be0483f1e557edbe59";
			String appid = "11d2b93d0e2f4693994135b24d4e8c1e";
			String templateid = "452072";
			String param = pa;
		
			
			
			String mobile = phoneNum;
			String uid = "";
			testSendSms(sid, token, appid, templateid, param, mobile, uid);
		}
		
		
		
		
		
		
		   
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		else if (methodNumber.equals("2")) { //鎸囧畾妯℃澘缇ゅ�?
			String sid = "";
			String token = "";
			String appid = "";
			String templateid = "";
			String param = "";
			String mobile = "";
			String uid = "";
			testSendSmsBatch(sid, token, appid, templateid, param, mobile, uid);
		} else if (methodNumber.equals("3")) {  //澧炲姞妯℃澘
			String sid = "";
			String token = "";
			String appid = "";
			String type = "";
			String template_name = "";
			String autograph = "";
			String content = "";
			testAddSmsTemplate(sid, token, appid, type, template_name, autograph, content);
		} else if (methodNumber.equals("4")) {  //鏌ヨ妯℃澘
			String sid = "";
			String token = "";
			String appid = "";
			String templateid = "";
			String page_num = "";
			String page_size = "";
			testGetSmsTemplate(sid, token, appid, templateid, page_num, page_size);
		} else if (methodNumber.equals("5")) {  //缂栬緫妯℃澘
			String sid = "";
			String token = "";
			String appid = "";
			String templateid = "";
			String type = "";
			String template_name = "";
			String autograph = "";
			String content = "";
			testEditSmsTemplate(sid, token, appid, templateid, type, template_name, autograph, content);
		} else if (methodNumber.equals("6")) {  //鍒犻櫎妯℃澘
			String sid = "";
			String token = "";
			String appid = "";
			String templateid = "";
			testDeleterSmsTemplate(sid, token, appid, templateid);
		} 	
	}
}
