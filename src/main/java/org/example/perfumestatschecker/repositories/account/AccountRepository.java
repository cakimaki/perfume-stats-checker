package org.example.perfumestatschecker.repositories.account;

import org.example.perfumestatschecker.models.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
