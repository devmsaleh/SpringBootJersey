package com.his.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.his.dao.UserRepository;
import com.his.entities.User;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User findByUserId(long id) {
        User user = userRepository.findOne(id);
        return user;
    }

}
