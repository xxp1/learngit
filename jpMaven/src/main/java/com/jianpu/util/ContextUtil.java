package com.jianpu.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 閫氳繃ThreadLocal 鎿嶄綔request,response,session
 * @author 鏉庤�婀�
 */
public class ContextUtil {

	private static  ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();
	private static  ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();
	
	/**
	 * 璁剧疆request
	 */
	public static void setRequest(HttpServletRequest req){
		requestLocal.set(req);
	}
	
	/**
	 * 鑾峰緱request
	 */
	public static HttpServletRequest getRequest(){
		return requestLocal.get();
	}
	/**
	 * 璁剧疆response
	 */
	public static void setResponse(HttpServletResponse res){
		responseLocal.set(res);
	}
	/**
	 * 鑾峰緱response
	 */
	public static HttpServletResponse getResponse(){
		return responseLocal.get();
	}
	
	/**
	 * 鑾峰緱session
	 */
	public static HttpSession getSession(){
		return getRequest().getSession();
	}
	
}
