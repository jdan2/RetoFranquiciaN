package com.pragma.franquicias.infrastructure.configuration;

import com.pragma.franquicias.domain.api.IFranquiciaServicePort;
import com.pragma.franquicias.domain.spi.IFranquiciaPersistencePort;
import com.pragma.franquicias.domain.usecase.FranquiciaUseCase;
import com.pragma.franquicias.infrastructure.out.jpa.adapter.FranquiciaJpaAdapter;
import com.pragma.franquicias.infrastructure.out.jpa.mapper.IFranquiciaEntityMapper;
import com.pragma.franquicias.infrastructure.out.jpa.repository.IFranquiciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IFranquiciaRepository franquiciaRepository;
    private final IFranquiciaEntityMapper franquiciaEntityMapper;

    @Bean
    public IFranquiciaPersistencePort franquiciaPersistencePort() {
        return new FranquiciaJpaAdapter(franquiciaRepository, franquiciaEntityMapper);
    }

    @Bean
    public IFranquiciaServicePort franquiciaServicePort() {
        return new FranquiciaUseCase(franquiciaPersistencePort());
    }
}