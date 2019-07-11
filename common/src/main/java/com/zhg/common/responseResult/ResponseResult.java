package com.zhg.common.responseResult;

import java.io.Serializable;

public class ResponseResult implements Serializable {

	private static final long serialVersionUID = 1L;

	//默认成功状态码 msgCode
	public Integer msgCode;
	
	//默认成功message
	public String message;
	
	//数据体
	public Object data;
	
	public Integer getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(Integer msgCode) {
		this.msgCode = msgCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResponseResult() {}

	public ResponseResult(Integer msgCode, String message) {
        this.msgCode = msgCode;
        this.message = message;
//        this.data = data;
    }

	/**
	 * 
	 * success:(执行成功,无数据返回).
	 * date: 2018年5月16日 下午3:24:34
	 * @return
	 */
	public static  ResponseResult success() {
    	ResponseResult result = new ResponseResult();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }
    
    /**
     * 
     * success:(执行成功,有数据返回).
     * date: 2018年5月16日 下午3:25:05
     * @param data
     * @return 
     */
    public static ResponseResult success(Object data) {
    	ResponseResult result = new ResponseResult();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 
     * failure:(执行失败,无数据返回,返回错误信息).
     * date: 2018年5月16日 下午3:25:31
     * @param resultCode
     * @return
     */
    public static  ResponseResult failure(ResultCode resultCode) {
    	ResponseResult result = new ResponseResult();
        result.setResultCode(resultCode);
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
    public static  ResponseResult failure(ResultCode resultCode, Object data) {
    	ResponseResult result = new ResponseResult();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }
    
    /**
     * 
     * failure:(系统运行时异常错误).
     * date: 2018年5月17日 下午1:43:50
     * @param msgCode
     * @param data
     * @return
     */
    public static  ResponseResult failure(Integer msgCode,String message, Object data) {
    	ResponseResult result = new ResponseResult();
        result.setMsgCode(msgCode);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    
    /**
     * 
     * failure:(自定义异常).
     * date: 2018年7月13日 下午2:25:15
     * @param message 自定义异常信息
     * @return
     */
    public static  ResponseResult failure(String message) {
    	ResponseResult result = new ResponseResult();
        result.setMsgCode(-1);
        result.setMessage(message);
        return result;
    }
    
    /**
     * 
     * setResultCode:(解析参数ResultCode).
     * date: 2018年5月16日 下午3:26:34
     * @param code
     */
    public void setResultCode(ResultCode code) {
        this.msgCode = code.msgCode();
        this.message = code.message();
    }
    
    /**
     * 
     * SysErrorCode:(解析参数SysErrorCode).
     * date: 2018年5月16日 下午3:26:34
     * @param code
     */
    public void setSysErrorCode(SysErrorCode code) {
        this.msgCode = code.msgCode();
        this.message = code.message();
    }
    
}

