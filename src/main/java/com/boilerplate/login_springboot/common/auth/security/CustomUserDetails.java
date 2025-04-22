package com.boilerplate.login_springboot.common.auth.security;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private final Long id;
    private final String email;
    private final String password;
    private final String name;
    private final String imageUrl;
    private final Collection<? extends GrantedAuthority> authorities;
    private Map<String, Objects> attributes;

    public CustomUserDetails(Long id, String email, String password, String name, String imageUrl, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.imageUrl = imageUrl;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return email;
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
