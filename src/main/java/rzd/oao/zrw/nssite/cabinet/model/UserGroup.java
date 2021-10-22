package rzd.oao.zrw.nssite.cabinet.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_groups", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "user_groups_unique_name_idx")})
public class UserGroup extends AbstractNamedEntity{
}
