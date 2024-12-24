package com.munirmustakoglu.car.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements UserDetails {

    @Column(name = "user_name")
    private String Username;

    @Column(name = "password")
    private String Password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); // Kullanıcının yetkilerini burada belirleyebilirsiniz
    }

    @Override
    public String getUsername() {
        return Username; // Username'i burada döndüreceksiniz
    }

    @Override
    public String getPassword() {
        return Password; // Password'u burada döndüreceksiniz
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Hesap süresi dolmuşsa false döndürebilirsiniz
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Hesap kilitliyse false döndürebilirsiniz
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Kimlik bilgileri süresi dolmuşsa false döndürebilirsiniz
    }

    @Override
    public boolean isEnabled() {
        return true; // Hesap aktifse true döndürmelisiniz
    }
}
