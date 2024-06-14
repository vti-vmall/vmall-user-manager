package vn.edu.vti.vmall.service.user.manager.service;

import vn.edu.vti.vmall.service.user.manager.payload.request.LoginRequest;
import vn.edu.vti.vmall.service.user.manager.payload.request.RegisterAccountRequest;
import vn.edu.vti.vmall.service.user.manager.payload.response.LoginResponse;
import vn.edu.vti.vmall.service.user.manager.payload.response.RegisterAccountResponse;

public interface AuthService {
  RegisterAccountResponse registerAccount(RegisterAccountRequest request);

  LoginResponse login(LoginRequest request);
}
