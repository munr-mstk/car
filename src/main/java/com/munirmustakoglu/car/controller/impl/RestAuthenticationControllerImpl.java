package com.munirmustakoglu.car.controller.impl;

import com.munirmustakoglu.car.controller.IRestAuthenticationController;
import com.munirmustakoglu.car.controller.RestBaseController;
import com.munirmustakoglu.car.controller.RootEntity;
import com.munirmustakoglu.car.dto.AuthRequest;
import com.munirmustakoglu.car.dto.DtoUser;
import com.munirmustakoglu.car.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/register")  //security config dekik url le aynı olması gerekiyor eşleşmesi için.
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.register(input));
    }
}
