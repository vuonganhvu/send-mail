package jp.co.willwave.aca.mail.service;

import jp.co.willwave.aca.mail.demo.MapScheduledJob;
import jp.co.willwave.aca.mail.demo.SchedulerDemo;
import jp.co.willwave.aca.mail.demo.job.Job;
import jp.co.willwave.aca.mail.demo.job.JobDemo;
import jp.co.willwave.aca.mail.demo.job.MyFirstJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private MapScheduledJob mapScheduledJob;
    @Autowired
    private TaskScheduler taskScheduler;
    @Autowired
    private SchedulerDemo schedulerDemo;


    @Override
    public void updateSchedule() {
        mapScheduledJob.restart("Key1");
    }

    @Override
    public void createSchedule() {
        MyFirstJob myFirstJob = new MyFirstJob();
        myFirstJob.setDivisionId(1L);
        myFirstJob.setTaskScheduler(taskScheduler);
        mapScheduledJob.register("Key1", myFirstJob);
    }

    @Override
    public void deleteSchedule() {
        mapScheduledJob.delete("Key1");
    }

    @Override
    public void updateSchedule2(String key) {
        Long period = 10000L;
        PeriodicTrigger trigger =  new PeriodicTrigger(period, TimeUnit.MILLISECONDS);
        schedulerDemo.update(key, trigger);
    }

    @Override
    public void createSchedule2(String key) {
        Long period = 5000L;
        PeriodicTrigger trigger =  new PeriodicTrigger(period, TimeUnit.MILLISECONDS);
        Job job = new JobDemo();
        trigger.setFixedRate(true);
        schedulerDemo.register(key, job, trigger);
    }

    @Override
    public void deleteSchedule2(String key) {
        schedulerDemo.remove(key);
    }
}
