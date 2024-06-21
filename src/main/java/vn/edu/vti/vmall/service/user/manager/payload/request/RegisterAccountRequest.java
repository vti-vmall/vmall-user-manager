package vn.edu.vti.vmall.service.user.manager.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterAccountRequest {
  private String username;
  private String password;
  private String email;
}
