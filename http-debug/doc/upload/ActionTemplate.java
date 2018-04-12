/**
 * 描述: 
 * ActionTemplate.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package template.code;

import com.hua.action.BaseAction;
import com.hua.util.StringUtil;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * ActionTemplate
 */
public final class ActionTemplate extends BaseAction
{
	/* long */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @return
	 */
	public String temp() {
		try
		{
			// 调用该方法，读取流数据完毕，流将关闭(注意)!
			final String dataFromClient = StringUtil.streamToString(request.getInputStream());
			log.info("temp =====> dataFromClient = " + dataFromClient);
			
			return SUCCESS;
		} catch (Exception e)
		{
			log.error("temp =====> ", e);
		}
		
		return INPUT;
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @return
	 */
	public String test() {
		try
		{
			// 调用该方法，读取流数据完毕，流将关闭(注意)!
			final String dataFromClient = StringUtil.streamToString(request.getInputStream());
			log.info("temp =====> dataFromClient = " + dataFromClient);
			
			return SUCCESS;
		} catch (Exception e)
		{
			log.error("test =====> ", e);
		}
		
		return INPUT;
	}
	
	/**
	 * 描述: 默认执行此方法
	 * 
	 * action 配置中若不指定 method，则调用此方法
	 * @author qye.zheng
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public String execute() throws Exception
	{
		// 调用该方法，读取流数据完毕，流将关闭(注意)!
		final String dataFromClient = StringUtil.streamToString(request.getInputStream());
		log.info("execute =====> dataFromClient = " + dataFromClient);
		
		
		return SUCCESS;
	}
	
}
