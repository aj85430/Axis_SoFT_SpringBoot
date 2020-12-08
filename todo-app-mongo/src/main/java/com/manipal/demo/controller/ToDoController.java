package com.manipal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.demo.beans.ToDo;
import com.manipal.demo.service.ToDoService;

@RestController
public class ToDoController {
	
	@Autowired
	ToDoService todoService;

	@GetMapping("/todos")
	public List<ToDo> retriveTodos() 
	{
		return  todoService.getAllTodos();
	}
	
	@GetMapping("/todos/{id}")
	public ToDo retrieveByIdTodo(@PathVariable Integer id){			
		return todoService.getTodo(id);
	}
	
	
	@PutMapping("/todos/{id}")
	public ResponseEntity<ToDo> updateTodo(@PathVariable int id, @RequestBody ToDo toDoDetails) {
		
		ToDo todo= todoService.getTodo(id);
		todo.setUserName(toDoDetails.getUserName());
		todo.setDescription(toDoDetails.getDescription());
		todo.setEndDate(toDoDetails.getEndDate());
		todo.setCompleted(toDoDetails.isCompleted());
		
		
		ToDo todoUpdated= todoService.addOrUpdateToDo(todo);
		
		
		return  ResponseEntity.ok(todoUpdated);
	} 
	
	
	
	@DeleteMapping("/todos/{id}")
	public String deleteToDo(@PathVariable int id) {
		
		ToDo todo= todoService.getTodo(id);
		todoService.deleteToDo(id);
        return 	"Deleted!";	
	}
	
	@PostMapping("/todos")
	public ResponseEntity<ToDo> addNewTodo(@RequestBody ToDo toDo) {
		
		ToDo todo= todoService.addToDo(toDo);
		HttpHeaders headers = new HttpHeaders();
		headers.add("response-form", "ToDoController");
		//return ResponseEntity.accepted().headers(headers).body(todo);
		
		return new ResponseEntity(todo,headers,HttpStatus.OK);
	}
	
	@GetMapping("/users/{userName}/todos")
	public List<ToDo> retriveTodos(@PathVariable String userName) {
		return todoService.getAllToDoByUserName(userName);
	}
	
	@GetMapping("/todos/completed")
	public List<ToDo> getAllCompletedTodos() {
		return todoService.getAllCompletedToDo();
	}
	
	
	/*@GetMapping("/todos/users/{userName}")
	public List<ToDo> retriveTodos(@PathVariable String userName) {
		return todoService.displayToDos(userName);
	}
	
	@GetMapping("/todos")
	public List<ToDo> displayAllTodos() {
		return todoService.displayAllToDos();
	}
	
	@PostMapping("/todos")
	public ToDo addNewTodo(@RequestBody ToDo toDo) {
		return todoService.addToDo(toDo);
	}*/
	
	
	
	
	
	
}
