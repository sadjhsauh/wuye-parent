package top.gzk.wy.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "jwt")
@Component
public class JwtUtils {
    //密钥
    private String secret;

    // 过期时间 毫秒
    private Long expiration;


    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret).compact();
    }
    /**
     * 生成令牌
     *
     * @param userId 用户id
     * @return 令牌
     */
    public String generateToken(Integer userId,String username,Integer userType) {
        Map<String, Object> claims = new HashMap<>(2);
        //设置token分类
        claims.put(Claims.SUBJECT,"WUYE_USER");
        //设置私有信息，用户信息
        claims.put("userId",userId);
        claims.put("username",username);
        claims.put("userType",userType);
        //设置签发时间为当前时间
        claims.put(Claims.ISSUED_AT, new Date());
        return generateToken(claims);
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    public Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }



    /**
     * 从令牌中获取用户id
     *
     * @param token 令牌
     * @return 用户id
     */
    public Integer getUserIdFromToken(String token) {
        Integer userId;
        try {
            Claims claims = getClaimsFromToken(token);
            userId = (Integer) claims.get("userId");
        } catch (Exception e) {
            userId = null;
        }
        return userId;
    }
    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = (String)claims.get("username");
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    /**
     * 从令牌中获取用户类型
     *
     * @param token 令牌
     * @return 用户类型
     */
    public Integer getUserTypeFromToken(String token) {
        Integer userType;
        try {
            Claims claims = getClaimsFromToken(token);
            userType = (Integer)claims.get("userType");
        } catch (Exception e) {
            userType = null;
        }
        return userType;
    }
    /**
     * 刷新令牌
     *
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put(Claims.ISSUED_AT, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }
}
