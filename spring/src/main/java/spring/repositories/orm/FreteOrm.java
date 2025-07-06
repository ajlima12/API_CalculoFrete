package spring.repositories.orm;

import org.springframework.data.annotation.Id;

public record FreteOrm(
        @Id
        String id,
        PedidoOrm pedido,
        Double frete
) {
}
