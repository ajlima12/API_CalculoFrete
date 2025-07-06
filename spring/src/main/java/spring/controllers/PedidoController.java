package spring.controllers;

import entities.Pedido;
import spring.dtos.request.CriarPedidoRequest;
import spring.dtos.response.FreteDto;
import entities.Frete;
import entities.PedidoStatus;
import org.springframework.web.bind.annotation.*;
import services.PedidoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;
    public PedidoController(
            PedidoService pedidoService
    ) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/")
    public FreteDto criarPedido(@RequestBody() @Valid CriarPedidoRequest criarPedidoRequest) {


        Frete frete = pedidoService.criarPedido(
                new Pedido(
                        UUID.randomUUID().toString(),
                        PedidoStatus.PROCESSANDO,
                        criarPedidoRequest.clienteId(),
                        criarPedidoRequest.clienteNome(),
                        criarPedidoRequest.clienteEmail(),
                        criarPedidoRequest.clienteEndereco(),
                        criarPedidoRequest.clienteEstado()
                )
        );

        return new FreteDto(
                frete.id(),
                frete.pedido().status(),
                frete.frete().doubleValue()
        );
    }

    @GetMapping("/{clienteId}")
    public List<FreteDto> consultarPedidosPorClienteId(@PathVariable  String clienteId) {
        return pedidoService.consultarPedidosPorClienteId(clienteId)
                .stream()
                .map(frete -> new FreteDto(
                        frete.id(),
                        frete.pedido().status(),
                        frete.frete().doubleValue()
                ))
                .toList();
    }
}
