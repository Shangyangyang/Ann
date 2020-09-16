package cn.ainannan.sys.test.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.apache.commons.codec.binary.Base64;

import java.security.Key;
import java.util.Date;

public class JwtUtils {
    public static void main(String[] args) throws Exception {

        String str = createToken("123", "newheyd");

        System.out.println("str = " + str);

    }


    public static String createToken(String id, String secretKey) throws Exception {
        byte[] bytes = Base64.encodeBase64(secretKey.getBytes("utf-8"));
        String userToken = createToken(id, bytes);
        return userToken;
    }

    // 生成token
    public static String createToken(String id, byte[] secretKey) {
        String userToken = null;
        JwtBuilder builder = Jwts.builder().setSubject("{'userCode':'admin','areaCode':'370102'}").setExpiration(new Date());
        builder.setId(id);
        userToken = builder.signWith(SignatureAlgorithm.HS512, secretKey).compact();

        return userToken;


    }


    public static Claims parseJWT(String jwt, String secretKey) throws Exception {
        byte[] bytes = Base64.encodeBase64(secretKey.getBytes("utf-8"));
        Claims claims = Jwts.parser().setSigningKey(bytes).parseClaimsJws(jwt).getBody();
        return claims;
    }

    public static void getJWT(){
        Key key = MacProvider.generateKey();

        String compactJws = Jwts.builder()
                .setSubject("{'userCode':'admin','areaCode':'370102'}")
                .signWith(SignatureAlgorithm.HS512, "newheyd")
                .compact();

        System.out.println("compactJws = " + compactJws);
    }


}