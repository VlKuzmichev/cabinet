package rzd.oao.zrw.nssite.cabinet.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_groups", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "user_groups_unique_name_idx")})
public class UserGroup extends AbstractNamedEntity{
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private List<User> users;

    public UserGroup() {
    }

    public UserGroup(Integer id, String name, List<User> users) {
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
