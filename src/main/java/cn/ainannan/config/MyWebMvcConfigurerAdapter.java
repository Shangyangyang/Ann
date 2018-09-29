package cn.ainannan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    /**
     * 配置静态访问资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
        		"file:H:\\尚羊羊\\图片\\个人相册\\", 
        		// "classpath:/static/", 
        		"file:H:\\尚羊羊\\个人文档\\excel\\"
        	);
        super.addResourceHandlers(registry);
    }
}