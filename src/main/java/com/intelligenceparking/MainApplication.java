package com.intelligenceparking;

import com.intelligenceparking.tool.BillUtil;
import com.intelligenceparking.tool.PicUtil;
import com.intelligenceparking.tool.SpringUtil;
import com.intelligenceparking.tool.dynamicTable.DynamicBillTable;
import com.intelligenceparking.tool.socket.MainServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

//此注解来自定义bean，修改上传文件大小限制
@Configuration
//此注解表示SpringBoot启动类
@SpringBootApplication
// 此注解表示动态扫描DAO接口所在包，实际上不加下面这条语句也可以找到
@MapperScan(value = "com.intelligenceparking.dao")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        MainServer server = new MainServer();
        server.startSocketServer(8088);
    }
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件数据大小
        factory.setMaxFileSize(DataSize.parse("1024MB"));
        // 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("102400KB"));
        return factory.createMultipartConfig();
    }
}
