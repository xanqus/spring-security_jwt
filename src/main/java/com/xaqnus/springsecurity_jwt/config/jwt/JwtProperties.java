package com.xaqnus.springsecurity_jwt.config.jwt;

public interface JwtProperties {
    String SECRET = "xanqus"; // 우리 서버만 알고 있는 비밀값
    //int EXPIRATION_TIME = 1000*60*60*24*10; // 10일 (1/1000초)
    int EXPIRATION_TIME = 1000*20; //20초
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
    
}
