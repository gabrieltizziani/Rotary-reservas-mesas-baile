package com.rotary.reservas_mesas_rotary.repositories;

import com.rotary.reservas_mesas_rotary.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}
