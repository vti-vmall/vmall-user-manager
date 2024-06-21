package vn.edu.vti.vmall.service.user.manager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.vti.vmall.api.common.exception.EnableExceptionHandler;
import vn.edu.vti.vmall.security.config.EnableSecurityCommon;
import vn.edu.vti.vmall.security.config.JWTTokenProperties;
import vn.edu.vti.vmall.service.user.manager.payload.request.SendEmailRequest;

@SpringBootApplication
@EnableExceptionHandler
@EnableSecurityCommon
@Slf4j
public class VmallUserManagerApplication implements CommandLineRunner {
  public static void main(String[] args) {
    SpringApplication.run(VmallUserManagerApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
  }
}
