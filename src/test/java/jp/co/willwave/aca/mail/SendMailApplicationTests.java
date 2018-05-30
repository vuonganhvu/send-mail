package jp.co.willwave.aca.mail;

import jp.co.willwave.aca.mail.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMailApplicationTests {

    @Autowired
    private EmailService emailService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendEmailText() {
        String to = "anhvuong.tmdt@gmail.com";
        String message = "test send mail";
        String subject = "Relipa test";
        emailService.sendSimpleMessage(to, subject, message);
    }

    @Test
    public void sendEmailHtml() {
        String to = "anhvuong.tmdt@gmail.com";
        String message = "<html><body><img src='http://sv1.upsieutoc.com/2018/05/17/ic_pin_test8bd427e93ab6a513.png' </body></html>";
        String subject = "Relipa test";
        emailService.sendMessageHtml(to, subject, message);
    }

}
