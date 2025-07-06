package exceptions;

public class EstadoNaoAceitoException extends RuntimeException {
    private final String estado;
    public EstadoNaoAceitoException(String message, String estado) {
        super(message);
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

}
