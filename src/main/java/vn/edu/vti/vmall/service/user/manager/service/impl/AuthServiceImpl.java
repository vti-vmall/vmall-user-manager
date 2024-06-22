package vn.edu.vti.vmall.service.user.manager.service.impl;


import java.time.ZonedDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.vti.vmall.api.common.exception.VMallException;
import vn.edu.vti.vmall.api.common.payload.service.notification.request.SendEmailRequest;
import vn.edu.vti.vmall.security.util.JwtUtil;
import vn.edu.vti.vmall.service.user.manager.entity.VMallUser;
import vn.edu.vti.vmall.service.user.manager.exception.ExceptionEnum;
import vn.edu.vti.vmall.service.user.manager.payload.request.LoginRequest;
import vn.edu.vti.vmall.service.user.manager.payload.request.RegisterAccountRequest;
import vn.edu.vti.vmall.service.user.manager.payload.response.LoginResponse;
import vn.edu.vti.vmall.service.user.manager.payload.response.RegisterAccountResponse;
import vn.edu.vti.vmall.service.user.manager.repository.VMallUserRepository;
import vn.edu.vti.vmall.service.user.manager.service.AuthService;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final VMallUserRepository vMallUserRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtil jwtUtil;
  private final RabbitTemplate rabbitTemplate;

  @Value("${spring.application.name}")
  private String serviceName;

  @Override
  @Transactional
  public RegisterAccountResponse registerAccount(RegisterAccountRequest request) {
    String username = request.getUsername();
    log.info("(registerAccount)Username: [{}]",
        username);
    vMallUserRepository.findByUsername(username)
        .ifPresent(vMallUser -> {
          throw new VMallException(ExceptionEnum.USERNAME_EXISTED);
        });
    var user = new VMallUser();
    user.setUsername(username);
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    vMallUserRepository.save(user);
    //Send email via message queue
    SendEmailRequest sendEmailRequest = new SendEmailRequest();
    sendEmailRequest.setTarget(request.getEmail());
    sendEmailRequest.setContent("Welcome to VMall");

    rabbitTemplate.convertAndSend(
        "local.send.email.exchange",
        "local.send.email.routing-key",
        sendEmailRequest
    );
    //End send email via message queue
    log.info("(registerAccount)Success for username: [{}] at: [{}]",
        username,
        ZonedDateTime.now());
    return new RegisterAccountResponse(username);
  }

  @Override
  public LoginResponse login(LoginRequest request) {
    var user = vMallUserRepository
        .findByUsername(request.getUsername())
        .orElseThrow(
            () -> new VMallException(ExceptionEnum.USER_NOT_FOUND_BY_USERNAME)
        );
    if (!passwordEncoder.matches(request.getPassword(),
        user.getPassword())) {
      throw new VMallException(ExceptionEnum.USERNAME_OR_PASSWORD_NOT_MATCH);
    }
    var response = new LoginResponse();
    response.setUsername(user.getUsername());
    response.setToken(jwtUtil.genToken(user.getUsername(), serviceName));
    return response;
  }
}
