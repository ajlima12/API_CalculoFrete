package spring.dtos.response;

import entities.PedidoStatus;

public record FreteDto(
        String id,
        PedidoStatus status,
        double frete
) {
}
