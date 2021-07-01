package cn.ainannan.commons.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AsyncUtil {
    
    @Autowired
    AsyncServiceImpl asyncTestService;

    public static Integer [] ides = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,
            15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};

    // @PostConstruct
    @Scheduled(cron = "0 */1 * * * ?")
    public void test(){
        int size = ides.length / 4 + 1;
        List<Integer> ints = Arrays.asList(ides);
        for (int i = 1; i <= 4; i++) {
            int s = i * size - size;
            int e = i * size;
            if(e > ides.length) e = ides.length;
            asyncTestService.test(ints.subList(s, e));
        }
    }
}
