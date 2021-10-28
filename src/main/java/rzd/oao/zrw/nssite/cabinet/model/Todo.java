package rzd.oao.zrw.nssite.cabinet.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "todos")
public class Todo extends AbstractNamedEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "todo")
    private List<SubTodo> subTodos;

    public Todo() {
    }

    public Todo(Integer id, String name, User user) {
        super(id, name);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
