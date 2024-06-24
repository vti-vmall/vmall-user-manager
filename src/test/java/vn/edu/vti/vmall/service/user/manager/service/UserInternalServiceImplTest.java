package vn.edu.vti.vmall.service.user.manager.service;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import vn.edu.vti.vmall.service.user.manager.entity.VMallUser;
import vn.edu.vti.vmall.service.user.manager.repository.VMallUserRepository;
import vn.edu.vti.vmall.service.user.manager.service.impl.UserInternalServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserInternalServiceImplTest {
  @Mock
  private VMallUserRepository vMallUserRepository;

  @InjectMocks
  private UserInternalServiceImpl userInternalService;

  @Test
  void test_getUserInfoByUsername(){
    var vmallUser = new VMallUser();
    Mockito.when(vMallUserRepository.findByUsername(Mockito.anyString()))
        .thenReturn(Optional.of(vmallUser));
    var result = userInternalService.getUserInfoByUsername("tunk");
    Assertions.assertNotNull(result);
  }
}
