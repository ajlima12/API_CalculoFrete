package services;

import entities.Frete;
import entities.Pedido;
import integration.EntregaIntegration;
import repositories.FreteRepository;
import repositories.PedidoRepository;

import java.math.BigDecimal;
import java.util.List;

public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final FreteRepository freteRepository;
    private final EntregaIntegration entregaIntegration;

    public PedidoService(PedidoRepository pedidoRepository,
                         EntregaIntegration entregaIntegration,
                         FreteRepository freteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.freteRepository = freteRepository;
        this.entregaIntegration = entregaIntegration;
    }

    public Frete criarPedido(Pedido pedido) {

        BigDecimal precoFrete = entregaIntegration.calcularFrete(pedido.clienteEstado());



        pedidoRepository.save(pedido);

        Frete frete = new Frete(
                pedido.id(),
                pedido,
                precoFrete
        );

        freteRepository.save(frete);

        return frete;
    }

    public List<Frete> consultarPedidosPorClienteId(String clienteId) {
        return freteRepository.findByClienteId(clienteId)
                .stream()
                .map(frete -> new Frete(
                        frete.id(),
                        frete.pedido(),
                        frete.frete()
                ))
                .toList();
    }
}
