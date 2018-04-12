/**
  * @filename Struts2CoreParam.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.param;

import com.hua.bean.HttpDebugParam;

 /**
 * @type Struts2CoreParam
 * @description  
 * @author qye.zheng
 */
public final class Struts2CoreParam extends HttpDebugParam {

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public String getContextPath() {
		return "/struts2-core";
	}

}
