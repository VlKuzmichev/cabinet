package rzd.oao.zrw.nssite.cabinet.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rzd.oao.zrw.nssite.cabinet.model.Todo;

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

    @Override
    List<Todo> findAll(Sort sort);

    Todo getByName(String name);
}
