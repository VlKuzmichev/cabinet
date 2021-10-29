package rzd.oao.zrw.nssite.cabinet.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rzd.oao.zrw.nssite.cabinet.model.Todo;
import rzd.oao.zrw.nssite.cabinet.service.TodoService;

import java.util.List;

@RestController
@RequestMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    //@CrossOrigin(origins = "http://localhost:8080")
    public List<Todo> todos() {
        return todoService.getAll();
//        return null;
    }
}
