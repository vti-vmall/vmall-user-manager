package vn.edu.vti.vmall.service.user.manager.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterAccountRequest {
  @NotNull
  private String username;

  @NotNull
  private String password;

  @NotNull
  private String email;
}
