package rzd.oao.zrw.nssite.cabinet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rzd.oao.zrw.nssite.cabinet.AuthorizedUser;
import rzd.oao.zrw.nssite.cabinet.model.NotFoundException;
import rzd.oao.zrw.nssite.cabinet.model.Todo;
import rzd.oao.zrw.nssite.cabinet.repository.TodoRepository;

import java.util.List;


//@Transactional(readOnly = true) если будет необходимо
@Service("todoService")
public class TodoServiceImpl implements TodoService {
    private static final Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);

    private TodoRepository repository;

    public TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
//    @Transactional(isolation = Isolation.READ_COMMITTED) По умолчанию
    @Transactional
    public Todo create(Todo todo) {
        logger.debug("Create todo: {}", todo);
        return null;
    }

    @Transactional
    @Override
    public void delete(int id) throws NotFoundException {
        logger.debug("Delete todo with Id: {}", id);

    }

    @Override
    public Todo get(int id) throws NotFoundException {
        logger.debug("Get todo with Id: {}", id);
        return repository.get(id);
    }

    @Override
    public void update(Todo todo) {
        logger.debug("Update todo: {}", todo);

    }

    @Override
    public List<Todo> getAll() {
        logger.debug("Get all todos");
        return repository.getAll();
    }

}
