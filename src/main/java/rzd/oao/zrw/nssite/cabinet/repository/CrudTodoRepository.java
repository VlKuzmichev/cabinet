package rzd.oao.zrw.nssite.cabinet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rzd.oao.zrw.nssite.cabinet.model.Todo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CrudTodoRepository extends JpaRepository<Todo, Integer> {
    @Modifying
    @Query("DELETE FROM Todo t WHERE t.id=:id")
    int delete(@Param("id") int id);

    @Override
    Todo save(Todo todo);

    @Override
    Optional<Todo> findById(Integer id);

    @Query(value = "select * from todos where checked = :checked ORDER BY date_time", nativeQuery = true)
    Page<Todo> findAllTodos(Pageable pageable, boolean checked);

    @Query(value = "select * from todos where date_time = :dateTime AND checked = :checked", nativeQuery = true)
    Page<Todo> findAllTodosByDate(Pageable pageable, boolean checked, LocalDateTime dateTime);

    Todo getByName(String name);
}
