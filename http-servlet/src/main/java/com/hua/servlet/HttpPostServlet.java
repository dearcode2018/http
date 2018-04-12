/**
 * HttpPostServlet.java
 * @author qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hua.constant.Constant;
import com.hua.controller.BaseServlet;
import com.hua.entity.User;
import com.hua.util.DateTimeUtil;

/**
 * HttpPostServlet
 * 描述: 
 * @author qye.zheng
 * 
 */
// 使用注解的方式 ( http://127.0.0.1:8080/servlet3/HttpPostServlet )
@WebServlet(name="HttpPostServlet", urlPatterns={"/HttpPostServlet"})
public final class HttpPostServlet extends BaseServlet
{
	 /* long */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * 转发到指定 Servlet 或 Jsp 页面 (传递 请求和响应 对象)
	 * 将本次请求传递给其他处理逻辑或资源，然后再进行响应
	 * 始终在本次请求中进行
	 * 
	 * 
	 * 重定向 (通知客户端，根据本次响应提供的地址再次发请求)
	 * 通知客户端再创建新的请求
	 * 本次请求结束之后，将发生新的请求
	 * 
	 * 
	 * 实例值 :  			127.0.0.1												8080									/servlet3
	 * 	获取方法 : request.getServerName() + ":" + request.getServerPort() + request.getContextPath()
	 * 
	 * 
	 */
	
	
	/**
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException
	{
		log.info("doPost =====> ");
		final String username = request.getParameter("username");
		
		User user = new User();
		user.setUsername(username);
		user.setLastLoginIp("192.168.2.56");
		user.setLastLoginTime(DateTimeUtil.getTimestamp());
		user.setPassword("123456");
		user.setNickname("青儿");
		
		final String result = objectWriter.writeValueAsString(user);
		
		//response.setContentType("application/json");
		
		response.setCharacterEncoding(Constant.CHART_SET_UTF_8);
		
		// 设置响应
		response.getWriter().write(result);
		
		// get / post 处理逻辑
		// 请求对象 - 设置属性
		//request.setAttribute("user", user);
		
		// 转发到指定 Servlet 或 Jsp 页面 (传递 请求和响应 对象)
		// forwardUrl = "/front/el/ExpLang.jsp";
		// request.getRequestDispatcher(forwardUrl).forward(request, response);
		
		// 重定向 (通知客户端，根据本次响应提供的地址再次发请求)
		// redirectUrl = "";
		// response.sendRedirect(redirectUrl);
	}
	
	/**
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException
	{
		log.info("doGet =====> ");
		// 调用 doPost 方法
		this.doPost(request, response);
	}
	
}
