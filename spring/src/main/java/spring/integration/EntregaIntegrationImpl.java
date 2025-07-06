package spring.integration;

import exceptions.EstadoNaoAceitoException;
import integration.EntregaIntegration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EntregaIntegrationImpl implements EntregaIntegration {
    public EntregaIntegrationImpl() {
    }


    @Override
    @Cacheable(value = "frete-preco-cache", key = "#estado")
    public BigDecimal calcularFrete(String estado) {
        return switch (estado) {
            case "SP", "PR" -> BigDecimal.valueOf(0.0);
            case "RJ", "SC", "RS" -> BigDecimal.valueOf(20.0);
            case "MG", "MT", "MS", "ES" -> BigDecimal.valueOf(50.0);
            default -> throw new EstadoNaoAceitoException("Estado não aceito", estado);
        };
    }
}
