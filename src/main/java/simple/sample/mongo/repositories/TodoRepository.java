package simple.sample.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import simple.sample.mongo.models.TodoDocument;

import java.util.List;

@Repository
// https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongodb.repositories.queries
public interface TodoRepository extends MongoRepository<TodoDocument, String> {

    List<TodoDocument> findByDescriptionLike(String description);
}
