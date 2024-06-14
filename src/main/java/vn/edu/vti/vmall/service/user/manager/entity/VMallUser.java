package vn.edu.vti.vmall.service.user.manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class VMallUser extends BaseEntity{
  @Column(columnDefinition = "varchar(50) not null", nullable = false)
  private String username;

  @Column(columnDefinition = "char(80) not null", nullable = false)
  private String password;

  @Column(name = "fullname", columnDefinition = "varchar(80)")
  private String fullName;

  @Column(columnDefinition = "char(11)")
  private String phone;
}
