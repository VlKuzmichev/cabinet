package rzd.oao.zrw.nssite.cabinet.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER_ROLE,
    ADMIN_ROLE,
    DISPATCHER_ROLE,
    PUBLISHER_ROLE;

    @Override
    public String getAuthority() {
        return name();
    }
}
