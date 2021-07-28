package com.zale;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;


class JwtApplicationTests {

    @Test
    void contextLoads() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,100);
        String token = JWT.create()
                .withClaim("userid",12)
                .withClaim("username", "zhang")//payload
                .withExpiresAt(instance.getTime())//ָ�����ƹ���ʱ��
                .sign(Algorithm.HMAC256("!Q@W#E$R"));//ǩ��
        System.out.println(token);
    }

    @Test
    public void test() {
        //������֤����
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC384("!Q@W#E$R")).build();

        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1OTY3OTI1MzMsInVzZXJpZCI6MTIsInVzZXJuYW1lIjoieGlhb2NoZW4ifQ.pfGxzorMbjrZtEEm4sbstySiWsJoMkRQfPcwOOo-fkM");

        System.out.println(verify.getClaim("userid").asInt());
        System.out.println(verify.getClaim("username").asString());
        System.out.println("����ʱ��: " + verify.getExpiresAt());
    }

}
