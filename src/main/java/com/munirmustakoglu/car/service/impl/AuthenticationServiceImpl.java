package com.munirmustakoglu.car.service.impl;

import com.munirmustakoglu.car.dto.AuthRequest;
import com.munirmustakoglu.car.dto.DtoUser;
import com.munirmustakoglu.car.model.User;
import com.munirmustakoglu.car.repository.UserRepository;
import com.munirmustakoglu.car.service.IAuthenticationService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
@Getter
@Setter
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    private User createUser(AuthRequest input) {

        User user = new User();
        user.setCreateTime(new Date());
        user.setUsername(input.getUsername());
        user.setPassword(passwordEncoder.encode(input.getPassword())); //Password encoder ın encode metodunu kullnarak inputdan gelen şifrefi criptolanmıl olareak çevir ve input da setle

        return user;
    }
    @Override
    public DtoUser register(AuthRequest input) {
        DtoUser dtoUser = new DtoUser();
        User savedUser =userRepository.save(createUser(input));

        BeanUtils.copyProperties(savedUser,dtoUser);
        return dtoUser;
    }
}
