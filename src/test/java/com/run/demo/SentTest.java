package com.run.demo;

import java.io.IOException;

import org.json.JSONException;

import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;

public class SentTest {

	public static void main(String[] args) {
		// 短信应用SDK AppID
		int appid = 1400147984; // 1400开头

		// 短信应用SDK AppKey
		String appkey = "6ba8c8727d2a179abb4ae49fd47f99c3";

		// 需要发送短信的手机号码
		String[] phoneNumbers = {"18195555504", "18009553783","18709564110"};

		// 短信模板ID，需要在短信应用中申请
		int templateId = 206992; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
		//templateId7839对应的内容是"您的验证码是: {1}"
		// 签名
		String smsSign = "校园快递"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
		try {
		    String[] params = {"宁夏银行自动取款机处  "};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
		    SmsMultiSender msender = new SmsMultiSender(appid, appkey);
		    SmsMultiSenderResult result =  msender.sendWithParam("86", phoneNumbers,
		        templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
		    System.out.println(result);
		} catch (HTTPException e) {
		    // HTTP响应码错误
		    e.printStackTrace();
		} catch (JSONException e) {
		    // json解析错误
		    e.printStackTrace();
		} catch (IOException e) {
		    // 网络IO错误
		    e.printStackTrace();
		}
	}
}
