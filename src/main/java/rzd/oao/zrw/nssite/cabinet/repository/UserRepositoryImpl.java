package rzd.oao.zrw.nssite.cabinet.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import rzd.oao.zrw.nssite.cabinet.model.User;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");
    private final CrudUserRepository repository;

    public UserRepositoryImpl(CrudUserRepository repository){
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll(SORT_NAME);
    }

    @Override
    public User getByName(String name) {
        return repository.getByUserName(name);
    }
}
