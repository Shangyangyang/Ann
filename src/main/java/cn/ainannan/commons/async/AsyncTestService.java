package cn.ainannan.commons.async;

import java.util.List;

/**
 * 多线程用到的接口定义
 */
public interface AsyncTestService {
    /**
     * 测试用，给予指定的集合，循环打印
     * @param ints
     */
    void test(List<Integer>ints);
}