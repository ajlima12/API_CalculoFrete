package spring.repositories.orm;

import entities.PedidoStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public record PedidoOrm(
        @Id
        String id,
        @Indexed
        String clienteId,
        String clienteNome,
        String clienteEmail,
        String clienteEndereco,
        String clienteEstado,
        PedidoStatus status
) {
}
