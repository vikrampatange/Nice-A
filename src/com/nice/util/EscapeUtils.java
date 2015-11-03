package com.nice.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

public class EscapeUtils {

	public static final HashMap m = new HashMap();
	
	static {
		m.put(34, "&quot;"); // < - less-than
		m.put(60, "&lt;");   // < - less-than
		m.put(62, "&gt;");   // > - greater-than
	//User needs to map all html entities with their corresponding decimal values. 
     //Please refer to below table for mapping of entities and integer value of a char
     }

	public static String escapeHtml() {
		//String str = "<script>alert(\"abc\")</script>";
		String str ="&lt;script&gt;alert(&quot;abc&quot;)&lt;/script&gt;";
		try {
			StringWriter writer = new StringWriter((int) 
                           (str.length() * 1.5));
			escape(writer, str);
			System.out.println("encoded string is " + writer.toString() );
			return writer.toString();
		   } catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
			
		                                            }
	                                                 }

	public static void escape(Writer writer, String str) throws IOException {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			int ascii = (int) c;
			String entityName = (String) m.get(ascii);
			if (entityName == null) {
				if (c > 0x7F) {
					writer.write("&#");
					writer.write(Integer.toString(c, 10));
					writer.write(';');
				} else {
					writer.write(c);
				}
			} else {
                     writer.write(entityName);
			}
		}
	}
	
	
	
	
	
	public static String cleanXSS(String value) {
		//You'll need to remove the spaces from the html entities below
		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript : ( .* )[\\\"\\\']", "\"\"");
		value = value.replaceAll("script", "");
		return value;
		}
	public static void main(String[] args) {
		//EscapeUtils.escapeHtml();
		String str ="<script>alert(\"abc\")</script>;";
		String output =EscapeUtils.cleanXSS(str);
		
		System.out.println(output);
		
	}
}