package rzd.oao.zrw.nssite.cabinet.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rzd.oao.zrw.nssite.cabinet.model.NotFoundException;
import rzd.oao.zrw.nssite.cabinet.model.Todo;
import rzd.oao.zrw.nssite.cabinet.service.TodoService;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{id}/completed/{completed}")
    public Todo complete(@PathVariable int id, @PathVariable boolean completed) throws NotFoundException {
//        boolean cmpl = completed;
//        System.out.println("comp");
        return todoService.complete(id, completed);
    }

    @GetMapping("/{id}")
    public Todo get(@PathVariable int id) throws NotFoundException {
//        System.out.println("get");
        return todoService.get(id);
    }

    @PostMapping("/{pageNumber}/{pageSize}/{checked}")
    public Page<Todo> getTodosByDatePage(@PathVariable("pageNumber") final Integer pageNumber, @PathVariable("pageSize") final Integer pageSize,
                                         @PathVariable("checked") final boolean checked, @RequestBody String date) {
        date = date.replace("%3A", ":").replace("Z=", "0");
        Pageable pageOfTodos = PageRequest.of(pageNumber, pageSize, Sort.by("id").ascending());
        Page<Todo> pages = todoService.getTodosByDate(pageOfTodos, checked, LocalDateTime.parse(date));
        return pages;
    }

    @GetMapping("/{pageNumber}/{pageSize}/{checked}")
    //@CrossOrigin(origins = "http://localhost:8080")
    public Page<Todo> todos(@PathVariable("pageNumber") final Integer pageNumber, @PathVariable("pageSize") final Integer pageSize,
                            @PathVariable("checked") final boolean checked) {
        Pageable pageOfTodos = PageRequest.of(pageNumber, pageSize, Sort.by("id").ascending());
        Page<Todo> pages = todoService.getAll(pageOfTodos, checked);
        return pages;
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
