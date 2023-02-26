package com.nastya.images.security;

import com.nastya.images.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class NastyaUserDetailsService implements UserDetailsService {

    private final Logger logger = Logger.getLogger("WarehouseUserDetailsService Logger");

    @Autowired
    private AdminService adminService;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        logger.info("берём юзера по Логину");
        return NastyaUserDetails.fromEntityToWarehouseUserDetails(adminService.findByLogin(userName));
    }
}
