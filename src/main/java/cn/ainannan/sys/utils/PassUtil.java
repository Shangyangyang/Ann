package cn.ainannan.sys.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PassUtil {

    public static final int HASH_INTERATIONS = 1024;

    public static final int SALT_SIZE = 8;

    public static String encode(CharSequence rawPassword) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);

        byte[] hashPassword = Digests.sha1(((String) rawPassword).getBytes(), salt, HASH_INTERATIONS);

        String saltStr = Encodes.encodeHex(salt);
        String passStr = Encodes.encodeHex(hashPassword);

        String retVal = saltStr + passStr;

        return retVal;
    }

    public static boolean matches(CharSequence rawPassword, String encodedPassword) {
        byte[] salt = Encodes.decodeHex(encodedPassword.substring(0, 16));

        byte[] hashPassword = Digests.sha1(((String) rawPassword).getBytes(), salt, HASH_INTERATIONS);

        String saltStr = Encodes.encodeHex(salt);
        String passStr = Encodes.encodeHex(hashPassword);

        String strVal = saltStr + passStr;

        boolean retVal = encodedPassword.equals(strVal);

        return retVal;
    }

    public static void main(String[] args) {
        String str = "F:\\BaiduNetdiskDownload\\微信：vip44493667";
        String jiamiStr = encode(str);

        System.out.println("PassUtil.matches(str, jiamiStr) = " + PassUtil.matches(str, jiamiStr));
    }



    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception ex) {
            }
            conn = null;
        }
    }

    public static void closeStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception ex) {
            }
            ps = null;
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception ex) {
            }
            rs = null;
        }
    }

}
