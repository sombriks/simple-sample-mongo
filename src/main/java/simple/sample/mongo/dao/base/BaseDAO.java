package simple.sample.mongo.dao.base;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Component
public class BaseDAO {

    private final MongoTemplate template;

    public BaseDAO(MongoTemplate template) {
        this.template = template;
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return template.getDb().getCollection(collectionName);
    }

    public Long count(String collectionName, Bson filter) {
        return getCollection(collectionName)
                .countDocuments(filter);
    }

    public Document findOne(String collectionName, Bson filter) {
        return getCollection(collectionName)
                .find(filter)
                .first();

    }

    public List<Document> find(String collectionName, Bson filter, Bson sorting, int limit, int offset) {
        List<Document> results = new ArrayList<>();
        getCollection(collectionName)
                .find(filter)
                .sort(sorting)
                .limit(limit)
                .skip(offset)
                .forEach(results::add);
        return results;
    }

    public BsonValue insert(String collectionName, Document toSave) {
        InsertOneResult result = getCollection(collectionName)
                .insertOne(toSave);
        return result.getInsertedId();
    }

    public long update(String collectionName, String id, Document toSave) {
        UpdateResult result = getCollection(collectionName)
                .replaceOne(eq("_id", new ObjectId(id)), toSave);
        return result.getModifiedCount();
    }
}
