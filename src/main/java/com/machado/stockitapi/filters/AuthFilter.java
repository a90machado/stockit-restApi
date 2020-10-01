package com.machado.stockitapi.filters;

import com.machado.stockitapi.constants.Constants;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String authHeader= httpServletRequest.getHeader("Authorization");
        if(authHeader != null) {
            String[] authHeaderArr = authHeader.split("Bearer ");
            if(authHeaderArr.length > 1 && authHeaderArr[1] != null) {
                String token = authHeaderArr[1];
                try {
                    Jwts.parser().setSigningKey(Constants.API_SECRET_KEY)
                            .parseClaimsJws(token).getBody();
                }catch (Exception e) {
                    httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(), "invalid/expired token");
                    return;
                }
            }else {
                httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be Bearer.");
            }
        } else {
            httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be provided.");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
