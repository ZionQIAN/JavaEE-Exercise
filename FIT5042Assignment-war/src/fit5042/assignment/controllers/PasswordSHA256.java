package fit5042.assignment.controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordSHA256 {
	    /**
	     * 传入文本内容，返回 SHA-256 串
	     * 
	     * @param strText
	     * @return
	     */
	    public String SHA256(String strText) {
	        return SHA(strText, "SHA-256");
	    }

	    /**
	     * 字符串 SHA 加密
	     * 
	     * @param strSourceText
	     * @return
	     */
	    private String SHA(String strText, String strType) {
	        // 返回值
	        String strResult = null;

	        // 是否是有效字符串
	        if (strText != null && strText.length() > 0) {
	            try {
	                // SHA 加密开始
	                // 创建加密对象 并傳入加密類型
	                MessageDigest messageDigest = MessageDigest.getInstance(strType);
	                // 传入要加密的字符串
	                messageDigest.update(strText.getBytes());
	                // 得到 byte 類型结果
	                byte byteBuffer[] = messageDigest.digest();

	                // 將 byte 轉換爲 string
	                StringBuffer strHexString = new StringBuffer();
	                // 遍歷 byte buffer
	                for (int i = 0; i < byteBuffer.length; i++) {
	                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
	                    if (hex.length() == 1) {
	                        strHexString.append('0');
	                    }
	                    strHexString.append(hex);
	                }
	                // 得到返回結果
	                strResult = strHexString.toString();
	            } catch (NoSuchAlgorithmException e) {
	                e.printStackTrace();
	            }
	        }

	        return strResult;
	    }
	    
	    public String generatePassword(String password) {
	    	PasswordSHA256 sha = new PasswordSHA256();
	        String SHAPasswordString = sha.SHA256(password);
	        return SHAPasswordString;
	    }

	}

