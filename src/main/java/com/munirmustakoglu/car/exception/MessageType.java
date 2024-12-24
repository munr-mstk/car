package com.munirmustakoglu.car.exception;

import lombok.Getter;
import lombok.Setter;

@Getter


public enum MessageType {
    NO_RECORD_EXIST("1004", "kayıt bulunamadı"),
    TOKEN_IS_EXPIRED("1005", "token ın süresi dolmuş "),
    USERNAME_NOT_FOUND("1006","Kullanıcı adı bulunaamdı"),
    GENERAL_EXCEPTION("9999", "genel hata");


    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private MessageType(String code, String message) {
        this.code = code;
        this.message = message;



    }

}
