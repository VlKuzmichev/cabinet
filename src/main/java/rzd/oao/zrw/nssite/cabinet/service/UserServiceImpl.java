package rzd.oao.zrw.nssite.cabinet.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rzd.oao.zrw.nssite.cabinet.AuthorizedUser;
import rzd.oao.zrw.nssite.cabinet.model.NotFoundException;
import rzd.oao.zrw.nssite.cabinet.model.User;
import rzd.oao.zrw.nssite.cabinet.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    UserRepository repository;

    private UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository repository){
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public User get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public AuthorizedUser loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = repository.getByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("User " + name + " is not found");
        }
        return new AuthorizedUser(user);
    }
}
