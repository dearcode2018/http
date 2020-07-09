/**
 * 描述: 
 * FormTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.http.form;

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
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.entity.CompanyMemberSaveForm;
import com.hua.test.BaseTest;
import com.hua.util.BeanUtil;
import com.hua.util.StringUtil;

/**
 * 描述:
 * 
 * @author qye.zheng FormTest
 */
public final class FormTest extends BaseTest {

	/**
	 * 
	 * 描述:
	 * 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testForm2() {
		try {
			String url = "";
			//PostMethod postMethod = new PostMethod(url);
			NameValuePair[] data = new NameValuePair[10];

			/*
			 * Enumeration keys = pdata.keys(); int i = 0; for (;
			 * keys.hasMoreElements();) { String k = (String)
			 * keys.nextElement(); String v = (String) pdata.get(k); data[i] =
			 * new NameValuePair(k, v); i++; }
			 */
			//postMethod.setRequestBody(data);

		} catch (Exception e) {
			log.error("testForm =====> ", e);
		}
	}

	/**
	 * 
	 * 描述:
	 * 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testForm() {
		try {
			CompanyMemberSaveForm form = new CompanyMemberSaveForm();
			form.setSellerID(270588);
			// 个人信息
			form.setName("王帮主233");
			form.setPhone("15913165901");
			form.setEmail("dearabdddc13sdf23333@qq.com");
			form.setIdNo("54222619861029421X");
			// 微信
			form.setOpenId("wx_1234343");
			form.setWxImg("/weixin/img/photo.jpg");

			// 门店
			form.setStoreId(RandomUtils.nextInt(99999));

			// 公司信息
			form.setCompanyName("广东农业1号产业公司2");
			form.setCompanyNo("dsafdsdsaf");
			//
			form.setCompanyCardNo("90912610");
			form.setCompanyNoImg("/data/picture/abc.jpg");
			form.setContractImg("/data/picture/contact.jpg");
			form.setPayName("dearwang_pay");
			form.setInvoiceName("发票抬头123400");
			// 邮寄地址
			form.setInvoiceAddress("广东省广州市天河区科韵路123号");

			// 联系人
			form.setConcatName("张三");
			form.setConcatMail("dearzhangsan@qq.com");
			form.setConcatPhone("15032657845");

			String url = "http://localhost:8080/member/new/company/wx/v1";
			PostMethod postMethod = new PostMethod(url);
			Map<String, Object> map = BeanUtil.bean2Map(form, true);
			Set<String> keySet = map.keySet();
			NameValuePair[] data = new NameValuePair[keySet.size()];
			int i = 0;
			for (String key : keySet) {
				data[i++] = new NameValuePair(key, map.get(key).toString());
			}
			postMethod.setRequestBody(data);
			postMethod.getParams().setParameter(
					HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			HttpClient httpClient = new HttpClient();

			int statusCode = httpClient.executeMethod(postMethod);
			if (HttpStatus.SC_OK == statusCode) {
				InputStream inputStream = postMethod.getResponseBodyAsStream();
				String result = StringUtil.streamToString(inputStream);
				System.out.println("响应消息: ");
				System.out.println(result);
			}

		} catch (Exception e) {
			log.error("testForm =====> ", e);
		}
	}

	/**
	 * 
	 * 描述:
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
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
