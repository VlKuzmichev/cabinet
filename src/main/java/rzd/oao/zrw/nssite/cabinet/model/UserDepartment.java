package rzd.oao.zrw.nssite.cabinet.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_departments", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "user_departments_unique_name_idx")})
public class UserDepartment extends AbstractNamedEntity{
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<User> users;

    public UserDepartment() {
    }

    public UserDepartment(Integer id, String name, List<User> users) {
        super(id, name);
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
