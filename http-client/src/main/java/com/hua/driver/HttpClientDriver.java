/**
 * 描述: 
 * HttpClientDriver.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.driver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import com.hua.bean.http.HttpClientParam;
import com.hua.util.StringUtil;


/**
 * 描述: HTTP 客户端 - 驱动器
 * @author  qye.zheng
 * HttpClientDriver
 */
public class HttpClientDriver
{
	private static final HttpClientParam param = HttpClientParam.getInstance();
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	private HttpClientDriver()
	{
	}
	
	/**
	 * 
	 * 描述: get 请求
	 * @author  qye.zheng
	 * @return
	 */
	public static final boolean handleGetRequest()
	{
		boolean flag = false;
		try
		{
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			final HttpClient httpClient = HttpClientBuilder.create().build();
			// http get 实例
			final HttpGet httpGet = new HttpGet(param.getRequestUrl());
			httpGet.setConfig(null);
			final HttpResponse response = httpClient.execute(httpGet);
			// 设置响应 可接收类型
			response.setHeader("Accept", param.getContentType());
			InputStream inputStream = null;
			String result = null;
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				// 成功响应 200 ok
				inputStream = response.getEntity().getContent();
				//response.setHeader(result, result);
				result = StringUtil.streamToString(inputStream);
			}
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: post 请求
	 * @author  qye.zheng
	 * @return
	 */
	public static final boolean handlePostRequest()
	{
		boolean flag = false;
		try
		{
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			final HttpClient httpClient = HttpClientBuilder.create().build();
			// http get 实例
			final HttpPost httpPost = new HttpPost(param.getRequestUrl());
			final HttpResponse response = httpClient.execute(httpPost);
			// 设置响应 可接收类型
			response.setHeader("Accept", param.getContentType());
			InputStream inputStream = null;
			String result = null;
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				// 成功响应 200 ok
				inputStream = response.getEntity().getContent();
				result = StringUtil.streamToString(inputStream);
			}
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @return
	 */
	public static final boolean template()
	{
		boolean flag = false;
		try
		{
			
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
}
