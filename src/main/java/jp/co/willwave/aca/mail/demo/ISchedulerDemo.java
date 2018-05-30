package jp.co.willwave.aca.mail.demo;

import jp.co.willwave.aca.mail.demo.job.Job;
import org.springframework.scheduling.Trigger;

public interface ISchedulerDemo {
    void update(String key, Trigger trigger);
    void register(String key, Job job, Trigger trigger);
    void remove(String key);
}
