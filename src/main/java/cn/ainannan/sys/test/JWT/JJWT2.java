package cn.ainannan.sys.test.JWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

public class JJWT2 {

    public static void main(String[] args) {

        // JWT 密钥长度不小于 256 位
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        System.out.println(key.getAlgorithm());
//		System.out.println(key.getFormat());
//		System.out.println(key.toString());
        System.out.println(key.getEncoded().length * 8);
//		System.out.println(Arrays.toString(key.getEncoded()));

        // 密钥
        System.out.println(Base64.getEncoder().encodeToString(key.getEncoded()));

        // 负载数据
        Claims claims = Jwts.claims();
        claims.put("user", "king");
        claims.put("role", "admin");
        claims.put("roles", new String[] {"admin", "test", "user"});

        // 生成了一个 JWT 令牌（未签名）
        String token = Jwts.builder()
                .setSubject("demo")
                .setIssuer("newer")
                .setAudience("you")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .addClaims(claims)	// 自定义数据
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();// 压缩
        // header.payload
        System.out.println(token);

        // 收到客户端请求，从请求头获得令牌解析令牌中的信息
//        Claims c = Jwts.parserBuilder()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//
//        System.out.println(c);
    }
}