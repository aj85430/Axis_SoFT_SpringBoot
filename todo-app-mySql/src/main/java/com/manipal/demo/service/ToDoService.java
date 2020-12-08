package com.manipal.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.demo.beans.ToDo;
import com.manipal.demo.exception.ToDoNotFoundException;
import com.manipal.demo.repository.ToDoRepository;

@Service
public class ToDoService {
	
	@Autowired
	private ToDoRepository toDoRepository;
	/*private static List<ToDo> todos = new ArrayList<>();
	
	static {
		ToDo todo1= new ToDo(11,"Aman","Learning Spring Boot",LocalDate.now(), false);
		ToDo todo2= new ToDo(12,"Gourav","Learning Spring Boot",LocalDate.now(), false);
		ToDo todo3= new ToDo(13,"Aman","Learning Kotlin",LocalDate.now(), false);
		ToDo todo4= new ToDo(14,"Gourav","Learning Java",LocalDate.now(), false);
		ToDo todo5= new ToDo(15,"Shruti","Learning Spring Boot",LocalDate.now(), true);
		
		
		todos.add(todo1);
		todos.add(todo2);
		todos.add(todo3);
		todos.add(todo4);
		todos.add(todo5);
		
	}
	*/
	/*public List<ToDo> displayToDos(String userName){
		List<ToDo> userToDoList= new ArrayList<>();
		
		for(ToDo todo: todos)
		{
			if(todo.getUserName().equals(userName)) {
				userToDoList.add(todo);
			}			
		}
		return userToDoList;
	}
	
	public List<ToDo> displayAllToDos(){
		List<ToDo> allToDoList= new ArrayList<>();
		
		for(ToDo todo: todos)
		{
			
				allToDoList.add(todo);
				
		}
		return allToDoList;
	}*/
	
/*public ToDo addToDo(ToDo todo){
		/*todos.add(todo);
		return todo;
	} */
	
	
	
	public List<ToDo> getAllTodos(){
		return toDoRepository.findAll();
	}
	
	public ToDo getTodo(Integer id){
		return toDoRepository.findById(id).orElseThrow(()->new ToDoNotFoundException("ToDo details not found for id "+ id));
	}
	
	public ToDo addToDo(ToDo todo){
		
		return toDoRepository.save(todo);
	}
	
	public void deleteToDo(int id) {
		toDoRepository.deleteById(id);
	}
	
	public ToDo addOrUpdateToDo(ToDo todo)
	{
		return toDoRepository.save(todo);
	}
	
	public List<ToDo> getAllToDoByUserName(String userName)
	{
		return toDoRepository.findByUserName(userName);
	}
	
	public List<ToDo> getAllCompletedToDo()
	{
		return toDoRepository.findByAllCompletedToDos();
	}
	
	
	

}
