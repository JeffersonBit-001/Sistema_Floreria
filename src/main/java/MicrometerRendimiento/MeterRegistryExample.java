package MicrometerRendimiento;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class MeterRegistryExample {

    // Instanciamos un MeterRegistry simple
    private static final MeterRegistry meterRegistry = new SimpleMeterRegistry();

    public static void main(String[] args) {
        // Ejemplo de uso: Medir el tiempo de ejecución de un método
        Timer timer = meterRegistry.timer("method.execution.time");

        // Medir el tiempo que tarda en ejecutarse este bloque de código
        timer.record(() -> {
            simulateMethod();
        });

        // Incrementar un contador de invocaciones
        Counter counter = meterRegistry.counter("method.invocations");
        counter.increment();

        // Imprimir métricas
        System.out.println("Métricas registradas:");
        meterRegistry.get("method.execution.time").timer();
        meterRegistry.get("method.invocations").counter();

        // Mostrar las métricas
        System.out.println("Método ejecutado " + counter.count() + " veces.");
    }

    // Método simulado para medir el tiempo
    private static void simulateMethod() {
        try {
            // Simulamos una operación que toma tiempo
            Thread.sleep(500); // Duerme 500ms para simular trabajo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
