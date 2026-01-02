package CronJobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CleanupJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // Aquí defines la lógica de lo que deseas hacer con el cron job
        System.out.println("Limpiando registros antiguos...");
        // Puedes agregar tu lógica para limpiar registros de la base de datos o cualquier otra tarea.
        // Ejemplo: Llamar a un método que elimine registros antiguos de la base de datos.
    }
}
