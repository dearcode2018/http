/**
 * 描述: 
 * HttpClientTemplateTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package template.code;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.StringUtil;


/**
 * 描述: Http客户端
 * 
 * @author qye.zheng
 * HttpClientTemplateTest
 */
public final class HttpClientTemplateTest extends BaseTest {

	
	/**
	 * 
	 * 描述: get 请求
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testHttpGet() {
		try {
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			// 服务地址
			String url = null;
			// 构建Http客户端
			final HttpClient httpClient = HttpClientBuilder.create().build();
			// 创建get请求实例
			final HttpGet httpGet = new HttpGet(url);
			// get请求实例配置
			httpGet.setConfig(null);
			// 设置请求参数
			
			// 执行请求
			final HttpResponse response = httpClient.execute(httpGet);
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			// 设置响应 可接收类型
			response.setHeader("Accept", "application/json");
			InputStream inputStream = null;
			String result = null;
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				// 成功响应 200 ok
				inputStream = response.getEntity().getContent();
				result = StringUtil.streamToString(inputStream);
				System.out.println("响应: ");
				System.out.println(result);
			}
			
		} catch (Exception e) {
			log.error("testHttpGet =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: post请求
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testHttpPost() {
		try {
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			// 服务地址
			String url = null;
			final HttpClient httpClient = HttpClientBuilder.create().build();
			// http get 实例
			final HttpPost httpPost = new HttpPost(url);
			final HttpResponse response = httpClient.execute(httpPost);
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			// 设置响应 可接收类型
			response.setHeader("Accept", "application/json");
			InputStream inputStream = null;
			String result = null;
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				// 成功响应 200 ok
				inputStream = response.getEntity().getContent();
				result = StringUtil.streamToString(inputStream);
				System.out.println("响应: ");
				System.out.println(result);
			}			
			
		} catch (Exception e) {
			log.error("testHttpPost =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 文件上传 post请求
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFileUpload() {
		try {
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			// 服务地址
			String url = null;
			final HttpClient httpClient = HttpClientBuilder.create().build();
			// http get 实例
			final HttpPost httpPost = new HttpPost(url);
			final HttpResponse response = httpClient.execute(httpPost);
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			// 设置响应 可接收类型
			response.setHeader("Accept", "application/json");
			InputStream inputStream = null;
			String result = null;
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				// 成功响应 200 ok
				inputStream = response.getEntity().getContent();
				result = StringUtil.streamToString(inputStream);
				System.out.println("响应: ");
				System.out.println(result);
			}		
			
		} catch (Exception e) {
			log.error("testFileUpload =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 文件下载 get请求
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFileDownload() {
		try {
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			// 服务地址
			String url = null;
			final HttpClient httpClient = HttpClientBuilder.create().build();
			// http get 实例
			final HttpGet httpGet = new HttpGet(url);
			httpGet.setConfig(null);
			final HttpResponse response = httpClient.execute(httpGet);
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			// 设置响应 可接收类型
			response.setHeader("Accept", "application/json");
			InputStream inputStream = null;
			String result = null;
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				// 成功响应 200 ok
				inputStream = response.getEntity().getContent();
				response.setHeader(result, result);
				result = StringUtil.streamToString(inputStream);
				System.out.println("响应: ");
				System.out.println(result);
			}			
			
		} catch (Exception e) {
			log.error("testFileDownload =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
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
	@Test
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
	@Test
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
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
