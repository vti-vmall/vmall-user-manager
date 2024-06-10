package vn.edu.vti.vmall.vmall_user_manager.service;

import vn.edu.vti.vmall.vmall_user_manager.payload.request.LoginRequest;
import vn.edu.vti.vmall.vmall_user_manager.payload.request.RegisterAccountRequest;
import vn.edu.vti.vmall.vmall_user_manager.payload.request.RegisterAccountResponse;
import vn.edu.vti.vmall.vmall_user_manager.payload.response.LoginResponse;

public interface AuthService {
  RegisterAccountResponse registerAccount(RegisterAccountRequest request);

  LoginResponse login(LoginRequest request);
}
