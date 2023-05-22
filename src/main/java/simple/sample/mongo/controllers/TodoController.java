package simple.sample.mongo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import simple.sample.mongo.dao.TodoDAO;
import simple.sample.mongo.models.TodoDocument;
import simple.sample.mongo.repositories.TodoRepository;

import java.util.List;

@RestController
@RequestMapping("todos")
public class TodoController {

    private static final Logger LOG = LoggerFactory.getLogger(TodoController.class);

    private final TodoRepository repository;
    private final TodoDAO dao;

    public TodoController(TodoRepository repository, TodoDAO dao) {
        this.repository = repository;
        this.dao = dao;
    }

    @GetMapping
    public List<TodoDocument> list(
            @RequestParam(defaultValue = "") String description,
            @RequestParam(defaultValue = "false") Boolean useDAO) {
        if (useDAO) {
            LOG.info("using DAO to find TODO's");
            return dao.find(description);
        } else {
            LOG.info("using spring repository to find TODO's");
            return repository.findByDescriptionLike(description);
        }
    }

    @PostMapping
    public TodoDocument insert(@RequestBody TodoDocument doc) {
        return repository.save(doc);
    }
}
