package rzd.oao.zrw.nssite.cabinet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rzd.oao.zrw.nssite.cabinet.model.Todo;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository {
    Todo save(Todo todo);

    // false if not found
    boolean delete(int id);

    // null if not found
    Todo get(int id);

    Page<Todo> getAll(Pageable pageable, boolean checked);

    Page<Todo> getTodosByDate(Pageable pageable, boolean checked, LocalDateTime dateTime);

    // null if not found
    Todo getByName(String name);
}
