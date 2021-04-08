package cn.ainannan.sys.test.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FileTest {
    public static void main(String[] args) throws IOException {

        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("H:\\尚羊羊\\软件开发\\vueSpace\\my-front-project\\public\\小类.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;

        // 接收区

        Map<String, String> oneMap = new HashMap<String, String>();
        Map<String, String> twoMap = new HashMap<String, String>();
        Map<String, String> threeMap = new HashMap<String, String>();
        Map<String, String> fourMap = new HashMap<String, String>();

        while ((str = bufferedReader.readLine()) != null) {
            String [] strs = str.split(" ");

            if(strs[0].length() == 1) oneMap.put(strs[0], strs[1]);
            if(strs[0].length() == 2) twoMap.put(strs[0], strs[1]);
            if(strs[0].length() == 3) threeMap.put(strs[0], strs[1]);
            if(strs[0].length() == 4) fourMap.put(strs[0], strs[1]);
        }

        System.out.println(oneMap.toString());
        System.out.println(twoMap.toString());
        System.out.println(threeMap.toString());
        System.out.println(fourMap.toString());

        //close
        inputStream.close();
        bufferedReader.close();
    }
}
