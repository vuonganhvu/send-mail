package jp.co.willwave.aca.mail.demo.job;

import jp.co.willwave.aca.mail.demo.SchedulerObjectInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Component
public class BaseJob implements SchedulerObjectInterface {

    private ScheduledFuture future;
    private Trigger trigger;

    @Autowired
    protected TaskScheduler scheduler;

    @Override
    public void start() {
        PeriodicTrigger periodicTrigger = new PeriodicTrigger(5000, TimeUnit.MILLISECONDS);
        periodicTrigger.setFixedRate(true);
        future = scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(BaseJob.class + "  Hello World! " + new Date());
            }
        }, trigger);

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
}
