package com.proyectogestion.gestiondepagos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class confCORS {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
    //permite que las cookies y las credenciales de autentificación sean validas
        config.setAllowCredentials(true);
        //permite el acceso desde tu frontend
        config.addAllowedOrigin("http://localhost:3000"); // Cambia este puerto
        //permiten todos los encabezados y metodos HTTP
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
