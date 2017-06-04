package at.htld.module.tracker.repo;

import at.htld.module.tracker.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")

public interface RoleReopsitory extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}