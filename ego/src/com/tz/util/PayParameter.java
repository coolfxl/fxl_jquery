package com.tz.util;
/**
 * 设置支付宝相关性和返回路径
 * @author arry 
 * @version v1.0
 * 
 */
public class PayParameter {

	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088112900113110";
	// 收款支付宝账号
	public static String seller_email = "tanzhouedu@qq.com";
	// 商户的私钥
	public static String key = "25p204edu53x4rfc699w2dl1q2j1e02t";
	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\";
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	// 签名方式 不需修改
	public static String sign_type = "MD5";
	
}
