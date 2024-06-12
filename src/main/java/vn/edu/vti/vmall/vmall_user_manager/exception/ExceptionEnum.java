package vn.edu.vti.vmall.vmall_user_manager.exception;

import org.springframework.http.HttpStatus;
import vn.edu.vti.vmall.api.common.exception.VMallExceptionInfo;

public enum ExceptionEnum implements VMallExceptionInfo {
  BAD_REQUEST(
      "BAD_REQUEST",
      "Bad request",
      HttpStatus.BAD_REQUEST
  ),
  USER_NOT_FOUND_BY_USERNAME (
      "USER_NOT_FOUND_BY_USERNAME",
      "Could not found any user in the system by this username",
      HttpStatus.NOT_FOUND
  ),
  USERNAME_EXISTED (
      "USERNAME_EXISTED",
      "This username has already existed in this system",
      HttpStatus.BAD_REQUEST
  ),
  USERNAME_OR_PASSWORD_NOT_MATCH (
      "USERNAME_OR_PASSWORD_NOT_MATCH",
      "Username or password is not match. Please try again.",
      HttpStatus.BAD_REQUEST
  );

  private final String errorCode;
  private final String errorDescription;
  private final HttpStatus httpStatus;

  ExceptionEnum(String errorCode, String errorDescription, HttpStatus httpStatus) {
    this.errorCode = errorCode;
    this.errorDescription = errorDescription;
    this.httpStatus = httpStatus;
  }

  @Override
  public String getErrorCode() {
    return errorCode;
  }

  @Override
  public String getErrorDescription() {
    return errorDescription;
  }

  @Override
  public HttpStatus getHttpStatus() {
    return httpStatus;
  }
}
