package spring.configuration;

import integration.EntregaIntegration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositories.FreteRepository;
import repositories.PedidoRepository;
import services.PedidoService;

@Configuration
public class PedidoServiceConfig {
    @Bean
    public PedidoService pedidoService(PedidoRepository pedidoRepository, EntregaIntegration entregaIntegration,
                                       FreteRepository freteRepository)  {
        return new PedidoService(pedidoRepository, entregaIntegration, freteRepository);
    }
}
