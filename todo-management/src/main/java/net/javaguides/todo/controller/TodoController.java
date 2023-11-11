package net.javaguides.todo.controller;

import lombok.AllArgsConstructor;
import net.javaguides.todo.dto.TodoDto;
import net.javaguides.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    // build addTodo REST API
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){

        TodoDto savedTodoDto = todoService.addTodo(todoDto);

        return new ResponseEntity<>(savedTodoDto, HttpStatus.CREATED);
    }

    // build getTodo REST API
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId){

        TodoDto todoDto = todoService.getTodo(todoId);

        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    // build getAllTodos REST API
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){

        List<TodoDto> todoDtos = todoService.getAllTodos();

        // return new ResponseEntity<>(todoDtos, HttpStatus.OK);
        return ResponseEntity.ok(todoDtos);
    }

    // build updateTodo REST API
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long id){

        TodoDto updatedTodoDto = todoService.updateTodo(todoDto, id);

        return ResponseEntity.ok(updatedTodoDto);
    }

    // build deleteTodo REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){

        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("The Todo deleted successfully.");
    }

    // build completeTodo REST API
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId){

        TodoDto completedTodoDto = todoService.completeTodo(todoId);

        return ResponseEntity.ok(completedTodoDto);
    }

    // build incompleteTodo REST API
    @PatchMapping("{id}/incomplete")
    public ResponseEntity<TodoDto> incompleteTodo(@PathVariable("id") Long todoId){

        TodoDto incompletedTodoDto = todoService.incompleteTodo(todoId);

        return ResponseEntity.ok(incompletedTodoDto);
    }
}
