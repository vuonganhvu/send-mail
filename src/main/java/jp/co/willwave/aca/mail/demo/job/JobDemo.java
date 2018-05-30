package jp.co.willwave.aca.mail.demo.job;

import java.util.Date;

public class JobDemo extends Job {

    @Override
    public void doJob() {
        System.out.println(JobDemo.class + "  Hello World! " + new Date());
    }
}
