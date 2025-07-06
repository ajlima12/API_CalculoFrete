package spring.repositories.client;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.repositories.orm.PedidoOrm;

import java.util.List;

public interface PedidoRepositoryWithMongo extends MongoRepository<PedidoOrm, String> {

}
