package rzd.oao.zrw.nssite.cabinet.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rzd.oao.zrw.nssite.cabinet.AuthorizedUser;
import rzd.oao.zrw.nssite.cabinet.model.NotFoundException;
import rzd.oao.zrw.nssite.cabinet.model.Todo;
import rzd.oao.zrw.nssite.cabinet.service.TodoService;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public Todo get(@PathVariable int id) throws NotFoundException {
        return todoService.get(id);
    }

    @PostMapping("/{pageNumber}/{pageSize}")
    public Page<Todo> getTodosByDatePage(@PathVariable("pageNumber") final Integer pageNumber, @PathVariable("pageSize") final Integer pageSize,
                                         @RequestBody @DateTimeFormat(pattern="yyyy-MM-dd") String date) {
        date = date.replace("%3A", ":").replace("Z=", "0");
        Pageable pageOfTodos = PageRequest.of(pageNumber, pageSize);
        Page<Todo> pages = todoService.getTodosByDate(pageOfTodos, LocalDateTime.parse(date));
        return pages;
    }
    @GetMapping()
    //@CrossOrigin(origins = "http://localhost:8080")
    public List<Todo> todos() {
        return todoService.getAll();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Todo todo, @PathVariable int id) {
        // Id проверить в сервисе AssureIdConsist
        todoService.update(todo);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todo> createWithLocation(@RequestBody Todo todo) {
        Todo created = todoService.create(todo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/todo/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) throws NotFoundException {
        todoService.delete(id);
    }
}
