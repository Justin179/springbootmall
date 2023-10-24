package com.justin.springbootmall.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class JobDriver {
    // execute the job every 5 secs
    public static void main(String[] args) throws SchedulerException {
        // Job
        JobDetail job = JobBuilder.newJob(FirstJob.class).withIdentity("job1", "group1").build();

        // Trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .startNow().withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * ? * * *")).build();

        // Scheduler
        StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(job,trigger);
        scheduler.start();

    }
}
