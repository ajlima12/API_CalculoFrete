package entities;

import java.math.BigDecimal;

public record Frete(
        String id,
        Pedido pedido,
        BigDecimal frete
){
}
