package vn.edu.vti.vmall.vmall_user_manager.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.vti.vmall.vmall_user_manager.entity.VMallUser;

public interface VMallUserRepository extends JpaRepository<VMallUser, Long> {
  Optional<VMallUser> findByUsername(String username);
}
