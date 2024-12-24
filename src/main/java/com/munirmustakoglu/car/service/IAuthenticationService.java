package com.munirmustakoglu.car.service;

import com.munirmustakoglu.car.dto.AuthRequest;
import com.munirmustakoglu.car.dto.DtoUser;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);
}
