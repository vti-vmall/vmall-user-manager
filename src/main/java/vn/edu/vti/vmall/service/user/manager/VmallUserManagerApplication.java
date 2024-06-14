package vn.edu.vti.vmall.service.user.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.vti.vmall.api.common.exception.EnableExceptionHandler;
import vn.edu.vti.vmall.security.config.EnableSecurityCommon;

@SpringBootApplication
@EnableExceptionHandler
@EnableSecurityCommon
public class VmallUserManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(VmallUserManagerApplication.class, args);
  }

}
