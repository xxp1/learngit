package com.jianpu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.Test;

import com.jianpu.util.CodeUtil;

/**
 *
 * @author Administrator
 */
public class Send {

    public static String SMS(String postData, String postUrl) {
        try {
            
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();

           
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return "";
            }
            
           
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String result = null;
			String line;
			while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "";
    }
    
    @Test
    public void test() throws UnsupportedEncodingException{
    	 String code = CodeUtil.getCode(4);
    	 System.out.println(code);
    	 String PostData = "account=xxp982460&password=xxp982460&mobile=18511748467&content="+URLEncoder.encode("您的验证码是："+code+"。如需帮助请联系客服。","utf-8");
         //out.println(PostData);
         String ret = Send.SMS(PostData, "http://sms.106jiekou.com/utf8/sms.aspx");
         System.out.println(ret);
    	
    }
}
