package vn.edu.vti.vmall.service.user.manager.controller.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.vti.vmall.api.common.payload.service.user.response.UserInfoResponse;
import vn.edu.vti.vmall.api.common.response.ApiResponse;
import vn.edu.vti.vmall.service.user.manager.service.UserInternalService;

@RequestMapping(value = "/api/v1/internal/users")
@RestController
@RequiredArgsConstructor
public class UserInternalController {

  private final UserInternalService userInternalService;

  @GetMapping(value = "/{username}")
  public ResponseEntity<ApiResponse<UserInfoResponse>> getInfoByUsername(
      @PathVariable String username) {
    return ResponseEntity.ok(
        ApiResponse.success(userInternalService.getUserInfoByUsername(username)));
  }
}
