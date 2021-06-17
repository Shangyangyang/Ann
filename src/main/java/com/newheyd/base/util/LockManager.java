package com.newheyd.base.util;

import java.util.HashMap;
import java.util.Map;

public class LockManager {

    private static Map<String, Long> lockMap = new HashMap<String, Long>();

    private static Map<String, Integer> countMap = new HashMap<String, Integer>();


    public static void addUser(String userCode) {
        if (userCode == null || userCode.equals("")) return;

        if (!lockMap.containsKey(userCode)) {
            lockMap.put(userCode, System.currentTimeMillis());
        }
    }

    public static void removeUser(String userCode) {
        if (userCode == null || userCode.equals("")) return;

        lockMap.remove(userCode);
        countMap.remove(userCode);
    }

    public static boolean checkUser(String userCode) {
        if (userCode == null || userCode.equals("")) return false;

        Long l = lockMap.get(userCode);
        if (l == null) return true;
        Long n = System.currentTimeMillis();
        if (n - l > 10 * 60 * 1000) {
            lockMap.remove(userCode);
            return true;
        }
        return false;
    }

    public static void addCount(String userCode) {
        if (userCode == null || userCode.equals("")) return;

        if (!countMap.containsKey(userCode)) {
            countMap.put(userCode, 1);
            return;
        }

        Integer i = countMap.get(userCode);
        if (i == null) {
            countMap.put(userCode, 1);
            return;
        }

        if (i > 6) {
            lockMap.put(userCode, System.currentTimeMillis());
            countMap.remove(userCode);
            return;
        }

        i++;
        countMap.put(userCode, i);
    }

}
