package org.example.perfumestatschecker.repositories.account;

import org.example.perfumestatschecker.models.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
