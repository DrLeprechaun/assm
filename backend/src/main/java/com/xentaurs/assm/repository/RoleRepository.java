package com.xentaurs.assm.repository;

import com.xentaurs.assm.domain.Role;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
//public interface RoleRepository extends JpaRepository<Role, Long> {
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);

}
