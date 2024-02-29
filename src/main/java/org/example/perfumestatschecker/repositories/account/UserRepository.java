package org.example.perfumestatschecker.repositories.account;

import org.example.perfumestatschecker.models.account.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
