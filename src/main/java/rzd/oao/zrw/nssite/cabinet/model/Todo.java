package rzd.oao.zrw.nssite.cabinet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "todos")
public class Todo extends AbstractNamedEntity {
    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "todo")
    @JsonIgnore
    private List<SubTodo> subTodos;

    public Todo() {
    }

//    public Todo(LocalDateTime dateTime, LocalDateTime endDate, String description, User user) {
//        this.dateTime = dateTime;
//        this.endDate = endDate;
//        this.description = description;
//        this.user = user;
//    }

    public Todo(Integer id, String name, LocalDateTime dateTime, LocalDateTime endDate, String description, User user) {
        super(id, name);
        this.dateTime = dateTime;
        this.endDate = endDate;
        this.description = description;
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SubTodo> getSubTodos() {
        return subTodos;
    }

    public void setSubTodos(List<SubTodo> subTodos) {
        this.subTodos = subTodos;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateTime=" + dateTime +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }
}
