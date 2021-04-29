package com.intelligenceparking.response;

/**
 * The type Common return type.
 */
public class CommonReturnType {
  //表明对应请求的返回处理结果，有success或fail
  private String status;
  //若fail，包含错误信息；若success，为null
  private String message;
  //若fail，为null；若success,包含对应的viewObject或model
  private Object data;

  /**
   * Create common return type.
   *
   * @param result the result
   *
   * @return the common return type
   */
  public static CommonReturnType create(Object result){
    return CommonReturnType.create("success","",result);
  }

  /**
   * Create common return type.
   *
   * @param message the result
   * @param status the status, "success" or "fail"
   *
   * @return the common return type
   */
  public static CommonReturnType create(String status,String message){
    return CommonReturnType.create(status,message,null);
  }

  /**
   * Create common return type.
   *
   * @param message the message
   * @param result the result
   * @param status the status, "success" or "fail"
   *
   * @return the common return type
   */
  public static CommonReturnType create(String status,String message,Object result){
    CommonReturnType commonReturnType = new CommonReturnType();
    commonReturnType.setStatus(status);
    commonReturnType.setMessage(message);
    commonReturnType.setData(result);
    return commonReturnType;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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
}
