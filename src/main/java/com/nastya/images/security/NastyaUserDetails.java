package com.nastya.images.security;

import com.nastya.images.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class NastyaUserDetails implements UserDetails {

    private String login;

    private String password;

    private Collection<? extends GrantedAuthority> grantedAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public static org.springframework.security.core.userdetails.UserDetails fromEntityToWarehouseUserDetails(User user){
        NastyaUserDetails nastyaUserDetails = new NastyaUserDetails();
        nastyaUserDetails.login = user.getLogin();
        nastyaUserDetails.password = user.getPassword();
        nastyaUserDetails.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName()));
        return nastyaUserDetails;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
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
