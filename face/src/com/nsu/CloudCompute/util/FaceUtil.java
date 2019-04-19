package com.nsu.CloudCompute.util;

import java.util.regex.Pattern;

public class FaceUtil {
	//***********判定字符串中个是否全为数字
	public static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	} 

}
