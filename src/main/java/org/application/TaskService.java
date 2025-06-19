package org.application;

import java.util.List;

import org.domain.model.Task;

public interface TaskService{

  Task addTask(String t);
  Task deleteTask(long id);
  List<Task> printTasks();

}
