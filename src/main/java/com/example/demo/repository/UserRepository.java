package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> getAllByEmail(String email);

    @Query(value = "select activation_code from emailTest.user where email= :email", nativeQuery = true)
    String getByEmail(String email);

    @Query(value = "select id from emailTest.user where email = :email", nativeQuery = true)
    Integer getId(String email);

    @Modifying
    @Transactional
    @Query(value = "update emailTest.user set status= :status where id= :id", nativeQuery = true)
    void update(String status, Integer id);

    @Modifying
    @Transactional
    @Query(value = "update emailTest.user set description= :description where id= :id", nativeQuery = true)
    void updateDescription(String description, Integer id);

    @Query(value = "select status from emailTest.user where email= :email", nativeQuery = true)
    String getStatus(String email);

    @Query(value = "select email from emailTest.user where email= :email", nativeQuery = true)
    Optional<String> getEmail(String email);

    @Query(value = "select description from emailTest.user where email= :email", nativeQuery = true)
    String getDescription(String email);
}
