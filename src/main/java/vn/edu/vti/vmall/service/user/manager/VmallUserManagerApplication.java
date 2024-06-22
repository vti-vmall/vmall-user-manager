package vn.edu.vti.vmall.service.user.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.vti.vmall.api.common.exception.EnableExceptionHandler;
import vn.edu.vti.vmall.common.queue.config.EnableCommonQueuePublisher;
import vn.edu.vti.vmall.security.config.EnableSecurityCommon;

@SpringBootApplication
@EnableExceptionHandler
@EnableSecurityCommon
@Slf4j
@EnableCommonQueuePublisher
public class VmallUserManagerApplication implements CommandLineRunner {
  public static void main(String[] args) {
    SpringApplication.run(VmallUserManagerApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("(VmallUserManagerApplication)Already ready!!!!");
  }
}
