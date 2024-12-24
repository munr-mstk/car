package com.munirmustakoglu.car.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@JsonInclude(value = JsonInclude.Include.NON_NULL)   // null setlediğim değerleri geriye döndürmek istemiyorsam...
public class RootEntity <T>{

    private Integer status;

    private  T payload;

    private String errorMessage;

    public Integer getStatus() {
        return status;
    }

    public T getPayload() {
        return payload;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static  <T> RootEntity<T> ok(T payload){
        RootEntity<T> rootEntity = new RootEntity<>();
        rootEntity.setStatus(200);
        rootEntity.setPayload(payload);
        rootEntity.setErrorMessage(null);

        return rootEntity;

    }

    public static  <T> RootEntity<T> error(String errorMessage){
        RootEntity<T> rootEntity = new RootEntity<>();
        rootEntity.setStatus(500);
        rootEntity.setPayload(null);
        rootEntity.setErrorMessage(errorMessage);

        return rootEntity;
    }
}
