package vn.edu.vti.vmall.service.user.manager.service;

import vn.edu.vti.vmall.api.common.payload.service.user.response.UserInfoResponse;

public interface UserInternalService {
  UserInfoResponse getUserInfoByUsername(String username);
}
