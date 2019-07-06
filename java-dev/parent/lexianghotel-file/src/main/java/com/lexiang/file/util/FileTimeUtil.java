package com.lexiang.file.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTimeUtil {
	
	
  public static String getUploudTime() {
	  
		Date date = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		
	    return df.format(date);
  }

}
