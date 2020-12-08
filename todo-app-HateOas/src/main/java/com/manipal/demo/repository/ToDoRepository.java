package com.manipal.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manipal.demo.beans.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
	
	List<ToDo> findByUserName(String userName);

	@Query("SELECT t FROM ToDo t where t.isCompleted=true")
	List<ToDo> findByAllCompletedToDos();
	

}
