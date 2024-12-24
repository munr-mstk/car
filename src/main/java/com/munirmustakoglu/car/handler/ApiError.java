package com.munirmustakoglu.car.handler;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<E> {
    private int status;

    private  Exception<E> exception ;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Exception<E> getException() {
        return exception;
    }

    public void setException(Exception<E> exception) {
        this.exception = exception;
    }
}
