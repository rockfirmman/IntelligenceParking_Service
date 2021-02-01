package com.intelligenceparking.response;

/**
 * The type Common return type.
 */
public class CommonReturnType {
  //表明对应请求的返回处理结果，有success或fail
  private String status;
  //若status是succes，则data内返回前端所需要的数据
  //若status是fail。则data内使用通用的错误格式
  private Object data;

  /**
   * Create common return type.
   *
   * @param result the result
   *
   * @return the common return type
   */
  public static CommonReturnType create(Object result){
    return CommonReturnType.create(result,"success");
  }

  /**
   * Create common return type.
   *
   * @param result the result
   * @param status the status
   *
   * @return the common return type
   */
  public static CommonReturnType create(Object result, String status){
    CommonReturnType type = new CommonReturnType();
    type.setStatus(status);
    type.setData(result);
    return type;
  }

  /**
   * Gets status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets status.
   *
   * @param status the status
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Gets data.
   *
   * @return the data
   */
  public Object getData() {
    return data;
  }

  /**
   * Sets data.
   *
   * @param data the data
   */
  public void setData(Object data) {
    this.data = data;
  }
}
