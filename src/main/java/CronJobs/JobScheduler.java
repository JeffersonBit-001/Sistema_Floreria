package CronJobs;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JobScheduler {

    public static void main(String[] args) {
        try {
            // Crear un scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // Definir el Job
            JobDetail job = JobBuilder.newJob(CleanupJob.class)
                    .withIdentity("cleanupJob", "group1")
                    .build();

            // Definir un Trigger para ejecutar el Job cada 24 horas
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("cleanupTrigger", "group1")
                    .startNow()  // Inicia inmediatamente
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInHours(24)  // Ejecuta cada 24 horas
                            .repeatForever())
                    .build();

            // Programar el Job con el Trigger
            scheduler.scheduleJob(job, trigger);

            // Iniciar el scheduler
            scheduler.start();
            
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
