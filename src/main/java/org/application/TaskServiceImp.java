package org.application;

import java.util.ArrayList;

import org.domain.model.Task;

import org.domain.repository.PersistenceInterface;

public class TaskServiceImp implements TaskService{

  private PersistenceInterface<Task> persistenceInterface;

  public TaskServiceImp(PersistenceInterface<Task> persistenceInterface){
    this.persistenceInterface  = persistenceInterface;
  }

  public Task addTask(Task t){
    System.out.println(t.getClass());
    return this.persistenceInterface.save(t);
  }

  public Task deleteTask(long id){
    return new Task();
  }

  public ArrayList<Task> printTasks(){
    return new ArrayList<Task>();
  }

}
