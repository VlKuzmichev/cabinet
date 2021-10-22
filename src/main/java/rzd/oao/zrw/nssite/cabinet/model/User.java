package rzd.oao.zrw.nssite.cabinet.model;

import org.springframework.ldap.odm.annotations.Entry;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "user_name", name = "users_unique_user_name_idx")})
public class User extends AbstractBaseEntity {

    String userName;
    String password;
    String email;
    String fullName;
    Boolean boss;
    UserGroup group;

    public User() {
    }

    public User(Integer id, String userName, String password, String email, String fullName, Boolean boss, UserGroup group) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.boss = boss;
        this.group = group;
    }
}
