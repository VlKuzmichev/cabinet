package rzd.oao.zrw.nssite.cabinet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import rzd.oao.zrw.nssite.cabinet.model.Todo;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TodoRepositoryImpl implements TodoRepository{
  //  private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");
    private final CrudTodoRepository repository;

    public TodoRepositoryImpl(CrudTodoRepository repository){
        this.repository = repository;
    }

    @Override
    public Todo save(Todo user) {
        return repository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Todo get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Todo> getAll() {
        return repository.findAll(/*SORT_NAME*/);
    }

    @Override
    public Page<Todo> getTodosByDate(Pageable pageable, LocalDateTime dateTime) {
        return repository.findAllTodosByDate(pageable, dateTime);
    }

    @Override
    public Todo getByName(String name) {
        return repository.getByName(name);
    }
}
