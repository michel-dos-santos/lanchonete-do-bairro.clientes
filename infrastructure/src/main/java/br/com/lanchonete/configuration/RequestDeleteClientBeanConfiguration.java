package br.com.lanchonete.configuration;

import br.com.lanchonete.port.repository.LogRepository;
import br.com.lanchonete.port.repository.RequestDeleteClientRepository;
import br.com.lanchonete.usecase.SaveRequestDeleteClientUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestDeleteClientBeanConfiguration {

    @Bean
    SaveRequestDeleteClientUsecase saveRequestDeleteClient(RequestDeleteClientRepository requestDeleteClientRepository, LogRepository logRepository) {
        return new SaveRequestDeleteClientUsecase(requestDeleteClientRepository, logRepository);
    }

}
