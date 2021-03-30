package webshop.webshop.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import webshop.webshop.filter.JwtGenerate;
import webshop.webshop.model.security.AuthenticationRequest;
import webshop.webshop.model.user.User;
import webshop.webshop.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoginController {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserService service;
    @Autowired
    private JwtGenerate jwtGenerate;

    @PostMapping("/login")
    public ResponseEntity<String> loginProcess(HttpServletResponse response, @RequestBody AuthenticationRequest authenticationRequest) {

        String pwd = authenticationRequest.getPassword();
        Optional<User> users = Optional.ofNullable(service.findByEmail(authenticationRequest.getEmail()));
        if (users.isPresent()) {
            if (passwordEncoder.matches(pwd, users.get().getPassword())) {
                // Produce jwt
                String jwt = "";
                jwtGenerate.makeToken(authenticationRequest, response, users, jwt);
                return new ResponseEntity<>(jwt, HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Neem contact op met Admin", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("Emailadres of wachtwoord is incorrect", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }}

