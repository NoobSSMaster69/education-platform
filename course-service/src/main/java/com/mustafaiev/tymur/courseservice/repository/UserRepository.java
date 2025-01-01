package com.mustafaiev.tymur.courseservice.repository;

import com.mustafaiev.tymur.courseservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    Set<User> findByNameIn(List<String> names);

}
