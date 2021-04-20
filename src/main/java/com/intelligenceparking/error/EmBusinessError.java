package com.intelligenceparking.error;

/**
 * The enum Em business error.
 */
public enum EmBusinessError implements CommonError {
    /**
     * Parameter validation error em business error.
     */
//通用错误类型10001
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    /**
     * Unknow error em business error.
     */
    UNKNOW_ERROR(10002, "未知错误"),

    /**
     * User not exist em business error.
     */
//20000开头为用户信息相关的错误定义
    USER_NOT_EXIST(20001, "用户不存在"),
    /**
     * User login fail em business error.
     */
    USER_LOGIN_FAIL(20002, "手机号或密码错误"),

    /**
     * Parking slot not usable em business error.
     */
//30000开头为订单信息错误
    PARKING_SLOT_NOT_USABLE(30001, "停车位不可用"),
    /**
     * Picture recon error em business error.
     */
    PICTURE_EMPTY(40001, "穿上图片文件为空"),
    /**
     * Can not recognize the picture
     */
    PICTURE_NOT_RECONIZE(400002, "图像识别错误");

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;

    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        StringBuffer stringBuilder = new StringBuffer(errMsg);
        this.errMsg = stringBuilder.toString();
        return this;
    }
}
