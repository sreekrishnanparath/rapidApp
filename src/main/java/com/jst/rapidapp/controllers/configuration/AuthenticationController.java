package com.jst.rapidapp.controllers.configuration;


import com.jst.rapidapp.beans.configuration.AuthenticationRequest;
import com.jst.rapidapp.beans.configuration.AuthenticationResponse;
import com.jst.rapidapp.configurations.JwtUtil;
import com.jst.rapidapp.configurations.RapidUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rapidapp")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RapidUserDetailsService userConfigDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> generateAuthenticationJwtToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println("RequestBody " + authenticationRequest.getUsername());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("DISABLED_USER", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_USER", e);
        }
        UserDetails userDetails = userConfigDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwtToken = jwtUtil.generateJwtToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwtToken, userDetails));
    }
}
