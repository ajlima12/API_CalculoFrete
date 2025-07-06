package spring.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record CriarPedidoRequest(
        @NotNull(message = "O ID do cliente é obrigatório")
        String clienteId,
        @NotBlank(message = "O nome do cliente é obrigatório")
        String clienteNome,
        @NotBlank(message = "O email do cliente é obrigatório")
        String clienteEmail,
        @NotBlank(message = "O endereço do cliente é obrigatório")
        String clienteEndereco,
        @NotBlank(message = "O estado do cliente é obrigatório")
        String clienteEstado
) {
}
