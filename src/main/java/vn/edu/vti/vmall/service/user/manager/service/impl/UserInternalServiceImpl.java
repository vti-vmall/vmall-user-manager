package vn.edu.vti.vmall.service.user.manager.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.vti.vmall.api.common.exception.VMallException;
import vn.edu.vti.vmall.api.common.payload.service.user.response.UserInfoResponse;
import vn.edu.vti.vmall.service.user.manager.exception.ExceptionEnum;
import vn.edu.vti.vmall.service.user.manager.repository.VMallUserRepository;
import vn.edu.vti.vmall.service.user.manager.service.UserInternalService;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserInternalServiceImpl implements UserInternalService {
  private final VMallUserRepository userRepository;
  @Override
  public UserInfoResponse getUserInfoByUsername(String username) {
    return userRepository.findByUsername(username).map(vMallUser -> {
      var response = new UserInfoResponse();
      response.setPhone(vMallUser.getPhone());
      return response;
    }).orElseThrow(() -> new VMallException(ExceptionEnum.USER_NOT_FOUND_BY_USERNAME));
  }
}
