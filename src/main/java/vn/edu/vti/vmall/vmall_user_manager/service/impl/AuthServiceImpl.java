package vn.edu.vti.vmall.vmall_user_manager.service.impl;


import java.time.ZonedDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.vti.vmall.vmall_user_manager.entity.VMallUser;
import vn.edu.vti.vmall.vmall_user_manager.payload.request.LoginRequest;
import vn.edu.vti.vmall.vmall_user_manager.payload.request.RegisterAccountRequest;
import vn.edu.vti.vmall.vmall_user_manager.payload.request.RegisterAccountResponse;
import vn.edu.vti.vmall.vmall_user_manager.payload.response.LoginResponse;
import vn.edu.vti.vmall.vmall_user_manager.repository.VMallUserRepository;
import vn.edu.vti.vmall.vmall_user_manager.service.AuthService;
import vn.edu.vti.vmall.vmall_user_manager.util.JwtUtil;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final VMallUserRepository vMallUserRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtil jwtUtil;

  @Override
  public RegisterAccountResponse registerAccount(RegisterAccountRequest request) {
    try {
      String username = request.getUsername();
      log.info("(registerAccount)Username: [{}]",
          username);
      vMallUserRepository.findByUsername(username)
          .ifPresent(vMallUser -> {
            throw new RuntimeException("Exits account with username %s in db".formatted(username));
          });
      var user = new VMallUser();
      user.setUsername(username);
      user.setPassword(passwordEncoder.encode(request.getPassword()));
      vMallUserRepository.save(user);
      log.info("(registerAccount)Success for username: [{}] at: [{}]",
          username,
          ZonedDateTime.now());
      return new RegisterAccountResponse(username);
    } catch (Exception e) {
      log.error(
          "(registerAccount)Exception for username: [{}] with message: [{}] and stackTrace: [{}]",
          request.getUsername(),
          e.getMessage(),
          e.getStackTrace());
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override
  public LoginResponse login(LoginRequest request) {
    try {
      var user = vMallUserRepository
          .findByUsername(request.getUsername())
          .orElseThrow(() -> new RuntimeException(
              "Could not found any user with username: %s".formatted(request.getUsername())));
      if(!passwordEncoder.matches(request.getPassword(),
          user.getPassword())){
        throw new RuntimeException("Password is not match!!!");
      }
      var response = new LoginResponse();
      response.setUsername(user.getUsername());
      response.setToken(jwtUtil.genToken(user.getUsername()));
      return response;
    } catch (Exception e) {
      log.error("(login)Exception for username: [{}] with message: [{}] and stackTrace: [{}]",
          request.getUsername(),
          e.getMessage(),
          e.getStackTrace());
      throw new RuntimeException(e.getMessage());
    }
  }
}
