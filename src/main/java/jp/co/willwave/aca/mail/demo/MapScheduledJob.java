package jp.co.willwave.aca.mail.demo;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MapScheduledJob {

    private Map<String, SchedulerObjectInterface> mapSession = new HashMap<>();

    public void register(String key, SchedulerObjectInterface job) {
        mapSession.put(key, job);
        job.start();
    }

    public SchedulerObjectInterface get(String key) {
        return mapSession.get(key);
    }

    public Iterable<? extends SchedulerObjectInterface> values() {
        return mapSession.values();
    }

    public void delete(String key) {
        SchedulerObjectInterface job = mapSession.get(key);
        if(job != null){
            job.stop();
            mapSession.remove(key);
        }
    }

    public void restart(String key) {
        SchedulerObjectInterface job = mapSession.get(key);
        if(job != null){
            job.restart();
        }
    }
}
