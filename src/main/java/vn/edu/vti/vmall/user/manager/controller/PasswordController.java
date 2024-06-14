package vn.edu.vti.vmall.user.manager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.vti.vmall.api.common.response.ApiResponse;

@RestController
@RequestMapping(value = "/api/v1/password")
public class PasswordController {
  @PutMapping
  public ResponseEntity<ApiResponse<String>> changePassword(){
    return ResponseEntity.ok(ApiResponse.success("Change password"));
  }
}
