//package com.nice.util;
//
//
//import java.text.SimpleDateFormat;
//
//import com.fpwd.common.AESEncryption;
//import com.fpwd.common.Base64Coder;
//
//public class Utility implements Cloneable {
//	private static Utility instance;
//
//	private Utility() {
//		// no-ops
//	}
//
//	public static synchronized Utility getInstance()
//{
//		if (instance == null)
//		{
//			instance = new Utility();
//		}
//		return instance;
//}
//
//	
//	
//	public String getDate()
//	{
//		String date = null;
//		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		date = df1.format(new java.util.Date());
//		return date;
//	}
//	
//	
//
//	public String generateRandomToken()
//	
//	{
//		long timeSeed = System.nanoTime(); // to get the current date time value
//		double randSeed = Math.random() * 1000; // random number generation
//		long midSeed = (long) (timeSeed * randSeed); // mixing up the time and
//		// rand number.
//		String s = midSeed + "";
//		String subStr = s.substring(0, 8);
//		return subStr;
//		
//		
//	}
//	
//
//
//	public String frameResetLink(String utid, String resetUrl, String emailId)
//			throws Exception {
//		String encrypt_token = null;
//		String encrypt_email = null;
//		String sub_tok = null;
//		String email_tok = null;
//
//		/*
//		 * encrypt token value use AES encryption(Any encryption method can be
//		 * used)
//		 */
//		sub_tok = AESEncryption.encrypt(utid);
//		/*
//		 * again encrypted using base64 encoding
//		 */
//		encrypt_token = Base64Coder.encodeString(sub_tok);
//
//		/*
//		 * encrypt eamil value use AES encryption(Any encryption method can be
//		 * used)
//		 */
//		email_tok = AESEncryption.encrypt(emailId);
//
//		/*
//		 * again encrypted using base64 encoding
//		 */
//		encrypt_email = Base64Coder.encodeString(email_tok);
//
//		
//		
//		// creating Reset Link
//		String resetlink = resetUrl + "?USERID=" + encrypt_email + "&UTID=" + encrypt_token;
//		
//		String link = " Dear Customer:-" + "\n Please follow the link to reset password\n" + resetlink + "";
//		
//		return link;
//	}
//	
//	
//	
//
//	public String decryptData(String encryptedData) throws Exception
//	{
//		String decrypteddata = null;
//		try {
//			
//			decrypteddata = AESEncryption.decrypt(Base64Coder.decodeString(encryptedData));
//		} catch (Exception e) {
//			throw new Exception(
//					"Error while authenticating user data<br>'Invalid Request found'");
//		}
//
//		return decrypteddata;
//	}
//
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		throw new CloneNotSupportedException(this.getClass().getSimpleName()
//				+ " probhited Cloning");
//	}
//}
