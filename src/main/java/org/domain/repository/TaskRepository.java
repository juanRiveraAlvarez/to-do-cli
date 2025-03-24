package org.domain.repository;

import org.domain.model.Task;
import org.infraestructure.adapters.JsonUtilsAdapter;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskRepository implements PersistenceInterface<Task>{

  private JsonUtilsAdapter<Task> jsonUtilsAdapter;

  public TaskRepository(JsonUtilsAdapter<Task> jsonUtilsAdapter){
    this.jsonUtilsAdapter = jsonUtilsAdapter;
  }

  @Override
  public Task save(Task t){
    ArrayList<Map<String, Object>> objects  = this.jsonUtilsAdapter.readFromJson(Task.class);
    ArrayList<Task> tasks = objects.stream()
      .map( i -> new Task(((Number)i.get("id")).longValue(), (String) i.get("title"), (boolean) i.get("archived"), (boolean) i.get("checked")))
      .collect(Collectors.toCollection(ArrayList::new));
    tasks.add(t);
    this.jsonUtilsAdapter.writeToJson(tasks);
    return t;
  }
  
  @Override
  public ArrayList<Task> getAll(){
    ArrayList<Map<String, Object>> objects  = this.jsonUtilsAdapter.readFromJson(Task.class);
    ArrayList<Task> tasks = objects.stream()
      .map( i -> new Task(((Number)i.get("id")).longValue(), (String) i.get("title"), (Boolean) i.get("archived"), (Boolean)i.get("checked")))
      .collect(Collectors.toCollection(ArrayList::new));
    return tasks;
  }
  
  @Override
  public Task getById(long id){
    ArrayList<Map<String, Object>> objects  = this.jsonUtilsAdapter.readFromJson(Task.class);
    for (Map<String,Object> i : objects) {
      if(((Number)i.get("id")).longValue() == id){
        return new Task(((Number)i.get("id")).longValue(), (String) i.get("title"), (boolean) i.get("archived"), (boolean) i.get("checked"));
      } 
    }
    return null;
  }
  
  @Override
  public void deleteById(long id){
    ArrayList<Map<String, Object>> objects = this.jsonUtilsAdapter.readFromJson(Task.class);
    objects.removeIf(i -> ((Number) i.get("id")).longValue() == id);
    ArrayList<Task> tasks = objects.stream()
      .map( i -> new Task(((Number)i.get("id")).longValue(), (String) i.get("title"), (boolean) i.get("archived"), (boolean) i.get("checked")))
      .collect(Collectors.toCollection(ArrayList::new));
    this.jsonUtilsAdapter.writeToJson(tasks);
  }

  @Override
  public void update(long id, Task t) {
    ArrayList<Map<String, Object>> objects = this.jsonUtilsAdapter.readFromJson(Task.class);
    ArrayList<Task> tasks = objects.stream()
      .map( i -> new Task(((Number)i.get("id")).longValue(), (String) i.get("title"), (boolean) i.get("archived"), (boolean) i.get("checked")))
      .collect(Collectors.toCollection(ArrayList::new));
    for (Task task: tasks) {
      if(task.getId() == id){
        tasks.set(tasks.indexOf(task), t);
        break;
      } 
    }
    this.jsonUtilsAdapter.writeToJson(tasks);
  }
  
}
