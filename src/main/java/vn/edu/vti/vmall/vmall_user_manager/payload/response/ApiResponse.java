package vn.edu.vti.vmall.vmall_user_manager.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
  private ApiResponseStatus status;
  private String errMsg;
  private T data;

  public static <T> ApiResponse<T> success(T data){
    var response = new ApiResponse<T>();
    response.setData(data);
    response.setStatus(ApiResponseStatus.SUCCESS);
    return response;
  }

  public static <T> ApiResponse<T> error(T data, String msg){
    var response = new ApiResponse<T>();
    response.setData(data);
    response.setStatus(ApiResponseStatus.ERROR);
    response.setErrMsg(msg);
    return response;
  }
}
