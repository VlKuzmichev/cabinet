package rzd.oao.zrw.nssite.cabinet.service;

import rzd.oao.zrw.nssite.cabinet.model.NotFoundException;
import rzd.oao.zrw.nssite.cabinet.model.Todo;

import java.util.List;

public interface TodoService {
    public Todo create(Todo todo);

    void delete(int id) throws NotFoundException;

    Todo get(int id) throws NotFoundException;

    void update(Todo todo);

    List<Todo> getAll();

}
