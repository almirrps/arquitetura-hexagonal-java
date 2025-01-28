package com.santos.hexagonal.config;

import com.santos.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.santos.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.santos.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    //*obs.: A classe FindCustomerByIdAdapter é a implementação da porta de saída (InputPort)
    //e por isso deveremos utilizar diretamente o FindCustomerByIdUseCase

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                               DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }

}
