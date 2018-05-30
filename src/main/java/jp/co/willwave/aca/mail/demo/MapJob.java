package jp.co.willwave.aca.mail.demo;

import jp.co.willwave.aca.mail.demo.job.Job;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MapJob {
    private Map<String, Job> mapJob = new HashMap<>();

    public Job get(String key) {
        return mapJob.get(key);
    }

    public void setMapJob(Map<String, Job> mapJob) {
        this.mapJob = mapJob;
    }

    public void register(String key, Job job) {
        this.mapJob.put(key, job);
    }

    public void remove(String key) {
        this.mapJob.remove(key);
    }
}
