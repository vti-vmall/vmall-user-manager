package vn.edu.vti.vmall.vmall_user_manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.vti.vmall.vmall_user_manager.payload.request.LoginRequest;
import vn.edu.vti.vmall.vmall_user_manager.payload.request.RegisterAccountRequest;
import vn.edu.vti.vmall.vmall_user_manager.payload.request.RegisterAccountResponse;
import vn.edu.vti.vmall.vmall_user_manager.payload.response.ApiResponse;
import vn.edu.vti.vmall.vmall_user_manager.payload.response.LoginResponse;
import vn.edu.vti.vmall.vmall_user_manager.service.AuthService;

@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;
  @PostMapping(value = "/register")
  public ResponseEntity<ApiResponse<RegisterAccountResponse>> register(
      @RequestBody RegisterAccountRequest request
  ){
    return ResponseEntity.ok(ApiResponse.success(authService.registerAccount(request)));
  }


  @PostMapping(value = "/login")
  public ResponseEntity<ApiResponse<LoginResponse>> login(
      @RequestBody LoginRequest request
  ){
    return ResponseEntity.ok(ApiResponse.success(authService.login(request)));
  }
}
