package com.xentaurs.assm.repository;


import com.xentaurs.assm.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@Repository
/*public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}*/
public interface UserRepository extends CrudRepository<User, Long> {

    /*User findByUsername(String username);*/
    /*List<User> findByUsername(@Param("username") String usernamename);*/
    User findById(@Param("id") long id);

    User findByUsername(@Param("username") String usernamename);

    User findByEmail(@Param("email") String email);

}
