package com.manipal.demo.exception;

public class ToDoNotFoundException extends RuntimeException {

public ToDoNotFoundException() {}
    

    public ToDoNotFoundException( String message) {
        super(message);
        
    }
	
	

}
