package com.zei.boot.demo.util;

import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author lvyouqiang
 * @since 2020-06-14 10:04
 */
@Component
@Data
@ConfigurationProperties(prefix = "zei.jwt")
public class JwtUtils {

    private String secret;

    private long expire;

    private String header;

    /**
     * 生成jwt
     * @param userId
     * @return
     */
    public String generateToken(Long userId) {
        Date nowDate = new Date();

        Date expireDate = new Date(nowDate.getTime() + expire * 1000);

        return Jwts.builder()
                .setHeaderParam("type", "jwt")
                .setSubject(userId.toString())
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 校验jwt
     * @param token
     * @return
     */
    public Claims getClaimsByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 判断token是否过期
     * @param expiration
     * @return
     */
    public boolean isTokenExpire(Date expiration) {
        return expiration.before(new Date());
    }
}
