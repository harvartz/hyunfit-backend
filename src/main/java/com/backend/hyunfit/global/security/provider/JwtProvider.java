package com.backend.hyunfit.global.security.provider;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.backend.hyunfit.domain.auth.dto.AuthDTO;

import java.util.*;
import java.security.Key;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.jsonwebtoken.security.Keys.secretKeyFor;

@Slf4j
@Component
public class JwtProvider implements InitializingBean {
    private static final String AUTHORITIES_KEY = "auth";
    private final String secret;
    private final long tokenValidityInMilliseconds;
    private Key key;

    public JwtProvider(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.token-validity-in-seconds}") long tokenValidityInMilliseconds
    ){
        this.secret = secret;
        this.tokenValidityInMilliseconds = tokenValidityInMilliseconds;
    }

    @Override
    public void afterPropertiesSet() {
        this.key = secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String createToken(Authentication authentication,AuthDTO authDTO){//토큰생성
        long now = (new Date()).getTime();
        Date validity = new Date(now + this.tokenValidityInMilliseconds);

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", authDTO.getRole());

        Collection<? extends GrantedAuthority> authorities =
                authorityOf(authDTO.getRole());

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY,authorities)
                .addClaims(claims)
                .signWith(key)
                .setExpiration(validity)
                .compact();
    }
    public Authentication getAuthentication(String token){// Authentication 리턴
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Collection<? extends GrantedAuthority> authorities =
                authorityOf(claims.get("role", String.class));

        User principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }
    public List<GrantedAuthority> authorityOf(String role) {
        if (role == null) return Collections.emptyList();
        return Stream.of(new SimpleGrantedAuthority(role)).collect(Collectors.toList());
    }
    public boolean validateToken(String token){//만료 체크
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }
        catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.debug("Invalid JWT Signature");
        }
        catch (ExpiredJwtException e) { log.debug("JWT expired"); }
        catch (IllegalArgumentException e) { log.debug("Illegal JWT"); }
        return false;
    }
}