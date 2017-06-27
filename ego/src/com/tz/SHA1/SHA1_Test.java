package com.tz.SHA1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * 简单加密原理
 * 
 * 密码：abcd1234
 * 秘钥：随机生成 16进制   14f78asc123de457892
 * 时间戳:1970 - 当前时间的公共 毫秒数 
 * 用户ID：等等......
 * 
 * 14f78asc123de457892 abcd1234 1459861566868
 * 
 * 加密
 * byte[] buf = 14f78asc123de457892 abcd1234 1459861566868.getByte("utf-8");
 * 循环{
 * 		buf[i]>>> 4
 * 		buf[i++] >> 2
 * }
 * 
 * 最终得到一个16进制的 字符串
 * 
 * @author Ruby
 * @version 1.0
 */
public class SHA1_Test {
	
	public static String getSHA1(String pwd){
		
		char[] hexDigits={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		
		try {
			//把密码绑定时间戳
//			String name = pwd + new Date().getTime();
			MessageDigest mdtmp = MessageDigest.getInstance("SHA1");
			mdtmp.update(pwd.getBytes("utf-8"));
			
			byte[] md = mdtmp.digest();
			//最终得到的加密字符串
			
			int j = md.length;
			
			char[] buf = new char[j * 2];
			//定义一个状态位 控制buf数组
			int k = 0;
			
			//处理加密
			for (int i = 0; i < j; i++) {
				byte bt = md[i];
				buf[k++] = hexDigits[bt >>> 4 & 0xf];
				buf[k++] = hexDigits[bt & 0xf];
			}
			return new String(buf);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public static void main(String[] args) {
//		System.out.println(new Date().getTime());
		//1100100    6 
//		System.out.println(100 >>> 4);
		//1100100
		//0000110
		//0000100  4   &
		//1100110      |
//		System.out.println(100 | 6);
		//440ee0853ad1e99f962b63e459ef992d7c211722
		//440ee0853ad1e99f962b63e459ef992d7c211722
		
		
		//d3d5a26cad401bbd7b508de7e3c7cdd6fc70b07e
		//bffe67cd3efd7c301f11162e77afca90d56b33c5
		System.out.println(getSHA1("你好"));
		
	}

}
