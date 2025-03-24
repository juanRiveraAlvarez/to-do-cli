package org;

import org.infraestructure.adapters.JsonUtilsAdapter;
import org.domain.model.CustomDate;
import org.domain.model.Task;
import org.domain.model.CustomDate;

import org.domain.repository.*;
import org.domain.repository.*;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App{
  public static void main(String[] args) {
    /*
    JsonUtilsAdapter j = new JsonUtilsAdapter<CustomDate>(new ObjectMapper());
    CustomDate cd = new CustomDate((long)5,(short)1,(short)2,(short)2021);
    CustomDateRepository customDateRepository = new CustomDateRepository(j);
    System.out.println(customDateRepository.save(cd));
    System.out.println(customDateRepository.getAll());
    System.out.println(customDateRepository.getById(3));
    customDateRepository.deleteById(2);
    customDateRepository.update((long)3 ,new CustomDate());
    System.out.println(customDateRepository.getAll());
    */
    /*
    j.writeToJson(cd);
    System.out.println(j.readFromJson(CustomDate.class));
    */
    
    Task ts = new Task(4,"titulo",false,false);
    JsonUtilsAdapter j2 = new JsonUtilsAdapter<Task>(new ObjectMapper());
    TaskRepository taskRepository = new TaskRepository(j2);
    //System.out.println(taskRepository.getAll());
    System.out.println(taskRepository.save(ts));
    //System.out.println(taskRepository.getAll());
    System.out.println(taskRepository.getById(2));
    taskRepository.deleteById(2);
    taskRepository.update(3, new Task(3,"titulo",false,false));
    System.out.println(taskRepository.getAll());
    
  }
}
