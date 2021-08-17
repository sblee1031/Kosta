package com.day.security.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class CustomUserDetailsService implements UserDetailsService{
    
    private static final String ROLE_PREFIX = "ROLE_";
    
	private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	log.error("CustomUserDetailsService.loadUserByUsername(" +username+")");
       return User.builder().username(username).password("2").roles("ROLE_ADMIN").build();
    }
    
//    private static List<GrantedAuthority> makeGrantedAuthority(List<String> roles){
//        List<GrantedAuthority> list = new ArrayList<>();
//        roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role)));
//        return list;
//    }
 
 
}

