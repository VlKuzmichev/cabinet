package rzd.oao.zrw.nssite.cabinet;

import rzd.oao.zrw.nssite.cabinet.model.User;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    //private User user;

    public AuthorizedUser(User user) {
        super(user.getUserName(), user.getPassword(), user.getRoles());
    }


//    private UserTo userTo;
//
//    public AuthorizedUser(User user) {
//        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
//        this.userTo = UserUtil.asTo(user);
//    }
//
//    public int getId() {
//        return userTo.getId();
//    }
//
//    public void update(UserTo newTo) {
//        userTo = newTo;
//    }
//
//    public UserTo getUserTo() {
//        return userTo;
//    }
//
//    @Override
//    public String toString() {
//        return userTo.toString();
//    }
}
