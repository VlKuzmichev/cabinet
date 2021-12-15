package rzd.oao.zrw.nssite.cabinet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rzd.oao.zrw.nssite.cabinet.model.NotFoundException;
import rzd.oao.zrw.nssite.cabinet.model.Todo;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoService {
    public Todo create(Todo todo);

    void delete(int id) throws NotFoundException;

    Todo get(int id) throws NotFoundException;

    void update(Todo todo);

    List<Todo> getAll();

    Page<Todo> getTodosByDate(Pageable pageable, LocalDateTime dateTime);

}
