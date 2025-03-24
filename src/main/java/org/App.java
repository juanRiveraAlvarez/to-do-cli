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
    JsonUtilsAdapter j = new JsonUtilsAdapter<CustomDate>(new ObjectMapper());
    CustomDate cd = new CustomDate((long)5,(short)1,(short)2,(short)2021);
    CustomDateRepository customDateRepository = new CustomDateRepository(j);
    System.out.println(customDateRepository.getAll());
    System.out.println(customDateRepository.getById(2));
    customDateRepository.update((long)2 ,new CustomDate());
    /*
    j.writeToJson(cd);
    System.out.println(j.readFromJson(CustomDate.class));
    */
    /*
    Task ts = new Task(3,"titulo",false,false);
    JsonUtilsAdapter j2 = new JsonUtilsAdapter<Task>(new ObjectMapper());
    j2.writeToJson(ts);
    System.out.println(j2.readFromJson(Task.class));
    */
  }
}
