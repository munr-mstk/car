package com.munirmustakoglu.car.config;

import com.munirmustakoglu.car.exception.BaseException;
import com.munirmustakoglu.car.exception.ErrorMessage;
import com.munirmustakoglu.car.exception.MessageType;
import com.munirmustakoglu.car.model.User;
import com.munirmustakoglu.car.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Configuration
public class AppConfig {


    private UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                // Kullanıcıyı veritabanında username'e göre arıyoruz
                Optional<User> optional = userRepository.findByUsername(username);
                if (optional.isEmpty()) {
                    // Eğer kullanıcı bulunamazsa özel bir istisna fırlatıyoruz
                    throw new BaseException(new ErrorMessage(MessageType.USERNAME_NOT_FOUND, username));
                }
                return optional.get();
            }
        };
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService()); // userDetailsService metodunu çağırıyoruz
        provider.setPasswordEncoder(passwordEncoder()); // Şifreleme için passwordEncoder kullanıyoruz
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
