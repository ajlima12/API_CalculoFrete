package entities;

public record Pedido (
        String id,
        PedidoStatus status,
        String clienteId,
        String clienteNome,
        String clienteEmail,
        String clienteEndereco,
        String clienteEstado
)
{ }
