package com.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.regexp.internal.recompile;

public class Func {

	public static String getTimeString(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}
	
	public static String  delSeatInfo(String pre,String str){
		if(pre.contains(",")){
			return pre.replace(str+",", "");
		}else {
			return "";
		}
		
	}
	
	public static String  addSeatInfo(String pre,String str){
		if("".equals(pre)){
			return str;
		}else {
			pre = pre+","+str;
			return pre;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(delSeatInfo("9,10", "9"));
	}
}
