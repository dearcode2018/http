/**
 * 描述: 
 * FileActionTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.struts2.core;

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

import java.io.Serializable;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * FileActionTest
 */
public final class FileActionTest extends Struts2CoreTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Before
	public void beforeMethod() {
		try {
			// 控制器级 url
			String controlUrl = "/api/file/";
			
			param.setSuffixPath(controlUrl);
			
		} catch (Exception e) {
			log.error("beforeMethod =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUpload() {
		try {
			// 方法级 url
			String methodUrl = "/upload.action";
			
			param.setSuffixPath(param.getSuffixPath() + methodUrl);
			param.setName("upload");
			// 设置请求头、查询参数(get方法)、请求主体(post方式)
			param.addHeader("version", "1.0");
			param.addQueryParam("name", "zhangsan");
			Serializable body = "{\"user.username\":\"admin\", \"user.password\":\"123456\"}";
			
			param.setBody(body);
			
			param.setFilename("ActionTemplate.java");
			
			// 执行请求
			client.upload();
			
		} catch (Exception e) {
			log.error("testUpload =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDownload() {
		try {
			// 方法级 url
			String methodUrl = "/download.action";
			
			param.setSuffixPath(param.getSuffixPath() + methodUrl);
			
			// 设置请求头、查询参数(get方法)、请求主体(post方式)
			param.addHeader("version", "1.0");
			param.addQueryParam("name", "zhangsan");
			Serializable body = "{\"user.username\":\"admin\", \"user.password\":\"123456\"}";
			
			param.setBody(body);
			
			// 执行请求
			client.download();
			
		} catch (Exception e) {
			log.error("testDownload =====> ", e);
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
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@After
	public void afterMethod() {
		try {
			
			
		} catch (Exception e) {
			log.error("afterMethod =====> ", e);
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
