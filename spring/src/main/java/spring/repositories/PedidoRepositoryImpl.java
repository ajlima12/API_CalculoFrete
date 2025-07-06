package spring.repositories;

import entities.Pedido;
import org.springframework.stereotype.Repository;
import repositories.PedidoRepository;
import spring.repositories.adapters.EntregaRepositoryAdapter;
import spring.repositories.client.PedidoRepositoryWithMongo;
import spring.repositories.orm.PedidoOrm;

import java.util.Optional;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {
    private final PedidoRepositoryWithMongo pedidoRepository;
    public PedidoRepositoryImpl(PedidoRepositoryWithMongo pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    @Override
    public Pedido save(Pedido pedido) {
        PedidoOrm pedidoOrm = EntregaRepositoryAdapter.cast(pedido);
        PedidoOrm savedPedidoOrm = pedidoRepository.save(pedidoOrm);
        return EntregaRepositoryAdapter.cast(savedPedidoOrm);
    }

    @Override
    public Optional<Pedido> findById(String id) {
        return pedidoRepository.findById(id)
                .map(EntregaRepositoryAdapter::cast);
    }

    @Override
    public void deleteById(String id) {
        pedidoRepository.deleteById(id);
    }
}
