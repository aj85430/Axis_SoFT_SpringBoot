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
