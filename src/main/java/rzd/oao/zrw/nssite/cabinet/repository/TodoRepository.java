package rzd.oao.zrw.nssite.cabinet.repository;

import rzd.oao.zrw.nssite.cabinet.model.Todo;

import java.util.List;

public interface TodoRepository {
    Todo save(Todo todo);

    // false if not found
    boolean delete(int id);

    // null if not found
    Todo get(int id);

    List<Todo> getAll();

    // null if not found
    Todo getByName(String name);
}
