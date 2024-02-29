package org.example.perfumestatschecker.repositories.account;

import org.example.perfumestatschecker.models.account.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
}
