package jp.co.willwave.aca.mail.demo.job;

import jp.co.willwave.aca.mail.demo.SchedulerObjectInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Component
public class MyFirstJob implements SchedulerObjectInterface {

    public static final String JOB = "MyFirstJob";
    private Long divisionId;

    private ScheduledFuture future;

    private TaskScheduler taskScheduler;


    @Override
    public void start() {
        Long period = 5000L; //TODO get db
        PeriodicTrigger periodicTrigger = new PeriodicTrigger(period, TimeUnit.MILLISECONDS);
        periodicTrigger.setFixedRate(true);
        future = taskScheduler.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(JOB + "  Hello World! " + new Date());
            }
        }, periodicTrigger);

    }

    @Override
    public void stop() {
        future.cancel(false);
    }

    @Override
    public void restart() {
        stop();
        start();
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public void setTaskScheduler(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }
}
