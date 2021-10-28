package rzd.oao.zrw.nssite.cabinet.model;

import javax.persistence.*;

@Entity
@Table(name = "sub_todos")
public class SubTodo extends AbstractNamedEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    public SubTodo() {
    }

    public SubTodo(Integer id, String name, Todo todo) {
        super(id, name);
        this.todo = todo;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }
}
