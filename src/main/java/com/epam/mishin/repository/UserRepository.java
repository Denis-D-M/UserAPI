package com.epam.mishin.repository;

import com.epam.mishin.domain.entity.User;
import com.epam.mishin.domain.entity.UserStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByStatus(UserStatus status);

    @Query("update User u set u.status = :newStatus where id = :userId")
    @Modifying
    @Transactional
    void updateUserStatus(@Param("userId") int userId,@Param("newStatus") UserStatus newStatus);

    @Override
    @NonNull
    List<User> findAll();
}
