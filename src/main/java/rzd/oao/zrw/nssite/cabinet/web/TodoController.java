package rzd.oao.zrw.nssite.cabinet.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rzd.oao.zrw.nssite.cabinet.model.User;

import java.util.List;

@RestController
@RequestMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
public class TodoController {

    @GetMapping()
    //@CrossOrigin(origins = "http://localhost:8080")
    public List<User> users() {
        System.out.println("todos!!!!!");
        return null;
    }
}
