package com.backend.hyunfit.global.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import com.backend.hyunfit.global.security.provider.JwtProvider;
public class JwtFilter extends BasicAuthenticationFilter {
    public static final String AUTHORIZATION_HEADER = "Authorization";

    private final JwtProvider jwtProvider;

    public JwtFilter(JwtProvider jwtProvider){
        super(new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                return null;
            }
        });
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("doFilter");

        String jwt = resolveToken(request);
        String requestURI = request.getRequestURI();

        System.out.println(requestURI);
        if(requestURI.equals("/error")){
            System.out.println("error");
        }
        // 토큰 유효성 검증 후 정상이면 SecurityContext에 저장
        else if(StringUtils.hasText(jwt) && jwtProvider.validateToken(jwt)){
            Authentication authentication = jwtProvider.getAuthentication(jwt);
            System.out.println(authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("Security Context에 "+authentication.getName()+" 인증 정보를 저장했습니다, uri: "+requestURI);
        }
        else System.out.println("유효한 JWT 토큰이 없습니다 >> uri: "+requestURI);

        // 생성한 필터 실행
        chain.doFilter(request,response);
    }

    private String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            String token = bearerToken.substring(7);
            System.out.println("token : " + token);

            return token;
        }
        return null;
    }
}