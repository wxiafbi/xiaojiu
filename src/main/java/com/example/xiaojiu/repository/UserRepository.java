package com.example.xiaojiu.repository;
import com.example.xiaojiu.pojo.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {


}
