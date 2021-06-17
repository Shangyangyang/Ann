package com.newheyd.base.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassUtil {

    public static final int HASH_INTERATIONS = 1024;

    public static final int SALT_SIZE = 8;

    public static Map<String, String> userMapOracle = new HashMap<String, String>();

    public static Map<String, String> userMapSQLServer = new HashMap<String, String>();

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
        //System.out.println(encode("a_123456"));

        //importUserData2SQLServerJd();
        //importUserData2SQLServerSq();

        //changeAreaOffice2SQLServerJd();
        //changeAreaOffice2SQLServerSq();

        //importUserData2SQLServer();
       // changeAreaOffice2SQLServer();
//
//        importUserData2Oracle();
//        changeAreaOffice2Oracle();
//        importUserRole2Oracle();
    }

    public static void importUserRole2Oracle() {
        Connection conn4SQLServer = null;
        PreparedStatement ps4SQLServer = null;
        ResultSet rs4SQLServer = null;

        Connection conn4Oracle = null;
        PreparedStatement ps4Oracle = null;

        try {
            String driverName4SQLServer = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String dbUrl4SQLServer = "jdbc:sqlserver://172.18.221.18:1433;databaseName=jncl_center";
            Class.forName(driverName4SQLServer);
            conn4SQLServer = DriverManager.getConnection(dbUrl4SQLServer, "sa", "jndpf_1234");

            String driverName4Oracle = "oracle.jdbc.OracleDriver";
            String dbUrl4Oracle = "jdbc:oracle:thin:@172.18.221.17:1521:orcl";
            Class.forName(driverName4Oracle);
            conn4Oracle = DriverManager.getConnection(dbUrl4Oracle, "sdcljzkf2018", "sdcljzkf2018");

            ps4SQLServer = conn4SQLServer.prepareStatement("select * from temp_jncl where [职务] in ('社区残协委员','社区康复协调员','康复协调员')");
            rs4SQLServer = ps4SQLServer.executeQuery();

            ps4Oracle = conn4Oracle.prepareStatement("insert into SYS_USER_ROLE(USER_ID,ROLE_ID,STATE) values(?,'fa9e002884cc4aaeafa7f487a31079a8','1')");

            int cnt = 0;
            while (rs4SQLServer.next()) {

                if (userMapOracle.containsKey(rs4SQLServer.getString("证件号码"))) continue;

                cnt++;
                System.out.println("######################## Oracle " + cnt);

                ps4Oracle.setString(1, rs4SQLServer.getString("证件号码"));

                ps4Oracle.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs4SQLServer);
            closeStatement(ps4SQLServer);
            closeStatement(ps4Oracle);
            closeConn(conn4SQLServer);
        }
    }

    public static void changeAreaOffice2Oracle() {
        Connection conn4SQLServer = null;
        Connection conn4Oracle = null;

        PreparedStatement psQueryUser = null;
        ResultSet rsQueryUser = null;

        PreparedStatement psCntAreaOffice = null;
        ResultSet rsCntAreaOffice = null;

        PreparedStatement psQueryAreaOffice = null;
        ResultSet rsQueryAreaOffice = null;

        PreparedStatement psUpdate = null;

        try {
            String driverName4SQLServer = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String dbUrl4SQLServer = "jdbc:sqlserver://172.18.221.18:1433;databaseName=jncl_center";
            Class.forName(driverName4SQLServer);
            conn4SQLServer = DriverManager.getConnection(dbUrl4SQLServer, "sa", "jndpf_1234");

            String driverName4Oracle = "oracle.jdbc.OracleDriver";
            String dbUrl4Oracle = "jdbc:oracle:thin:@172.18.221.17:1521:orcl";
            Class.forName(driverName4Oracle);
            conn4Oracle = DriverManager.getConnection(dbUrl4Oracle, "sdcljzkf2018", "sdcljzkf2018");

            psQueryUser = conn4SQLServer.prepareStatement("select * from temp_jncl");
            rsQueryUser = psQueryUser.executeQuery();

            psCntAreaOffice = conn4Oracle.prepareStatement("select count(*) from sys_office where name = ?");
            psQueryAreaOffice = conn4Oracle.prepareStatement("select * from sys_office where name = ?");

            psUpdate = conn4Oracle.prepareStatement("update sys_user set office_id = ?, company_id = ? where login_name = ?");

            int cnt = 0;
            while (rsQueryUser.next()) {

                if (userMapOracle.containsKey(rsQueryUser.getString("证件号码"))) continue;

                cnt++;
                System.out.println("######################## Oracle " + cnt);

                psCntAreaOffice.setString(1, rsQueryUser.getString("行政区划"));
                rsCntAreaOffice = psCntAreaOffice.executeQuery();
                rsCntAreaOffice.next();

                int rowCnt = rsCntAreaOffice.getInt(1);
                System.out.println("######################## Oracle  sys_office " + rowCnt);
                if (rowCnt != 1) {
                    continue;
                }

                psQueryAreaOffice.setString(1, rsQueryUser.getString("行政区划"));
                rsQueryAreaOffice = psQueryAreaOffice.executeQuery();
                rsQueryAreaOffice.next();

                String areaCode = rsQueryAreaOffice.getString("id");
                if (areaCode != null && !areaCode.equals("")) {
                    if (areaCode.endsWith("00000000") || areaCode.endsWith("0000000000")) {
                        continue;
                    } else if (areaCode.endsWith("000000")) {
                        psUpdate.setString(2, areaCode.substring(0, 6));
                    } else if (areaCode.endsWith("000")) {
                        psUpdate.setString(2, areaCode.substring(0, 9));
                    } else {
                        psUpdate.setString(2, areaCode);
                    }
                }
                psUpdate.setString(1, areaCode);
                psUpdate.setString(3, rsQueryUser.getString("证件号码"));
                psUpdate.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rsQueryUser);
            closeStatement(psQueryUser);
            closeStatement(psUpdate);
            closeConn(conn4SQLServer);
        }
    }

    public static void changeAreaOffice2SQLServerSq() {
        Connection conn = null;

        PreparedStatement psQueryUser = null;
        ResultSet rsQueryUser = null;

        PreparedStatement psCntAreaOffice = null;
        ResultSet rsCntAreaOffice = null;

        PreparedStatement psQueryAreaOffice = null;
        ResultSet rsQueryAreaOffice = null;

        PreparedStatement psUpdate = null;

        try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String dbUrl = "jdbc:sqlserver://172.18.221.18:1433;databaseName=jncl_center";
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbUrl, "sa", "jndpf_1234");

            psQueryUser = conn.prepareStatement("select * from sys_user_fuju_sqry_temp where flag = 0");
            rsQueryUser = psQueryUser.executeQuery();

            psCntAreaOffice = conn.prepareStatement("select count(*) from sys_area where area_name = ?");
            psQueryAreaOffice = conn.prepareStatement("select * from sys_area where area_name = ?");

            psUpdate = conn.prepareStatement("update sys_user_fuju_sqry set area_code = ?, office_code = ? where user_code = ?");

            int cnt = 0;
            while (rsQueryUser.next()) {

                //if (userMapSQLServer.containsKey(rsQueryUser.getString("证件号码"))) continue;

                cnt++;
                System.out.println("######################## SQLServer " + cnt);

                psCntAreaOffice.setString(1, rsQueryUser.getString("行政区划"));
                rsCntAreaOffice = psCntAreaOffice.executeQuery();
                rsCntAreaOffice.next();

                int rowCnt = rsCntAreaOffice.getInt(1);
                System.out.println("######################## SQLServer  sys_area " + rowCnt);
                if (rowCnt != 1) {
                    continue;
                }

                psQueryAreaOffice.setString(1, rsQueryUser.getString("行政区划"));
                rsQueryAreaOffice = psQueryAreaOffice.executeQuery();
                rsQueryAreaOffice.next();

                String areaCode = rsQueryAreaOffice.getString("area_code");
                if (areaCode != null && !areaCode.equals("")) {
                    if (areaCode.endsWith("00000000") || areaCode.endsWith("0000000000")) {
                        continue;
                    } else if (areaCode.endsWith("000000")) {
                        psUpdate.setString(2, areaCode.substring(0, 6));
                    } else if (areaCode.endsWith("000")) {
                        psUpdate.setString(2, areaCode.substring(0, 9));
                    } else {
                        psUpdate.setString(2, areaCode);
                    }
                }
                psUpdate.setString(1, areaCode);
                psUpdate.setString(3, rsQueryUser.getString("证件号码"));
                psUpdate.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rsQueryUser);
            closeStatement(psQueryUser);
            closeStatement(psUpdate);
            closeConn(conn);
        }
    }

    public static void changeAreaOffice2SQLServerJd() {
        Connection conn = null;

        PreparedStatement psQueryUser = null;
        ResultSet rsQueryUser = null;

        PreparedStatement psCntAreaOffice = null;
        ResultSet rsCntAreaOffice = null;

        PreparedStatement psQueryAreaOffice = null;
        ResultSet rsQueryAreaOffice = null;

        PreparedStatement psUpdate = null;

        try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String dbUrl = "jdbc:sqlserver://172.18.221.18:1433;databaseName=jncl_center";
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbUrl, "sa", "jndpf_1234");

            psQueryUser = conn.prepareStatement("select * from sys_user_fuju_jdry_temp where flag = 0");
            rsQueryUser = psQueryUser.executeQuery();

            psCntAreaOffice = conn.prepareStatement("select count(*) from sys_area where area_name = ?");
            psQueryAreaOffice = conn.prepareStatement("select * from sys_area where area_name = ?");

            psUpdate = conn.prepareStatement("update sys_user_fuju_jdry set area_code = ?, office_code = ? where user_code = ?");

            int cnt = 0;
            while (rsQueryUser.next()) {

                //if (userMapSQLServer.containsKey(rsQueryUser.getString("证件号码"))) continue;

                cnt++;
                System.out.println("######################## SQLServer " + cnt);

                psCntAreaOffice.setString(1, rsQueryUser.getString("行政区划"));
                rsCntAreaOffice = psCntAreaOffice.executeQuery();
                rsCntAreaOffice.next();

                int rowCnt = rsCntAreaOffice.getInt(1);
                System.out.println("######################## SQLServer  sys_area " + rowCnt);
                if (rowCnt != 1) {
                    continue;
                }

                psQueryAreaOffice.setString(1, rsQueryUser.getString("行政区划"));
                rsQueryAreaOffice = psQueryAreaOffice.executeQuery();
                rsQueryAreaOffice.next();

                String areaCode = rsQueryAreaOffice.getString("area_code");
                if (areaCode != null && !areaCode.equals("")) {
                    if (areaCode.endsWith("00000000") || areaCode.endsWith("0000000000")) {
                        continue;
                    } else if (areaCode.endsWith("000000")) {
                        psUpdate.setString(2, areaCode.substring(0, 6));
                    } else if (areaCode.endsWith("000")) {
                        psUpdate.setString(2, areaCode.substring(0, 9));
                    } else {
                        psUpdate.setString(2, areaCode);
                    }
                }
                psUpdate.setString(1, areaCode);
                psUpdate.setString(3, rsQueryUser.getString("证件号码"));
                psUpdate.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rsQueryUser);
            closeStatement(psQueryUser);
            closeStatement(psUpdate);
            closeConn(conn);
        }
    }

    public static void changeAreaOffice2SQLServer() {
        Connection conn = null;

        PreparedStatement psQueryUser = null;
        ResultSet rsQueryUser = null;

        PreparedStatement psCntAreaOffice = null;
        ResultSet rsCntAreaOffice = null;

        PreparedStatement psQueryAreaOffice = null;
        ResultSet rsQueryAreaOffice = null;

        PreparedStatement psUpdate = null;

        try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String dbUrl = "jdbc:sqlserver://172.18.221.18:1433;databaseName=jncl_center";
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbUrl, "sa", "jndpf_1234");

            psQueryUser = conn.prepareStatement("select * from temp_jncl");
            rsQueryUser = psQueryUser.executeQuery();

            psCntAreaOffice = conn.prepareStatement("select count(*) from sys_area where area_name = ?");
            psQueryAreaOffice = conn.prepareStatement("select * from sys_area where area_name = ?");

            psUpdate = conn.prepareStatement("update sys_user set area_code = ?, office_code = ? where user_code = ?");

            int cnt = 0;
            while (rsQueryUser.next()) {

                if (userMapSQLServer.containsKey(rsQueryUser.getString("证件号码"))) continue;

                cnt++;
                System.out.println("######################## SQLServer " + cnt);

                psCntAreaOffice.setString(1, rsQueryUser.getString("行政区划"));
                rsCntAreaOffice = psCntAreaOffice.executeQuery();
                rsCntAreaOffice.next();

                int rowCnt = rsCntAreaOffice.getInt(1);
                System.out.println("######################## SQLServer  sys_area " + rowCnt);
                if (rowCnt != 1) {
                    continue;
                }

                psQueryAreaOffice.setString(1, rsQueryUser.getString("行政区划"));
                rsQueryAreaOffice = psQueryAreaOffice.executeQuery();
                rsQueryAreaOffice.next();

                String areaCode = rsQueryAreaOffice.getString("area_code");
                if (areaCode != null && !areaCode.equals("")) {
                    if (areaCode.endsWith("00000000") || areaCode.endsWith("0000000000")) {
                        continue;
                    } else if (areaCode.endsWith("000000")) {
                        psUpdate.setString(2, areaCode.substring(0, 6));
                    } else if (areaCode.endsWith("000")) {
                        psUpdate.setString(2, areaCode.substring(0, 9));
                    } else {
                        psUpdate.setString(2, areaCode);
                    }
                }
                psUpdate.setString(1, areaCode);
                psUpdate.setString(3, rsQueryUser.getString("证件号码"));
                psUpdate.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rsQueryUser);
            closeStatement(psQueryUser);
            closeStatement(psUpdate);
            closeConn(conn);
        }
    }

    public static void importUserData2Oracle() {
        Connection conn4SQLServer = null;
        PreparedStatement ps4SQLServer = null;
        ResultSet rs4SQLServer = null;

        Connection conn4Oracle = null;
        PreparedStatement ps4Oracle = null;

        PreparedStatement ps4OracleQuery = null;
        ResultSet rs4OracleQuery = null;

        try {
            String driverName4SQLServer = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String dbUrl4SQLServer = "jdbc:sqlserver://172.18.221.18:1433;databaseName=jncl_center";
            Class.forName(driverName4SQLServer);
            conn4SQLServer = DriverManager.getConnection(dbUrl4SQLServer, "sa", "jndpf_1234");

            String driverName4Oracle = "oracle.jdbc.OracleDriver";
            String dbUrl4Oracle = "jdbc:oracle:thin:@172.18.221.17:1521:orcl";
            Class.forName(driverName4Oracle);
            conn4Oracle = DriverManager.getConnection(dbUrl4Oracle, "sdcljzkf2018", "sdcljzkf2018");

            ps4SQLServer = conn4SQLServer.prepareStatement("select * from temp_jncl");
            rs4SQLServer = ps4SQLServer.executeQuery();

            ps4Oracle = conn4Oracle.prepareStatement("insert into SYS_USER(ID,LOGIN_NAME,PASSWORD,NAME,MOBILE,USER_TYPE,CREATE_DATE,UPDATE_DATE,DEL_FLAG) values(?,?,?,?,?,?,?,?,?)");

            int cnt = 0;
            while (rs4SQLServer.next()) {
                cnt++;
                System.out.println("######################## Oracle " + cnt);

                String cardNum = rs4SQLServer.getString("证件号码");

                //查询此人是否已存在
                ps4OracleQuery = conn4Oracle.prepareStatement("select * from SYS_USER where LOGIN_NAME = '" + cardNum + "'");
                rs4OracleQuery = ps4OracleQuery.executeQuery();
                if (rs4OracleQuery.next()) {
                    closeResultSet(rs4OracleQuery);
                    closeStatement(ps4OracleQuery);
                    userMapOracle.put(cardNum, "");
                    continue;
                }

                int cardNumLen = cardNum.length();
                String userPass = cardNum.substring(cardNumLen - 6, cardNumLen);
                userPass = encode(userPass);

                ps4Oracle.setString(1, UUIDUtils.getUUID());
                ps4Oracle.setString(2, cardNum);
                ps4Oracle.setString(3, userPass);
                ps4Oracle.setString(4, rs4SQLServer.getString("姓名"));
                ps4Oracle.setString(5, rs4SQLServer.getString("联系电话"));
                ps4Oracle.setString(6, "1");
                ps4Oracle.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
                ps4Oracle.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
                ps4Oracle.setString(9, "0");

                ps4Oracle.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs4SQLServer);
            closeStatement(ps4SQLServer);
            closeStatement(ps4Oracle);
            closeConn(conn4SQLServer);
        }
    }

    public static void importUserData2SQLServerSq() {
        Connection conn = null;

        PreparedStatement psQuery = null;
        ResultSet rsQuery = null;

        PreparedStatement psInsert = null;

        PreparedStatement ps4SQLServerQuery = null;
        ResultSet rs4SQLServerQuery = null;

        try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String dbUrl = "jdbc:sqlserver://172.18.221.18:1433;databaseName=jncl_center";

            Class.forName(driverName);
            conn = DriverManager.getConnection(dbUrl, "sa", "jndpf_1234");

            psQuery = conn.prepareStatement("select * from sys_user_fuju_sqzh_temp where flag = 0");

            rsQuery = psQuery.executeQuery();

            psInsert = conn.prepareStatement("insert into sys_user_fuju_sqzh(ID,USER_CODE,USER_PASS,USER_NAME,CARD_NUM,CARD_TYPE,PHONE_NUM,CREATE_DATE,UPDATE_DATE,DEL_FLAG,WORK_PHONE,WORK_EMAIL,SORT,WORK_DUTY,REMARKS) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            int cnt = 0;
            while (rsQuery.next()) {
                cnt++;
                System.out.println("######################## SQLServer " + cnt);

                String cardNum = rsQuery.getString("证件号码");

                //查询此人是否已存在
                ps4SQLServerQuery = conn.prepareStatement("select * from SYS_USER where USER_CODE = '" + cardNum + "'");
                rs4SQLServerQuery = ps4SQLServerQuery.executeQuery();
                if (rs4SQLServerQuery.next()) {
                    closeResultSet(rs4SQLServerQuery);
                    closeStatement(ps4SQLServerQuery);
                    userMapSQLServer.put(cardNum, "");
                    continue;
                }

                int cardNumLen = cardNum.length();
                String userPass = cardNum.substring(cardNumLen - 6, cardNumLen);
                userPass = encode(userPass);

                psInsert.setString(1, UUIDUtils.getUUID());
                psInsert.setString(2, cardNum);
                psInsert.setString(3, userPass);
                psInsert.setString(4, rsQuery.getString("姓名"));
                psInsert.setString(5, cardNum);
                psInsert.setString(6, "1");
                psInsert.setString(7, rsQuery.getString("联系电话"));
                psInsert.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
                psInsert.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
                psInsert.setString(10, "0");
                psInsert.setString(11, rsQuery.getString("办公电话"));
                psInsert.setString(12, rsQuery.getString("邮箱"));
                psInsert.setInt(13, 9500 + cnt);
                psInsert.setString(14, rsQuery.getString("职务"));
                psInsert.setString(15, rsQuery.getString("备注"));

                psInsert.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rsQuery);
            closeStatement(psQuery);
            closeStatement(psInsert);
            closeConn(conn);
        }
    }

    public static void importUserData2SQLServerJd() {
        Connection conn = null;

        PreparedStatement psQuery = null;
        ResultSet rsQuery = null;

        PreparedStatement psInsert = null;

        PreparedStatement ps4SQLServerQuery = null;
        ResultSet rs4SQLServerQuery = null;

        try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String dbUrl = "jdbc:sqlserver://172.18.221.18:1433;databaseName=jncl_center";

            Class.forName(driverName);
            conn = DriverManager.getConnection(dbUrl, "sa", "jndpf_1234");

            psQuery = conn.prepareStatement("select * from sys_user_fuju_jdry_temp where flag = 0");

            rsQuery = psQuery.executeQuery();

            psInsert = conn.prepareStatement("insert into sys_user_fuju_jdry(ID,USER_CODE,USER_PASS,USER_NAME,CARD_NUM,CARD_TYPE,PHONE_NUM,CREATE_DATE,UPDATE_DATE,DEL_FLAG,WORK_PHONE,WORK_EMAIL,SORT,WORK_DUTY,REMARKS) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            int cnt = 0;
            while (rsQuery.next()) {
                cnt++;
                System.out.println("######################## SQLServer " + cnt);

                String cardNum = rsQuery.getString("证件号码");

                //查询此人是否已存在
                ps4SQLServerQuery = conn.prepareStatement("select * from SYS_USER where USER_CODE = '" + cardNum + "'");
                rs4SQLServerQuery = ps4SQLServerQuery.executeQuery();
                if (rs4SQLServerQuery.next()) {
                    closeResultSet(rs4SQLServerQuery);
                    closeStatement(ps4SQLServerQuery);
                    userMapSQLServer.put(cardNum, "");
                    continue;
                }

                int cardNumLen = cardNum.length();
                String userPass = cardNum.substring(cardNumLen - 6, cardNumLen);
                userPass = encode(userPass);

                psInsert.setString(1, UUIDUtils.getUUID());
                psInsert.setString(2, cardNum);
                psInsert.setString(3, userPass);
                psInsert.setString(4, rsQuery.getString("姓名"));
                psInsert.setString(5, cardNum);
                psInsert.setString(6, "1");
                psInsert.setString(7, rsQuery.getString("联系电话"));
                psInsert.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
                psInsert.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
                psInsert.setString(10, "0");
                psInsert.setString(11, rsQuery.getString("办公电话"));
                psInsert.setString(12, rsQuery.getString("邮箱"));
                psInsert.setInt(13, 9000 + cnt);
                psInsert.setString(14, rsQuery.getString("职务"));
                psInsert.setString(15, rsQuery.getString("备注"));

                psInsert.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rsQuery);
            closeStatement(psQuery);
            closeStatement(psInsert);
            closeConn(conn);
        }
    }

    public static void importUserData2SQLServer() {
        Connection conn = null;

        PreparedStatement psQuery = null;
        ResultSet rsQuery = null;

        PreparedStatement psInsert = null;

        PreparedStatement ps4SQLServerQuery = null;
        ResultSet rs4SQLServerQuery = null;

        try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String dbUrl = "jdbc:sqlserver://172.18.221.18:1433;databaseName=jncl_center";

            Class.forName(driverName);
            conn = DriverManager.getConnection(dbUrl, "sa", "jndpf_1234");

            psQuery = conn.prepareStatement("select * from temp_jncl");

            rsQuery = psQuery.executeQuery();

            psInsert = conn.prepareStatement("insert into sys_user(ID,USER_CODE,USER_PASS,USER_NAME,CARD_NUM,CARD_TYPE,PHONE_NUM,CREATE_DATE,UPDATE_DATE,DEL_FLAG,WORK_PHONE,WORK_EMAIL,SORT,WORK_DUTY) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            int cnt = 0;
            while (rsQuery.next()) {
                cnt++;
                System.out.println("######################## SQLServer " + cnt);

                String cardNum = rsQuery.getString("证件号码");

                //查询此人是否已存在
                ps4SQLServerQuery = conn.prepareStatement("select * from SYS_USER where USER_CODE = '" + cardNum + "'");
                rs4SQLServerQuery = ps4SQLServerQuery.executeQuery();
                if (rs4SQLServerQuery.next()) {
                    closeResultSet(rs4SQLServerQuery);
                    closeStatement(ps4SQLServerQuery);
                    userMapSQLServer.put(cardNum, "");
                    continue;
                }

                int cardNumLen = cardNum.length();
                String userPass = cardNum.substring(cardNumLen - 6, cardNumLen);
                userPass = encode(userPass);

                psInsert.setString(1, UUIDUtils.getUUID());
                psInsert.setString(2, cardNum);
                psInsert.setString(3, userPass);
                psInsert.setString(4, rsQuery.getString("姓名"));
                psInsert.setString(5, cardNum);
                psInsert.setString(6, "1");
                psInsert.setString(7, rsQuery.getString("联系电话"));
                psInsert.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
                psInsert.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
                psInsert.setString(10, "0");
                psInsert.setString(11, rsQuery.getString("办公电话"));
                psInsert.setString(12, rsQuery.getString("邮箱"));
                psInsert.setInt(13, 8000 + cnt);
                psInsert.setString(14, rsQuery.getString("职务"));

                psInsert.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rsQuery);
            closeStatement(psQuery);
            closeStatement(psInsert);
            closeConn(conn);
        }
    }

    public static void changePass() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<String> list = new ArrayList<String>();

        try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String dbUrl = "jdbc:sqlserver://172.18.221.18:1433;databaseName=jncl_center";

            Class.forName(driverName);
            conn = DriverManager.getConnection(dbUrl, "sa", "jndpf_1234");

            ps = conn.prepareStatement("select * from sys_user where user_code != 'admin'");

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getString("card_num"));
            }
            closeResultSet(rs);
            closeStatement(ps);

            for (String cardNum : list) {
                int len = cardNum.length();
                String pass = cardNum.substring(len - 6, len);
                pass = encode(pass);
                ps = conn.prepareStatement("update sys_user set user_pass = '" + pass + "' where card_num = '" + cardNum + "'");
                ps.execute();
                closeStatement(ps);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
            closeConn(conn);
        }
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
