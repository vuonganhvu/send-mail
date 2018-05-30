package jp.co.willwave.aca.mail.demo.job;

import java.util.concurrent.ScheduledFuture;

public abstract class Job implements Runnable {

    protected ScheduledFuture future;

    @Override
    public void run() {
        doJob();
    }

    abstract void doJob() ;

    public ScheduledFuture getFuture() {
        return future;
    }

    public void setFuture(ScheduledFuture future) {
        this.future = future;
    }
}
