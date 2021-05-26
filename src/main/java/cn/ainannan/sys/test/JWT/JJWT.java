package cn.ainannan.sys.test.JWT;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JJWT {


    public static void main(String[] args) {
        // We need a signing key, so we'll create one just for this example. Usually
        // the key would be read from your application configuration instead.
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        System.out.println(key.getAlgorithm());

        String jws = Jwts.builder().setSubject("Joe").signWith(SignatureAlgorithm.HS256, key).compact();

        System.out.println("jws = " + jws);

    }
}
