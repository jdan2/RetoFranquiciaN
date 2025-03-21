package com.example.franquicia.application.config;

import com.example.franquicia.domain.api.IFranquiciaServicePort;
import com.example.franquicia.domain.api.IProductoServicePort;
import com.example.franquicia.domain.api.ISucursalServicePort;
import com.example.franquicia.domain.spi.IFranquiciaPersistencePort;
import com.example.franquicia.domain.spi.IProductoPersistencePort;
import com.example.franquicia.domain.spi.ISucursalPersistencePort;
import com.example.franquicia.domain.usecase.FranquiciaUseCase;
import com.example.franquicia.domain.usecase.ProductoUseCase;
import com.example.franquicia.domain.usecase.SucursalUseCase;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.FranquiciaPersistenceAdapter;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.ProductoPersistenceAdapter;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.SucursalPersistenceAdapter;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.mapper.FranquiciaEntityMapper;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.mapper.ProductoEntityMapper;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.mapper.SucursalEntityMapper;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.repository.IFranquiciaRepository;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.repository.IProductoRepository;
import com.example.franquicia.infrastructure.adapters.persistenceadapter.repository.ISucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UseCasesConfig {

        private final IFranquiciaRepository franquiciaRepository;
        private final FranquiciaEntityMapper franquiciaEntityMapper;

        private final ISucursalRepository sucursalRepository;
        private final SucursalEntityMapper sucursalEntityMapper;

        private final IProductoRepository productoRepository;
        private final ProductoEntityMapper productoEntityMapper;

        @Bean
        public IFranquiciaPersistencePort franquiciaPersistencePort() {
                return new FranquiciaPersistenceAdapter(franquiciaRepository, franquiciaEntityMapper);
        }

        @Bean
        public IFranquiciaServicePort franquiciaServicePort() {
                return new FranquiciaUseCase(franquiciaPersistencePort());
        }

        @Bean
        public ISucursalPersistencePort sucursalPersistencePort() {
                return new SucursalPersistenceAdapter(sucursalRepository, sucursalEntityMapper);
        }

        @Bean
        public ISucursalServicePort sucursalServicePort() {
                return new SucursalUseCase(sucursalPersistencePort());
        }

        @Bean
        public IProductoPersistencePort productoPersistencePort() {
                return new ProductoPersistenceAdapter(productoRepository, productoEntityMapper);
        }

        @Bean
        public IProductoServicePort productoServicePort() {
                return new ProductoUseCase(productoPersistencePort(), sucursalPersistencePort());
        }
}
