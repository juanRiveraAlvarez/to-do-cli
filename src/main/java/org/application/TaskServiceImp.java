package org.application;

import java.util.ArrayList;

import org.domain.model.Task;

import org.domain.repository.PersistenceInterface;

public class TaskServiceImp implements TaskService{

  private PersistenceInterface<Task> persistenceInterface;

  public TaskServiceImp(PersistenceInterface<Task> persistenceInterface){
    this.persistenceInterface  = persistenceInterface;
  }

  public Task addTask(String t){
    return this.persistenceInterface.save(t);
  }

  public Task deleteTask(long id){
    Task task = this.persistenceInterface.getById(id);
    this.persistenceInterface.deleteById(id);
    return task;
  }

  public ArrayList<Task> printTasks(){
    return this.persistenceInterface.getAll();
  }

}
