/**
 * 描述: 
 * PersonController.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.controller.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hua.bean.Person;
import com.hua.bean.PersonSearchBean;
import com.hua.bean.ResultBean;
import com.hua.bean.SimplePersonSearchBean;
import com.hua.controller.BaseController;
import com.hua.util.DateTimeUtil;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * PersonController
 */
// 控制器
@Controller
@RequestMapping(value={"/PersonController"}, method = RequestMethod.GET)
//@RequestMapping(value={"/"})
public final class PersonController extends BaseController
{
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/get"}, method = {RequestMethod.GET})
	@ResponseBody
	public ResultBean get(final HttpServletRequest request, 
			final HttpServletResponse response, final PersonSearchBean searchBean) {
		
		log.info("get =====> name = " + searchBean.getName());
		log.info("get =====> password = " + searchBean.getPassword());
		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		Person person = new Person();
		person.setId("2001");
		person.setUsername("王东22");
		// 时间戳
		// "lastLoginTime":1455591443154
		person.setLastLoginTime(DateTimeUtil.getTimestamp());
		// "utilDate":1455591443154
		person.setUtilDate(DateTimeUtil.getDateTime());
		// "sqlDate":"2016-02-16"
		person.setSqlDate(DateTimeUtil.getDate());
		result.setData(person);
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/get2"}, method = {RequestMethod.GET})
	@ResponseBody
	public ResultBean get2(final HttpServletRequest request, 
			final HttpServletResponse response, final PersonSearchBean searchBean) {
		
		log.info("get2 =====> name = " + searchBean.getName());
		log.info("get2 =====> password = " + searchBean.getPassword());
		log.info("get2 =====> address = " + searchBean.getQueryBean().getAddress());
		log.info("get2 =====> salary = " + searchBean.getQueryBean().getSalary());
		//log.info("get2 =====> startDt = " + searchBean.getDtBetween().getStartDateTime());
		//log.info("get2 =====> endDt = " + searchBean.getDtBetween().getEndDateTime());
		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		Person person = new Person();
		person.setId("2001");
		person.setUsername("王东22");
		// 时间戳
		// "lastLoginTime":1455591443154
		person.setLastLoginTime(DateTimeUtil.getTimestamp());
		// "utilDate":1455591443154
		person.setUtilDate(DateTimeUtil.getDateTime());
		// "sqlDate":"2016-02-16"
		person.setSqlDate(DateTimeUtil.getDate());
		result.setData(person);
		
		return result;
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/get3"}, method = {RequestMethod.GET})
	@ResponseBody
	public ResultBean get3(final HttpServletRequest request, 
			final HttpServletResponse response, final PersonSearchBean searchBean) {
		
		log.info("get3 =====> name = " + searchBean.getName());
		log.info("get3 =====> password = " + searchBean.getPassword());
		log.info("get3 =====> address = " + searchBean.getQueryBean().getAddress());
		log.info("get3 =====> salary = " + searchBean.getQueryBean().getSalary());
		log.info("get3 =====> startDt = " + searchBean.getDtBetween().getStartDateTime());
		log.info("get3 =====> endDt = " + searchBean.getDtBetween().getEndDateTime());
		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		Person person = new Person();
		person.setId("2001");
		person.setUsername("王东22");
		// 时间戳
		// "lastLoginTime":1455591443154
		person.setLastLoginTime(DateTimeUtil.getTimestamp());
		// "utilDate":1455591443154
		person.setUtilDate(DateTimeUtil.getDateTime());
		// "sqlDate":"2016-02-16"
		person.setSqlDate(DateTimeUtil.getDate());
		result.setData(person);
		
		return result;
	}		
	
	/**
	 * 
	 * @description 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @param address
	 * @param no
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping(value={"/getMultipleParam"}, method = {RequestMethod.GET})
	@ResponseBody
	public ResultBean getMultipleParam(final HttpServletRequest request, 
			final HttpServletResponse response,  final String address, final Integer no) {
		
/*		log.info("getMultipleParam =====> name = " + searchBean.getName());
		log.info("getMultipleParam =====> password = " + searchBean.getPassword());*/
		ResultBean result = new ResultBean();
		//		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessage("收到[" + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		Person person = new Person();
		person.setId("2001");
		person.setUsername("王东22");
		// 时间戳
		// "lastLoginTime":1455591443154
		person.setLastLoginTime(DateTimeUtil.getTimestamp());
		// "utilDate":1455591443154
		person.setUtilDate(DateTimeUtil.getDateTime());
		// "sqlDate":"2016-02-16"
		person.setSqlDate(DateTimeUtil.getDate());
		result.setData(person);
		
		return result;
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/postNotInBody"}, method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean postNotInBody(final HttpServletRequest request, 
			final HttpServletResponse response, final PersonSearchBean searchBean) {
		/*
		 * @RequestBody 注解: 处理放在请求消息体中的报文，格式由客户端的Content-Type参数决定
		 */
		log.info("postNotInBody =====> name = " + searchBean.getName());
		log.info("postNotInBody =====> password = " + searchBean.getPassword());
		log.info("postNotInBody =====> address = " + searchBean.getQueryBean().getAddress());

		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/postInBody"}, method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean postInBody(final HttpServletRequest request, 
			final HttpServletResponse response, @RequestBody(required = true) final PersonSearchBean searchBean) {
		/*
		 * @RequestBody 注解: 处理放在请求消息体中的报文，格式由客户端的Content-Type参数决定
		 */
		log.info("postInBody =====> name = " + searchBean.getName());
		log.info("postInBody =====> password = " + searchBean.getPassword());
		log.info("postInBody =====> address = " + searchBean.getQueryBean().getAddress());
		log.info("postInBody =====> salary = " + searchBean.getQueryBean().getSalary());
		log.info("postInBody =====> startDt = " + searchBean.getDtBetween().getStartDateTime());
		log.info("postInBody =====> endDt = " + searchBean.getDtBetween().getEndDateTime());

		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		
		return result;
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/postJsonV1"}, method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean postJsonV1(final HttpServletRequest request, 
			final HttpServletResponse response, @RequestBody(required = true) final PersonSearchBean searchBean) {
		/*
		 * @RequestBody 注解: 处理放在请求消息体中的报文，格式由客户端的Content-Type参数决定
		 */
		log.info("postJsonV1 =====> name = " + searchBean.getName());
		log.info("postJsonV1 =====> password = " + searchBean.getPassword());
		if (null != searchBean.getQueryBean())
		{
			log.info("postJsonV1 =====> address = " + searchBean.getQueryBean().getAddress());
			log.info("postJsonV1 =====> salary = " + searchBean.getQueryBean().getSalary());
		}
		if (null != searchBean.getDtBetween())
		{
			log.info("postJsonV1 =====> startDt = " + searchBean.getDtBetween().getStartDateTime());
			log.info("postJsonV1 =====> endDt = " + searchBean.getDtBetween().getEndDateTime());
		}

		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		
		return result;
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/postXmlV1"}, method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean postXmlV1(final HttpServletRequest request, 
			final HttpServletResponse response, @RequestBody(required = true) final PersonSearchBean searchBean) {
		/*
		 * @RequestBody 注解: 处理放在请求消息体中的报文，格式由客户端的Content-Type参数决定
		 */
		log.info("postXmlV1 =====> name = " + searchBean.getName());
		log.info("postXmlV1 =====> password = " + searchBean.getPassword());
		if (null != searchBean.getQueryBean())
		{
			log.info("postXmlV1 =====> address = " + searchBean.getQueryBean().getAddress());
			log.info("postXmlV1 =====> salary = " + searchBean.getQueryBean().getSalary());
		}
		if (null != searchBean.getDtBetween())
		{
			log.info("postXmlV1 =====> startDt = " + searchBean.getDtBetween().getStartDateTime());
			log.info("postXmlV1 =====> endDt = " + searchBean.getDtBetween().getEndDateTime());
		}

		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		
		return result;
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/postInBodyForXml1"}, method = {RequestMethod.POST})
	@ResponseBody
	public ResultBean postInBodyForXml1(final HttpServletRequest request, 
			final HttpServletResponse response, @RequestBody(required = true) final SimplePersonSearchBean searchBean) {
		/*
		 * @RequestBody 注解: 处理放在请求消息体中的报文，格式由客户端的Content-Type参数决定
		 */
		log.info("postInBodyForXml1 =====> name = " + searchBean.getName());
		log.info("postInBodyForXml1 =====> password = " + searchBean.getPassword());
		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		
		return result;
	}		
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/getAndPost"}, method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResultBean getAndPost(final HttpServletRequest request, 
			final HttpServletResponse response, final PersonSearchBean searchBean) {
		log.info("getAndPost =====> name = " + searchBean.getName());
		log.info("getAndPost =====> password = " + searchBean.getPassword());
		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value={"/search"}, method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ResultBean search(final HttpServletRequest request, 
			final HttpServletResponse response, final PersonSearchBean searchBean) {
		ResultBean result = new ResultBean();
		result.setMessage("收到[" + searchBean.getName() + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		
		return result;
	}
	
}
