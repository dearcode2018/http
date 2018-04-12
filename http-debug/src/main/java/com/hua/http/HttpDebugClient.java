/**
  * @filename HttpDebugClient.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.SerializableEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;

import com.hua.bean.HttpDebugParam;
import com.hua.util.EmptyUtil;
import com.hua.util.IOUtil;
import com.hua.util.ProjectUtil;
import com.hua.util.StringUtil;

 /**
 * @type HttpDebugClient
 * @description  
 * @author qye.zheng
 */
public final class HttpDebugClient {
	
	/* apache commons log */
	protected Log log = LogFactory.getLog(this.getClass().getName());
	
	private HttpDebugParam param;
	
	/**
	 * @description 构造方法
	 * @author qye.zheng
	 */
	public HttpDebugClient(final HttpDebugParam param)
	{
		this.param = param;
	}
	
	/**
	 * 
	 * 描述: get 请求
	 * @author  qye.zheng
	 * @return
	 */
	public final boolean get()
	{
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
			// http get 实例
			final HttpGet httpGet = new HttpGet(param.getUrl());
			//httpGet.setHeader("Content-Type", param.getContentType());
			//httpGet.setHeader("Accept", "application/xml");
			// 设置头部
			if (!EmptyUtil.isEmpty(param.getHeaders()))
			{
				final Set<Map.Entry<String, String>> headerEntry = param.getHeaders().entrySet();
			    for (Map.Entry<String, String> e : headerEntry)
			    {
			    	httpGet.setHeader(e.getKey(), e.getValue());
			    }
			}
			/* 查询参数 http://127.0.0.1:8080/appName/suffixPath?a=1&b=2 */
			if (!EmptyUtil.isEmpty(param.getHeaders()))
			{
				final StringBuilder queryParamBuilder = StringUtil.getBuilder();
				final Set<Map.Entry<String, String>> queryEntry = param.getQueryParams().entrySet();
				for (Map.Entry<String, String> e : queryEntry)
			    {
					queryParamBuilder.append(e.getKey() + "=" + e.getValue() + "&");
			    }
				// 去掉最后一个 &
				queryParamBuilder.replace(queryParamBuilder.length() - 1, 
						queryParamBuilder.length(), "");
				log.info("get =====> queryParam = " + queryParamBuilder.toString());
				// 拼接到 url
				param.setUrl(param.getUrl() + "?" + queryParamBuilder.toString());
			}
			final HttpResponse response = httpClient.execute(httpGet);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode())
			{
				// 成功响应 200 ok
				inputStrean = response.getEntity().getContent();
				result = StringUtil.streamToString(inputStrean);
				log.info("get =====> 请求成功 ===== 响应数据如下: ");
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

		return flag;
	}

	/**
	 * 
	 * 描述: post 请求
	 * @author  qye.zheng
	 * @return
	 */
	public final boolean post()
	{
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
			// http get 实例
			final HttpPost httpPost = new HttpPost(param.getUrl());
			System.out.println(param.getUrl());
			// 设置头部
			if (!EmptyUtil.isEmpty(param.getHeaders()))
			{
				final Set<Map.Entry<String, String>> headerEntry = param.getHeaders().entrySet();
			    for (Map.Entry<String, String> e : headerEntry)
			    {
			    	httpPost.setHeader(e.getKey(), e.getValue());
			    }
			}
			final HttpEntity stringEntity = new SerializableEntity(param.getBody());
			// 设置请求主体
			httpPost.setEntity(stringEntity);
			
			final HttpResponse response = httpClient.execute(httpPost);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode())
			{
				// 成功响应 200 ok
				inputStrean = response.getEntity().getContent();
				result = StringUtil.streamToString(inputStrean);
				log.info("post =====> 请求成功 ===== 响应数据如下: ");
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
		
		return flag;
	}		
	
	/**
	 * 
	 * 描述: 文件上传
	 * 
	 * @author qye.zheng
	 * @return
	 */
	public final boolean upload()
	{
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
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @return
	 */
	public final boolean download()
	{
		boolean flag = false;
		String result = null;
		InputStream inputStrean = null;
		OutputStream outputStream = null;
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
			final HttpGet httpGet = new HttpGet(param.getUrl());
			// 设置头部
			if (!EmptyUtil.isEmpty(param.getHeaders()))
			{
				final Set<Map.Entry<String, String>> headerEntry = param.getHeaders().entrySet();
			    for (Map.Entry<String, String> e : headerEntry)
			    {
			    	httpGet.setHeader(e.getKey(), e.getValue());
			    }
			}
			/* 查询参数 http://127.0.0.1:8080/appName/suffixPath?a=1&b=2 */
			if (!EmptyUtil.isEmpty(param.getHeaders()))
			{
				final StringBuilder queryParamBuilder = StringUtil.getBuilder();
				final Set<Map.Entry<String, String>> queryEntry = param.getQueryParams().entrySet();
				for (Map.Entry<String, String> e : queryEntry)
			    {
					queryParamBuilder.append(e.getKey() + "=" + e.getValue() + "&");
			    }
				// 去掉最后一个 &
				queryParamBuilder.replace(queryParamBuilder.length() - 1, 
						queryParamBuilder.length(), "");
				log.info("download =====> queryParam = " + queryParamBuilder.toString());
				// 拼接到 url
				param.setUrl(param.getUrl() + "?" + queryParamBuilder.toString());
			}			
			final HttpResponse response = httpClient.execute(httpGet);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode())
			{
				// response.setHeader("Content-Disposition", "attachment; filename=" + fileName);  
				final String contentDisposition = response.getFirstHeader("Content-Disposition").getValue();
				final String filename = contentDisposition
						.substring(contentDisposition.lastIndexOf("filename=") + "filename=".length());
				log.info("download =====> filename = " + filename);
				outputStream = new FileOutputStream(param.getDownloadPath() + filename);
				// 成功响应 200 ok
				inputStrean = response.getEntity().getContent();
				System.out.println("请求成功 ===== 响应数据如下: ");
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
			IOUtil.close(outputStream);
			IOUtil.close(inputStrean);
		}
		
		return flag;
	}	
}
