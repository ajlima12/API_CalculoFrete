package spring.repositories.adapters;

import entities.Frete;
import entities.Pedido;
import spring.repositories.orm.FreteOrm;
import spring.repositories.orm.PedidoOrm;

import java.math.BigDecimal;

public class EntregaRepositoryAdapter {
    private EntregaRepositoryAdapter() {}

    public static Pedido cast(PedidoOrm pedidoOrm) {
        return new Pedido(
                pedidoOrm.id(),
                pedidoOrm.status(),
                pedidoOrm.clienteId(),
                pedidoOrm.clienteNome(),
                pedidoOrm.clienteEmail(),
                pedidoOrm.clienteEndereco(),
                pedidoOrm.clienteEstado()
        );
    }

    public static PedidoOrm cast(Pedido pedido) {
        return new PedidoOrm(
                pedido.id(),
                pedido.clienteId(),
                pedido.clienteNome(),
                pedido.clienteEmail(),
                pedido.clienteEndereco(),
                pedido.clienteEstado(),
                pedido.status()
        );
    }

    public static Frete cast(FreteOrm freteOrm) {
        return new Frete(
                freteOrm.id(),
                EntregaRepositoryAdapter.cast(freteOrm.pedido()),
                BigDecimal.valueOf(freteOrm.frete())
        );
    }

    public static FreteOrm cast(Frete frete) {
        return new FreteOrm(
                frete.id(),
                EntregaRepositoryAdapter.cast(frete.pedido()),
                frete.frete().doubleValue()
        );
    }
}
