package cn.ainannan.sys.test;

import com.google.common.base.Joiner;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;
import static org.springframework.test.util.AssertionErrors.fail;

public class JoinerTest {

    private List<String> arr = Arrays.asList("Google", "Java", "RabbitMq");
    private List<String> arrHaveNullValue = Arrays.asList("Google", "Java", "RabbitMq", null);


    /**
     * 1. 可以使用join连接(数组)和(集合), 设置分隔符.
     * 2. 返回拼接之后的一个字符串.<result>
     */
    @Test
    public void testJoin() {
        String result = Joiner.on("#").join(arr);
        System.out.println("result = " + result);
    }

    /**
     * 1. 可以使用join连接(数组)和(集合), 设置分隔符.
     * 2. 若(数组)和(集合)中含有null, 会抛出NullPointerException.
     * 3. 返回拼接之后的一个字符串.<result>
     */
    @Test
    public void testJoinHaveNullValue() {
        String result = Joiner.on("#").join(arrHaveNullValue);
        System.out.println("result = " + result);
    }

    /**
     * 1. 可以使用join连接(数组)和(集合), 设置分隔符.
     * 2. 若(数组)和(集合)中含有null, 会抛出NullPointerException.
     * 3. 可以使用skipNulls(), 去除null.
     * 4. 返回拼接之后的一个字符串.<result>
     */
    @Test
    public void test_Joiner_Skip_NullValue() {
        String result = Joiner.on("#").skipNulls().join(arrHaveNullValue);
        System.out.println("result = " + result);
    }

    /**
     * 1. 可以使用join连接(数组)和(集合), 设置分隔符.
     * 2. 若(数组)和(集合)中含有null, 会抛出NullPointerException.
     * 3. 可以使用useForNull(), 去替换null.
     * 4. 返回拼接之后的一个字符串.<result>
     */
    @Test
    public void test_Joiner_UseDefaultValue_NullValue() {
        String result = Joiner.on("#").useForNull("DEFAULT").join(arrHaveNullValue);
        System.out.println("result = " + result);
    }

    /**
     * 1. 可以使用join连接(数组)和(集合), 设置分隔符.
     * 2. 若(数组)和(集合)中含有null, 会抛出NullPointerException.
     * 3. 可以使用skipNulls(), 去除null.
     * 4. 把(数组)和(集合)结果放入到StringBuilder or StringBuffer中.<result>
     */
    @Test
    public void test_Joiner_Append_StringBuilder() {
        StringBuilder builder = new StringBuilder();
        StringBuilder resultBuilder = Joiner.on("#").skipNulls().appendTo(builder, arrHaveNullValue);
        System.out.println("result = " + resultBuilder.toString());

    }

    @Test
    public void test() {
//        System.out.println(Joiner.on("&").withKeyValueSeparator("=")
//                .join(ImmutableMap.of("id", "123", "name", "green")));

        Map<String, String> params = new HashMap<>(8);
        params.put("appid", "1");
        params.put("secret", "2");
        params.put("js_code", "3");
        params.put("grant_type", "authorization_code");

        System.out.println(Joiner.on("&").withKeyValueSeparator("=").join(params));
    }



    /**
     * 1. 可以使用join连接(数组)和(集合), 设置分隔符.
     * 2. 若(数组)和(集合)中含有null, 会抛出NullPointerException.
     * 3. 可以使用skipNulls(), 去除null.
     * 4. 把(数组)和(集合)结果放入到FileWriter中.<result>
     */
    @Test
    public void test_Joiner_Append_Writer() {
        String targetFileName = "D:\\usr\\guava-join-append.txt";

        try (FileWriter writer = new FileWriter(new File(targetFileName))) {
            Joiner.on("#").skipNulls().appendTo(writer, arr);
        } catch (IOException e) {
            fail("Joiner append to file is error!");
        }
    }

    /**
     * 1. 使用java8Stream达到和Join一样的功能.
     */
    @Test
    public void test_Java8_skip_NullValue() {
        String result = arrHaveNullValue.stream()
                .filter(item -> item != null && !item.isEmpty())
                .collect(joining("#"));
        System.out.println("result = " + result);
    }

    @Test
    public void test_Java8_UseDefaultValue_NullValue() {
        String result = arrHaveNullValue.stream()
                .map(item -> item == null || item.isEmpty() ? "DEFAULT" : item)
                .collect(joining("#"));
        System.out.println("result = " + result);
    }


}
