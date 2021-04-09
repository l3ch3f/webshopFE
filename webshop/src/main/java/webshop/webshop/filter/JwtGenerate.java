package webshop.webshop.filter;

import org.springframework.beans.factory.annotation.Autowired;
import webshop.webshop.constants.SecurityConstants;
import webshop.webshop.model.security.AuthenticationRequest;
import webshop.webshop.model.user.User;
import webshop.webshop.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;


// generate jwt for validation
public class JwtGenerate {
    @Autowired
    UserService service;

    public String makeToken(AuthenticationRequest authenticationRequest, HttpServletResponse response, Optional<User> users, String jwt) {
        User user = service.findByEmail(authenticationRequest.getEmail());
        SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        jwt = Jwts.builder().setIssuer("TechGrounds Service").setSubject("JWT Token")
                .claim("username", authenticationRequest.getEmail())
                .claim("firstName", users.get().getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(key).compact();
        response.setHeader(SecurityConstants.JWT_HEADER, jwt);
        return jwt;
    }
}
