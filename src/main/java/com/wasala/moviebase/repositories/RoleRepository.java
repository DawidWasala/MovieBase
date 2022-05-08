package com.wasala.moviebase.repositories;

import com.wasala.moviebase.models.Role;
import com.wasala.moviebase.models.RoleEnum;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByName(RoleEnum name);

}
