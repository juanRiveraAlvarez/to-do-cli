package org;

import org.application.TaskServiceImp;

import org.infraestructure.adapters.JsonUtilsAdapter;

import org.domain.repository.TaskRepository;
import org.domain.model.Task;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
  public static void main(String[] args) {

    ObjectMapper objectMapper = new ObjectMapper();
    JsonUtilsAdapter jsonUtilsAdapter = new JsonUtilsAdapter<Task>(objectMapper);
    TaskRepository taskRepository = new TaskRepository(jsonUtilsAdapter);
    TaskServiceImp taskServiceImp = new TaskServiceImp(taskRepository);

    if (args.length == 2) {

      if (args[0].equals("add")) {

        taskServiceImp.addTask(args[1]);

      } else if (args[0].equals("rm")) {

        taskServiceImp.deleteTask(Long.parseLong(args[1]));

      }

    }
    for (Task t : taskServiceImp.printTasks()) {
      System.out.println(t.getId() + " -- " + t.getTitle());
    }

  }
}
