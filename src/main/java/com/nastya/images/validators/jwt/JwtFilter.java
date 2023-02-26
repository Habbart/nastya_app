package com.nastya.images.validators.jwt;

import com.nastya.images.security.NastyaUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import java.io.IOException;



@Component
@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends GenericFilterBean {

    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";

    private JwtProvider jwtProvider;
    private NastyaUserDetailsService warehouseNastyaUserDetailsService;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("do filter...");
        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
        log.info("servletRequest: " + servletRequest);
        if (token != null && jwtProvider.validateToken(token)) {
            log.info("зашли в фильтр токена");
            String userLogin = jwtProvider.getLoginFromToken(token);
            UserDetails warehouseUserDetails = warehouseNastyaUserDetailsService.loadUserByUsername(userLogin);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(warehouseUserDetails, null, warehouseUserDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            log.info("token: " + token + "username: " + userLogin);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
//        if (hasText(bearer) && bearer.startsWith(BEARER)) {  После извлечения токена мне нужно проверить чтобы он начинался со слова Bearer (носитель с англ.).
//            return bearer.substring(7);   Почему именно с Bearer? Такой стандарт RFC6750 для токенов с которым более подробно можно ознакомиться по ссылке https://datatracker.ietf.org/doc/html/rfc6750.
//        }
        return bearer;
    }
}
