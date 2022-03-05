package com.gloria.moringacrud.controller;


import com.gloria.moringacrud.model.AuthenticationRequest;
import com.gloria.moringacrud.model.AuthenticationResponse;
import com.gloria.moringacrud.service.MoringaUserDetailsService;
import com.gloria.moringacrud.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;



@RestController

public class MoringaController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MoringaUserDetailsService moringaUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/")
    public String home(){
        return "Welcome home";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello there";
    }

    @GetMapping("/user")
    public  String user(){
        return "Welcome User";
    }

    @GetMapping("/admin")
    public  String admin(){
        return "Welcome Admin";
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect userName or password",e);
        }

        final UserDetails userDetails = moringaUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


}
