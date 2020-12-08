package com.manipal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
	public CollectionModel retriveTodos() 
	{
		
		List<ToDo> todos= todoService.getAllTodos();
		
		WebMvcLinkBuilder linkbuilder= linkTo(methodOn(ToDoController.class).retriveTodos());
		
		CollectionModel collectionModel= CollectionModel.of(todos);
		
	    collectionModel.add(linkbuilder.withSelfRel());		
		
		return  collectionModel;
		
	}	
	
	@GetMapping("/todos/{id}")
	public EntityModel retrieveByIdTodo(@PathVariable Integer id){	
		
		
        ToDo todos= todoService.getTodo(id);
		
		WebMvcLinkBuilder linkbuilder= linkTo(methodOn(ToDoController.class).retriveTodos());
		WebMvcLinkBuilder linkbuilder1= linkTo(methodOn(ToDoController.class).retrieveByIdTodo(id));
		
		EntityModel entityModel= EntityModel.of(todos);
		
		entityModel.add(linkbuilder.withRel("all-todos"));		
		entityModel.add(linkbuilder1.withSelfRel());	
		
		return  entityModel;
		//return todoService.getTodo(id);
	}
	
	
	@GetMapping("/users/{userName}/todos")
	public CollectionModel retriveTodos(@PathVariable String userName) {
		
		List<ToDo> todos= todoService.getAllToDoByUserName(userName);
		WebMvcLinkBuilder linkbuilder= linkTo(methodOn(ToDoController.class).retriveTodos());
		CollectionModel collectionModel= CollectionModel.of(todos);
		collectionModel.add(linkbuilder.withSelfRel());	
		return collectionModel;
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
