package rzd.oao.zrw.nssite.cabinet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rzd.oao.zrw.nssite.cabinet.model.NotFoundException;
import rzd.oao.zrw.nssite.cabinet.model.Todo;

import java.time.LocalDateTime;

public interface TodoService {
    Todo create(Todo todo);

    void delete(int id) throws NotFoundException;

    Todo get(int id) throws NotFoundException;

    Todo complete(int id, boolean checked) throws NotFoundException;

    void update(Todo todo);

    Page<Todo> getAll(Pageable pageable, boolean checked);

    Page<Todo> getTodosByDate(Pageable pageable, boolean checked, LocalDateTime dateTime);

}
