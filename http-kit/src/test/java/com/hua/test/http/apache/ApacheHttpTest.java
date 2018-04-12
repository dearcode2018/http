/**
 * ApacheHttpTest.java
 * @author qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.test.http.apache;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.StringUtil;

/**
 * ApacheHttpTest
 * 描述: 
 * @author qye.zheng
 * 
 */
public final class ApacheHttpTest extends BaseTest
{
	/**
	 * 
	 * 描述: 测试 get 方法
	 * @author qye.zheng
	 * 
	 */
	//@Test
	public void testGet() {
		try {
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			httpClient = HttpClientBuilder.create().build();
			// http get 实例
			httpGet = new HttpGet(testUrl + "?param=" + "zhangsan");
			response = httpClient.execute(httpGet);
			
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				// 成功响应 200 ok
				input = response.getEntity().getContent();
				result = StringUtil.streamToString(input);
				log.info("testGet =====> result = " + result );
				
			}
			
			
			
		} catch (Exception e) {
			log.error("testGet =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 测试 post 方法
	 * @author qye.zheng
	 * 
	 */
	//@Test
	public void testPost() {
		try {
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			httpClient = HttpClientBuilder.create().build();

			// http get 实例
			httpPost = new HttpPost(testUrl + "?param=" + "zhangsan");
			response = httpClient.execute(httpPost);
			
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				// 成功响应 200 ok
				input = response.getEntity().getContent();
				result = StringUtil.streamToString(input);
				log.info("testPost =====> result = " + result );
				
			}
			
		} catch (Exception e) {
			log.error("testPost =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 测试接口
	 * @author qye.zheng
	 * 
	 */
	//@Test
	public void testInterface() {
		try {
			testUrl = "http://127.0.0.1:8080/gsm/api/ocr/memberActivate?data=aWQlM0Q0OTBmZTM4Ni0yYjgwLTRmZjEtOTQxMy0xZTQzNGJiNzI2MGUlMjZjaGVja0NvZGUlM0Q0NTc5NTIlMjZpbnZhbGlkVHMlM0QxMzk4MzA5NDI1MzM5";
			httpClient = HttpClientBuilder.create().build();

			// http get 实例
			httpGet = new HttpGet(testUrl);
			response = httpClient.execute(httpGet);
			
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				// 成功响应 200 ok
				input = response.getEntity().getContent();
				result = StringUtil.streamToString(input);
				log.info("testInterface =====> result = " + result );
				
			}
			
			
		} catch (Exception e) {
			log.error("testInterface =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@Test
	public void testTemp() {
		try {
			
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}

}
