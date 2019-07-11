/**
 * Project Name:cloudplatform-common
 * File Name:SysRe.java
 * Package Name:org.cloudplatform.common.responseResult
 * Date:2018年5月16日下午6:50:30
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.zhg.common.responseResult;
/**
 * 
 * ClassName: SysResponseResult
 * (全局自定义系统错误--HttpStatus).
 * date: 2018年5月16日 下午6:47:27
 * @author TANCHAO
 * @version
 */
public class SysResponseResult{
	
	/**
     * 
     * failure:(执行失败,无数据返回,返回错误信息).
     * date: 2018年5月16日 下午3:26:16
     * @param resultCode
     * @param data
     * @return
     */
    public static  ResponseResult failure(SysErrorCode SysErrorCode) {
    	ResponseResult result = new ResponseResult();
        result.setSysErrorCode(SysErrorCode);
        return result;
    }
    
    /**
     * 
     * failure:(执行失败,有数据返回,返回错误信息).
     * date: 2018年5月16日 下午3:26:16
     * @param resultCode
     * @param data
     * @return
     */
    public static  ResponseResult failure(SysErrorCode SysErrorCode, Object data) {
    	ResponseResult result = new ResponseResult();
        result.setSysErrorCode(SysErrorCode);
        result.setData(data);
        return result;
    }
    
}
