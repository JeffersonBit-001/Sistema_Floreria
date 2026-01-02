/*package MicrometerHealth;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.micrometer.health.HealthCheckRegistry;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import io.prometheus.client.exporter.MetricsServlet;

public class MeterRegistryHealthExample {

    public static void main(String[] args) throws Exception {
        // Crear el registro de métricas para Micrometer
        MeterRegistry meterRegistry = new SimpleMeterRegistry();

        // Crear el registro de chequeos de salud
        HealthCheckRegistry healthCheckRegistry = new HealthCheckRegistry();

        // Agregar chequeos de salud personalizados
        addHealthChecks(healthCheckRegistry);

        // Exponer las métricas de salud a través de un servidor Jetty
        startHealthCheckServer(meterRegistry, healthCheckRegistry);

        // Mostrar que el servidor está en funcionamiento
        System.out.println("Servidor de métricas de salud en http://localhost:8080/metrics");
    }

    private static void addHealthChecks(HealthCheckRegistry healthCheckRegistry) {
        // Añadir chequeos de salud básicos
        healthCheckRegistry.register("system.memory", () -> {
            // Comprobación de la memoria libre (puedes agregar chequeos más específicos)
            long freeMemory = Runtime.getRuntime().freeMemory();
            if (freeMemory > 1000000000L) { // Si hay más de 1GB de memoria libre
                return HealthCheck.Result.healthy("Memoria suficiente");
            } else {
                return HealthCheck.Result.unhealthy("Memoria insuficiente");
            }
        });

        healthCheckRegistry.register("system.cpu", () -> {
            // Simular un chequeo de CPU (por ejemplo, si la carga promedio es baja)
            double load = getSystemCpuLoad();
            if (load < 0.7) { // Si la carga promedio es menor al 70%
                return HealthCheck.Result.healthy("Carga de CPU baja");
            } else {
                return HealthCheck.Result.unhealthy("Carga de CPU alta");
            }
        });
    }

    private static double getSystemCpuLoad() {
        // Aquí puedes usar una biblioteca externa o simplemente simular un valor
        // Por ejemplo, este valor puede provenir de un sistema real o de una métrica de tu aplicación
        return Math.random(); // Simula un valor aleatorio entre 0 y 1 (de 0% a 100% de carga)
    }

    private static void startHealthCheckServer(MeterRegistry meterRegistry, HealthCheckRegistry healthCheckRegistry) throws Exception {
        // Crear un servidor Jetty
        Server server = new Server(8080);

        // Configurar el contexto y los servlets para servir las métricas
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");

        // Agregar servlet de métricas de Prometheus
        context.addServlet(new ServletHolder(new MetricsServlet()), "/metrics");

        // Servir las métricas de salud en el contexto "/health"
        context.addServlet(new ServletHolder(new HealthCheckServlet(healthCheckRegistry)), "/health");

        // Iniciar el servidor
        server.setHandler(context);
        server.start();
    }
}
*/