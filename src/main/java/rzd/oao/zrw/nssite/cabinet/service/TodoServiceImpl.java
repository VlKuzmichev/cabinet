package rzd.oao.zrw.nssite.cabinet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import rzd.oao.zrw.nssite.cabinet.model.NotFoundException;
import rzd.oao.zrw.nssite.cabinet.model.Todo;
import rzd.oao.zrw.nssite.cabinet.model.User;
import rzd.oao.zrw.nssite.cabinet.repository.TodoRepository;
import rzd.oao.zrw.nssite.cabinet.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;


//@Transactional(readOnly = true) если будет необходимо
@Service("todoService")
public class TodoServiceImpl implements TodoService {
    private static final Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);

    private TodoRepository repository;
    private UserRepository userRepository;

    public TodoServiceImpl(TodoRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
//    @Transactional(isolation = Isolation.READ_COMMITTED) По умолчанию
    @Transactional
    public Todo create(Todo todo) {
        logger.debug("Create todo: {}", todo);
        Assert.notNull(todo, "todo must not be null");
        // Get username from spring security and get by name from repo
        User addUser = userRepository.getByName(SecurityContextHolder.getContext().getAuthentication().getName());
        todo.setUser(addUser);
        return repository.save(todo);
    }

    @Transactional
    @Override
    public void delete(int id) throws NotFoundException {
        logger.debug("Delete todo with Id: {}", id);
        repository.delete(id);
    }

    @Override
    public Todo get(int id) throws NotFoundException {
        logger.debug("Get todo with Id: {}", id);
        return repository.get(id);
    }

    @Override
    public void update(Todo todo) {
        logger.info("Update todo: {}", todo);
        Todo updatedTodo = todo;
        repository.save(todo);
    }

    @Override
    public List<Todo> getAll() {
        logger.debug("Get all todos");
        return repository.getAll();
    }

}
