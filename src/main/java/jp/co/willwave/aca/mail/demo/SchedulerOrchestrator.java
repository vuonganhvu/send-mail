package jp.co.willwave.aca.mail.demo;

import jp.co.willwave.aca.mail.demo.MapScheduledJob;
import jp.co.willwave.aca.mail.demo.SchedulerObjectInterface;
import jp.co.willwave.aca.mail.demo.job.MyFirstJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;

import javax.annotation.PostConstruct;

@Configuration
public class SchedulerOrchestrator {

    @Autowired
    private MapScheduledJob mapScheduledJob;

    @PostConstruct
    public void initScheduler() {
        //TODO data base run init
        startAll();
    }

    public void startAll() {
        for (SchedulerObjectInterface schedulerObjectInterface : mapScheduledJob.values()) {
            schedulerObjectInterface.start();
        }
    }

}
