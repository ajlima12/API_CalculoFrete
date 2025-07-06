package spring.repositories.client;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.repositories.orm.FreteOrm;
import spring.repositories.orm.PedidoOrm;

import java.util.List;

public interface FreteRepositoryWithMongo extends MongoRepository<FreteOrm, String> {
    List<FreteOrm> findByPedido_ClienteId(String id);
}
