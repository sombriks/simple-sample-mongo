package simple.sample.mongo.dao;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.stereotype.Component;
import simple.sample.mongo.dao.base.BaseDAO;
import simple.sample.mongo.models.TodoDocument;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoDAO {

    private final MappingMongoConverter converter;
    private final BaseDAO dao;

    public TodoDAO(MappingMongoConverter converter, BaseDAO dao) {
        this.converter = converter;
        this.dao = dao;
    }

    // see for more converters https://github.com/spring-projects/spring-data-examples/tree/main/mongodb/example/src/main/java/example/springdata/mongodb/converters
    public List<TodoDocument> find(String description) {
        return dao.find("todos",
                        Filters.regex("description", description),
                        Sorts.ascending("description"), 100, 0)
                .stream().map(doc -> converter.read(TodoDocument.class, doc))
                .collect(Collectors.toList());
    }

}
