package repositories;

import entities.Pedido;

import java.util.Optional;

public interface PedidoRepository {
    Pedido save(Pedido pedido);
    Optional<Pedido> findById(String id);
    void deleteById(String id);
}
