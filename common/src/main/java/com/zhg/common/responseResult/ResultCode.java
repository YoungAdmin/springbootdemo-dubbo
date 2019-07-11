/**
 * Project Name:cloudplatform-common
 * File Name:ResultCode.java
 * Package Name:org.cloudplatform.common.Result
 * Date:2018年5月16日下午2:51:36
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/
package com.zhg.common.responseResult;

public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(1, "成功"),

    /* 参数错误：10001-19999 */
    /**
     * 10001, "参数无效"
     */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),
    PARAM_INCORRECT_REQUEST(10005, "请求参数类型有误")

	;

	/**
	 * 初始化构造
	 */
	private Integer msgCode;

    private String message;

    ResultCode(Integer msgCode, String message) {
        this.msgCode = msgCode;
        this.message = message;
    }

    public Integer msgCode() {
        return this.msgCode;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.msgCode;
            }
        }
        return null;
    }
    
    public Integer isSuccess() {
    	
    	return SUCCESS.msgCode;
    }

    @Override
    public String toString() {
        return this.name();
    }
	
}

