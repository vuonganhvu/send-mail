package jp.co.willwave.aca.mail.demo;

import jp.co.willwave.aca.mail.demo.job.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.stereotype.Component;

@Component
public class SchedulerDemo implements ISchedulerDemo {

    @Autowired
    private MapJob mapJob;

    @Autowired
    private TaskScheduler taskScheduler;


    @Override
    public void remove(String key) {
        mapJob.get(key).getFuture().cancel(false);
        mapJob.remove(key);
    }

    @Override
    public void update(String key, Trigger trigger) {
        Job job = mapJob.get(key);
        remove(key);
        register(key, job, trigger);
    }


    @Override
    public void register(String key, Job job, Trigger trigger) {
        job.setFuture(taskScheduler.schedule(job, trigger));
        mapJob.register(key, job);
    }
}
