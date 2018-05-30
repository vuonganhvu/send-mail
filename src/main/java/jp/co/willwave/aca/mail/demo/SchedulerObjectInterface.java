package jp.co.willwave.aca.mail.demo;

import org.springframework.beans.factory.annotation.Autowired;

public interface SchedulerObjectInterface {
    void start();
    void stop();
    void restart();
}
