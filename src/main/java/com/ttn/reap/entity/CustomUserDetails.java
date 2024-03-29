package com.ttn.reap.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails extends User implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (isActive()) {
            return getRole()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRole()))
                    .collect(Collectors.toList());
        }
        return null;
    }


    public CustomUserDetails(final User users) {
        super(users);
    }

    public String getFirstName(){
        return super.getFirstName();
    }

    public String getLastName(){
        return super.getLastName();
    }


    public boolean isActive(){
        return super.isActive();
    }

    public String getImagePath() {
        return super.getImagePath();
    }


    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
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
