package com.manipal.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.manipal.demo.beans.ToDo;

@Repository
public interface ToDoRepository extends MongoRepository<ToDo, Integer> {
	
	List<ToDo> findByUserName(String userName);
	
    @Query("{'isCompleted':true}")
	List<ToDo> findByAllCompletedToDos();
	

}
