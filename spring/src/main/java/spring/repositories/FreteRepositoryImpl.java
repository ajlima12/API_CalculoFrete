package spring.repositories;

import entities.Frete;
import org.springframework.stereotype.Repository;
import repositories.FreteRepository;
import spring.repositories.adapters.EntregaRepositoryAdapter;
import spring.repositories.client.FreteRepositoryWithMongo;
import spring.repositories.orm.FreteOrm;

import java.util.List;
import java.util.Optional;

@Repository
public class FreteRepositoryImpl implements FreteRepository {
    private final FreteRepositoryWithMongo freteRepository;

    public FreteRepositoryImpl(FreteRepositoryWithMongo freteRepository) {
        this.freteRepository = freteRepository;
    }

    @Override
    public Frete save(Frete frete) {
        FreteOrm freteOrm = EntregaRepositoryAdapter.cast(frete);
        freteOrm = freteRepository.save(freteOrm);
        return EntregaRepositoryAdapter.cast(freteOrm);
    }

    @Override
    public Optional<Frete> findById(String id) {
        return freteRepository.findById(id)
                .map(EntregaRepositoryAdapter::cast);
    }

    @Override
    public void deleteById(String id) {
        freteRepository.deleteById(id);
    }

    @Override
    public List<Frete> findByClienteId(String clienteId) {
        return freteRepository.findByPedido_ClienteId(clienteId)
                .stream()
                .map(EntregaRepositoryAdapter::cast)
                .toList();
    }

}
