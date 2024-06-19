package vn.edu.vti.vmall.service.user.manager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.vti.vmall.api.common.exception.EnableExceptionHandler;
import vn.edu.vti.vmall.security.config.EnableSecurityCommon;
import vn.edu.vti.vmall.security.config.JWTTokenProperties;

@SpringBootApplication
@EnableExceptionHandler
@EnableSecurityCommon
@RequiredArgsConstructor
@Slf4j
public class VmallUserManagerApplication implements CommandLineRunner {
  private final JWTTokenProperties jwtTokenProperties;
  public static void main(String[] args) {
    SpringApplication.run(VmallUserManagerApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("JWT KEY: [{}]", jwtTokenProperties.getKey());
  }
}
