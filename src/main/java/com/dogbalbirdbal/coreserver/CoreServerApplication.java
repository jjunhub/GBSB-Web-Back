package com.dogbalbirdbal.coreserver;
import com.dogbalbirdbal.database.manager.DataBaseServiceManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ( basePackages = {"com.dogbalbirdbal.controller"})
public class CoreServerApplication {
    @Value("${db.username}")
    private static String id;
    @Value("${db.password}")
    private static String password;

    public static void main(String[] args) {

        DataBaseServiceManager.getInstance().loadDataSource(id, password,
                "127.0.0.1", 5432, "postgres");
        SpringApplication.run(CoreServerApplication.class, args);
        System.out.println("테스트!");
    }



}
