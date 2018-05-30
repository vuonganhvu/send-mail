package jp.co.willwave.aca.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("jp.co.willwave.aca.mail")
public class SendMailApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SendMailApplication.class, args);
        System.out.println("taskScheduler " + context.getBean("taskScheduler"));
    }
}
