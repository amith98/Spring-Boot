package com.example.user.Service;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.user.Models.User;

public class CustomUserDetail implements UserDetails {


    private User user;


    public CustomUserDetail(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }


    public String getFirstName() {
        return user.getFirstName();
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }


    @Override
    public String getUsername() {
       
        return user.getEmail();
    }


    @Override
    public boolean isAccountNonExpired() {
   
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
   
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
   
        return true;
    }


   @Override
   public boolean isEnabled() {
	   return true;
   }
}