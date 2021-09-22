package cn.ainannan.sys.test.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTxt {
    public static void main(String[] args) throws IOException {
        method1();
    }

    /**
     * 根据字段解析成mysql添加字段的sql
     */
    public static void method1() throws IOException {
        /*
            @Excel(name="会员号")
            private String aomeiHuiyuanhao;

            ALTER TABLE table_name ADD COLUMN column_name VARCHAR(100) DEFAULT NULL COMMENT '新加字段' AFTER old_column;
         */

        List<String> strList = getFileStr("D://data/eva.txt");
        StringBuilder sb = new StringBuilder();
        String preStr = "";
        int count = 0;

        for (int i = 0; i < strList.size(); i+=2) {
            String excel = strList.get(i);
            String comment = excel.split("name=\"")[1].split("\"")[0];

            String ziduanStr = strList.get(i+1);
            String ziduans [] = ziduanStr.split(" ");
            String zdType = ziduans[1];
            String zd = ziduans[2].split(";")[0];


            // 组合
            sb.append("ALTER TABLE sht_evaluation ADD COLUMN ")
                    .append(zd).append(" ")
                    .append(getType(zdType)).append(" DEFAULT NULL COMMENT '")
                    .append(comment).append("' AFTER ").append(preStr).append(";");

            System.out.println(sb.toString());
            count++;
            sb = new StringBuilder();
            preStr = zd;
        }

        System.out.println("count = " + count);
    }

    public static String getType(String type){
        String str = "";

        switch (type){
            case "Double":
                str = "decimal(10,2)";
                break;
            case "Integer":
                str = "int";
                break;
            case "String":
                str = "varchar(128)";
                break;
            case "Date":
                str = "datetime";
                break;
            default:
                str = "varchar(128)";
        }


        return str;
    }

    public static List<String> getFileStr(String path) throws IOException {
        // File file = new File("D://data/filename.txt");

        FileInputStream inputStream = new FileInputStream(path);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;
        List<String> strList = new ArrayList<String>();
        while ((str = bufferedReader.readLine()) != null) {
            // System.out.println(str);
            strList.add(str);
        }
        inputStream.close();
        bufferedReader.close();

        return strList;
    }
}
