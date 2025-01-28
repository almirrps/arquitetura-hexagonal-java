package com.santos.hexagonal.config;

import com.santos.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.santos.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.santos.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.santos.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    //*obs.: A classe FindCustomerByIdAdapter é a implementação da porta de saída (InputPort)
    //e por isso deveremos utilizar diretamente o FindCustomerByIdUseCase

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                       FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}
