package webconfig;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.FilterRegistration;
import jakarta.servlet.annotation.HandlesTypes;

import java.util.Set;

@HandlesTypes(javax.servlet.Filter.class) // Esto indica que la clase inicializa filtros
public class WebConfigInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        // Registro del filtro CORS
        FilterRegistration.Dynamic corsFilter = ctx.addFilter("CorsFilter", new WebConfig());
        corsFilter.addMappingForUrlPatterns(null, false, "/*");  // Aplica para todas las rutas
    }
}
