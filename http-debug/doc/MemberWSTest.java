/**
 * 描述: 
 * MemberWSTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.member;

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

import java.io.File;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hua.bean.HttpDebugParam;
import com.hua.bean.member.BrandBean;
import com.hua.bean.member.QueryMemberCheckBrandReq;
import com.hua.bean.member.QueryMemberCheckBrandResp;
import com.hua.bean.member.QueryMemberCheckBrandRespWrap;
import com.hua.constant.FormatConstant;
import com.hua.entity.CompanyMemberSaveForm;
import com.hua.http.HttpDebugClient;
import com.hua.param.MemberBrandParam;
import com.hua.test.BaseTest;
import com.hua.util.EmptyUtil;
import com.hua.util.GsonUtil;
import com.hua.util.IOUtil;
import com.hua.util.JacksonUtil;
import com.hua.util.ProjectUtil;
import com.hua.util.StringUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * MemberWSTest
 */
public final class MemberWSTest extends BaseTest {

	protected HttpDebugParam param = new MemberBrandParam();
	
	protected HttpDebugClient client = new HttpDebugClient(param);

	
	
	/**
	 * 
	 * 描述: 测试 post 方法
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetMemberBrand() {
		try {
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			httpClient = HttpClientBuilder.create().build();
			testUrl = "http://192.168.56.94:8080/memberx/memberCheckBrandServices/queryMemberCheckBrand";
			// http get 实例
			httpPost = new HttpPost(testUrl);
			httpPost.addHeader("X-AUTH-HEADER", "D81F1EA5AFE8264FACD9A5FF77B25C63");
			httpPost.setHeader("Accept", "application/json; charset=UTF-8");
			httpPost.setHeader("Content-Type", "application/json;charset=UTF-8;");
			
			//StringEntity entity = new StringEntity("{\"QueryMemberCheckBrandReq\":{\"memberId\":146237607}}");
			BrandBean bean = new BrandBean();
			bean.setMemberId(148392688);
			Calendar cal = Calendar.getInstance();
			bean.setCreateTimeEnd(cal.getTime());
			// 半年前
			cal.add(Calendar.MONTH, -6);
			bean.setCreateTimeBegin(cal.getTime());
			System.out.println(JacksonUtil.writeValueAsStringWithDf(bean));
			StringEntity entity = new StringEntity("{\"QueryMemberCheckBrandReq\":" + JacksonUtil.writeValueAsStringWithDf(bean) + "}");
			
			httpPost.setEntity(entity);
			response = httpClient.execute(httpPost);

			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				// 成功响应 200 ok
				input = response.getEntity().getContent();
				result = StringUtil.streamToString(input);
				JSONObject jsonObject = new JSONObject(result);
				jsonObject = jsonObject.optJSONObject("QueryMemberCheckBrandResp");
				JSONArray array = jsonObject.optJSONArray("result");
				// 移除掉空集合，避免gson解析报错
				if (null == array || array.length() ==0)
				{
					jsonObject.remove("result");
				}
				result = jsonObject.toString();
				QueryMemberCheckBrandResp resp = GsonUtil.fromJson(result, QueryMemberCheckBrandResp.class);
				System.out.println(resp.getReason());
				System.out.println(resp.getStatus());
			}
			
		} catch (Exception e) {
			log.error("testPost =====> ", e);
		}
	}	

	/**
	 * 
	 * 描述: 测试 post 方法
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRegCompanyMember() {
		try {
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			httpClient = HttpClientBuilder.create().build();
			testUrl = "http://localhost:8080/member/new/company/wx/v1";
			// http get 实例
			httpPost = new HttpPost(testUrl);
			//httpPost.setHeader("Accept", "application/json; charset=UTF-8");
			//httpPost.setHeader("Content-Type", "application/json;charset=UTF-8;");
			
			CompanyMemberSaveForm form = new CompanyMemberSaveForm();
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
			
			String json = JacksonUtil.writeValueAsString(form);
			System.out.println(json);
			StringEntity entity = new StringEntity(json);
			
			httpPost.setEntity(entity);
			httpPost.setHeader("name", "zhangsan");
			httpPost.setHeader("companyNo", "123323");
			response = httpClient.execute(httpPost);

			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				// 成功响应 200 ok
				input = response.getEntity().getContent();
				result = StringUtil.streamToString(input);
				System.out.println("响应数据: ");
				System.out.println(result);
			}
			
		} catch (Exception e) {
			log.error("testRegCompanyMember =====> ", e);
		}
	}		

	
	
	/**
	 * 
	 * 描述: 测试 post 方法
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetMemberBrand2() {
		try {
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			httpClient = HttpClientBuilder.create().build();
			testUrl = "http://192.168.56.94:8080/memberx/memberCheckBrandServices/queryMemberCheckBrand";
			// http get 实例
			httpPost = new HttpPost(testUrl);
			httpPost.addHeader("X-AUTH-HEADER", "D81F1EA5AFE8264FACD9A5FF77B25C63");
			httpPost.setHeader("Accept", "application/json; charset=UTF-8");
			httpPost.setHeader("Content-Type", "application/json;charset=UTF-8;");
			
			//StringEntity entity = new StringEntity("{\"QueryMemberCheckBrandReq\":{\"memberId\":146237607}}");
			BrandBean bean = new BrandBean();
			bean.setMemberId(148392688);
			Calendar cal = Calendar.getInstance();
			bean.setCreateTimeEnd(cal.getTime());
			// 半年前
			cal.add(Calendar.MONTH, -6);
			bean.setCreateTimeBegin(cal.getTime());
			//System.out.println(JacksonUtil.writeValueAsStringWithDf(bean));
			StringEntity entity = new StringEntity("{\"QueryMemberCheckBrandReq\":" + JacksonUtil.writeValueAsStringWithDf(bean) + "}");
			
			httpPost.setEntity(entity);
			response = httpClient.execute(httpPost);
			QueryMemberCheckBrandRespWrap wrap = null;
			QueryMemberCheckBrandResp resp = null;
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.setDateFormat(FormatConstant.DATE_TIME_FORMAT_yyyy_MM_dd_HH_mm_ss).create();
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				// 成功响应 200 ok
				input = response.getEntity().getContent();
				
				result = StringUtil.streamToString(input);
				System.out.println(result);
				wrap = gson.fromJson(result, QueryMemberCheckBrandRespWrap.class);
				resp = wrap.getQueryMemberCheckBrandResp();
				System.out.println(resp.getReason());
			}
			
		} catch (Exception e) {
			log.error("testPost =====> ", e);
		}
	}		
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetMemberBrand3() {
		try {
			
			param.setUrl(" http://192.168.56.94:8080/memberx/memberCheckBrandServices/queryMemberCheckBrand");
			//param.setUrl("http://10.50.50.52:7729/UserInterface.asmx");
			param.addHeader("X-AUTH-HEADER", "D81F1EA5AFE8264FACD9A5FF77B25C63");
			QueryMemberCheckBrandReq requestParam = new QueryMemberCheckBrandReq();
			requestParam.setMemberid(123);
			param.setMethod("post");
			param.setBody(JacksonUtil.writeValueAsString(requestParam));
			
			boolean flag = client.post();
			
			log.info("testGetMemberBrand =====> flag = " + flag);
			
		} catch (Exception e) {
			log.error("testGetMemberBrand =====> ", e);
		}
	}	

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFileUpload() {
		boolean flag = false;
		String result = null;
		InputStream inputStrean = null;
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
			param.setUrl("http://localhost:8080/member/new/company/wx/v1");
			param.setName("file");
			param.setFilename("ActionTemplate.java");
			// http get 实例
			final HttpPost httpPost = new HttpPost(param.getUrl());
			// 设置头部
			if (!EmptyUtil.isEmpty(param.getHeaders()))
			{
				final Set<Map.Entry<String, String>> headerEntry = param.getHeaders().entrySet();
			    for (Map.Entry<String, String> e : headerEntry)
			    {
			    	httpPost.setHeader(e.getKey(), e.getValue());
			    }
			}			
			
			// 构造请求主体
			final MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
			String path = null;
			if (StringUtil.isEmpty(param.getUploadPath()))
			{
				// 默认使用 /doc/upload 目录下的指定文件
				path = ProjectUtil.getAbsolutePath("/doc/upload/" + 
				param.getFilename(), true);
			} else
			{
				path = param.getUploadPath();
			}
			// 暂不设置 mimeType 或 ContentType
			final ContentBody contentBody = new FileBody(new File(path));
			log.info("upload =====> name = " + param.getName());
			entityBuilder.addPart(param.getName(), contentBody);
			
			// 设置请求主体
			httpPost.setEntity(entityBuilder.build());
			
			final HttpResponse response = httpClient.execute(httpPost);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode())
			{
				// 成功响应 200 ok
				inputStrean = response.getEntity().getContent();
				result = StringUtil.streamToString(inputStrean);
				log.info("upload =====> 请求成功 ===== 响应数据如下: ");
				System.out.println(result);
			} else
			{
				// 请求失败
				inputStrean = response.getEntity().getContent();
				result = StringUtil.streamToString(inputStrean);
				log.info("请求失败 ===== 响应数据如下:");
				System.out.println(result);				
			}
			flag = true;
		} catch (Exception e)
		{
			log.error("get =====> ", e);
		} finally
		{
			IOUtil.close(inputStrean);
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
