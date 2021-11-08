package rzd.oao.zrw.nssite.cabinet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import rzd.oao.zrw.nssite.cabinet.AuthorizedUser;
import rzd.oao.zrw.nssite.cabinet.model.NotFoundException;
import rzd.oao.zrw.nssite.cabinet.model.User;
import rzd.oao.zrw.nssite.cabinet.repository.UserRepository;

import java.util.List;


//@Transactional(readOnly = true) если будет необходимо
@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
//    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final PasswordEncoder passwordEncoder;

    private UserRepository repository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    @Override
//    @Transactional(isolation = Isolation.READ_COMMITTED) По умолчанию
    @Transactional
    public User create(User user) {
        return null;
    }

    @Transactional
    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public User get(int id) throws NotFoundException {
        logger.info("Get User with Id: {}", id);
        logger.trace("Method 1 started with argument={}", id);
        logger.debug("Database updated with script = {}", id);
        logger.info("Application has started on port = {}", id);
        logger.warn("Log4j didn't find log4j.properties. Please, provide them");
        logger.error("Connection refused to host = {}", id);
        return repository.get(id);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
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
