package rzd.oao.zrw.nssite.cabinet.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import rzd.oao.zrw.nssite.cabinet.model.NotFoundException;
import rzd.oao.zrw.nssite.cabinet.model.User;

public interface UserService extends UserDetailsService {
    public User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

//    void update(User user, int id);

    void update(User user);

//    List<User> getAll();

//    List<User> getAllByDepartment(int departmentId);

//    User getWithDepartment(int id) throws NotFoundException;

//    void enable(int id, boolean enable);

//    void changePassword(User user, String password);

//    boolean checkIfValidOldPassword(User user, String oldPassword);

}
