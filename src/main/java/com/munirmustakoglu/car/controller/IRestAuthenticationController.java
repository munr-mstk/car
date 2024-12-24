package com.munirmustakoglu.car.controller;

import com.munirmustakoglu.car.dto.AuthRequest;
import com.munirmustakoglu.car.dto.DtoUser;




public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest input);
}
