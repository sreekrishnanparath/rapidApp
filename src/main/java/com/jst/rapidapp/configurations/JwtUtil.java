package com.jst.rapidapp.configurations;


import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JwtUtil {

    private String jwtSecret;
    private int jwtExpirationTime;

    @Value("${jwt.secret}")
    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    @Value("${jwt.expirationDateInMs}")
    public void setJwtExpirationTime(int jwtExpirationTime) {
        this.jwtExpirationTime = jwtExpirationTime;
    }

    public String generateJwtToken(UserDetails userDetails){

        Map<String,Object> claims = new HashMap<String,Object>();
        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();

        if(roles.contains(new SimpleGrantedAuthority("ADMIN"))){
            claims.put("isAdmin",true);
        }else if(roles.contains(new SimpleGrantedAuthority("USER"))){
            claims.put("isUser",true);
        }

        return doGenerateJwtToken(claims,userDetails.getUsername());



        }


    private String doGenerateJwtToken(Map<String,Object> claims,String userName) {
        System.out.println("jwtSecret## "+jwtSecret);
        System.out.println("jwtExpirationTime## "+jwtExpirationTime);
        System.out.println("jwtExpirationTime## "+new Date());
        System.out.println("jwtExpirationTime## "+new Date((new Date()).getTime()+jwtExpirationTime));
        return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime()+jwtExpirationTime))
                .signWith(SignatureAlgorithm.HS512,jwtSecret).compact();

//        return Jwts.builder()
//                .setSubject(userName)
//                .setClaims(claims)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date((new Date()).getTime() + jwtExpirationTime))
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();


    }

    public boolean validateAuthJwtToken(String jwtToken) throws Exception{
        try {
            System.out.println("jwtToken# "+jwtToken);
            Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken).getBody();
            System.out.println("claims# "+claims);
        }catch (SignatureException | MalformedJwtException | UnsupportedJwtException |IllegalArgumentException  ex){
            ex.printStackTrace();
            throw new BadCredentialsException("INVALID_TOKEN",ex);

        }catch (ExpiredJwtException ex) {
            ex.printStackTrace();
            throw new BadCredentialsException("EXPIRED_TOKEN", ex);

        }
        return  true;
    }



    public String getUserdetailsFromJwtToken(String jwtToken) throws Exception {
        System.out.println("user "+Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken).getBody().getSubject());
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken).getBody().getSubject();
    }

    public List<SimpleGrantedAuthority> getRolesFromJwtToken(String jwtToken) throws Exception {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken).getBody();
        System.out.println("claims##"+claims.toString());
        if (claims!=null){
            List<SimpleGrantedAuthority> roles = null;
            Boolean isAdmin = claims.get("isAdmin", Boolean.class);
            Boolean isUser = claims.get("isUser", Boolean.class);
            if (isAdmin != null && isAdmin) {
                roles = Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
            }
            if (isUser != null && isUser) {
                roles = Arrays.asList(new SimpleGrantedAuthority("USER"));
            }
            return roles;
        }
        return null;

    }


}
