package br.com.ada.programacaowebIsblocatecar.config;

import br.com.ada.programacaowebIsblocatecar.model.Cliente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PWIConfiguration {
    
    @Bean
    public Cliente getCLiente() {
        return new Cliente();
    }
}
