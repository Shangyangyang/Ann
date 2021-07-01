package cn.ainannan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * springboot自带多线程配置
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    @Bean
    public Executor asyncServiceExecutor() {
        System.out.println("asyncServiceExecutor我执行了");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // <!-- 线程池维护线程的最少数量 -->
        executor.setCorePoolSize(4);
        // <!-- 线程池维护线程的最大数量 -->
        executor.setMaxPoolSize(32);
        // <!-- 缓存队列 -->
        executor.setQueueCapacity(128);
        // 线程名的前缀
        executor.setThreadNamePrefix("ann-");
        // <!-- 对拒绝task的处理策略 -->
        // 这里CallerRunsPolicy是调用主线程也就是main执行被拒绝的任务，后续再有任务进来，都被阻塞住，等main执行完才能继续分配线程。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
