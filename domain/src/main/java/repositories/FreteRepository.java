package repositories;

import entities.Frete;

import java.util.List;
import java.util.Optional;

public interface FreteRepository {
    Frete save(Frete frete);
    Optional<Frete> findById(String id);
    void deleteById(String id);
    List<Frete> findByClienteId(String clienteId);
}
