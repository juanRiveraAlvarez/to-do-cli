package org.domain.repository;

import org.domain.model.CustomDate;
import org.infraestructure.adapters.JsonUtilsAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class CustomDateRepository implements PersistenceInterface<CustomDate>{

  private JsonUtilsAdapter<CustomDate> jsonUtilsAdapter;

  public CustomDateRepository(JsonUtilsAdapter<CustomDate> jsonUtilsAdapter){
    this.jsonUtilsAdapter = jsonUtilsAdapter;
  }

  @Override
  public CustomDate save(CustomDate t){
    ArrayList<Map<String, Object>> objects  = this.jsonUtilsAdapter.readFromJson(CustomDate.class);
    //objects.add(t);
    //this.jsonUtilsAdapter.writeToJson(objects);
    return t;
  }

  @Override
  public ArrayList<CustomDate> getAll(){
    ArrayList<Map<String, Object>> objects = this.jsonUtilsAdapter.readFromJson(CustomDate.class);
    ArrayList<CustomDate> customDates = objects.stream()
      .map( i -> new CustomDate(((Number)i.get("id")).longValue(), ((Number) i.get("day")).shortValue(), ((Number) i.get("month")).shortValue(), ((Number) i.get("year")).shortValue()))
      .collect(Collectors.toCollection(ArrayList::new));
    return customDates;
  }

  @Override
  public CustomDate getById(long id){
    return null;
  }

  @Override
  public void deleteById(long id){
  }

  /*
  @Override
  public void update(long id, CustomDate t){
    ArrayList<CustomDate> objects = this.jsonUtilsAdapter.readFromJson(CustomDate.class).stream()
      .map( i -> {
        return new CustomDate((long) i.get("id"), (short)i.get("day"),(short)i.get("month"), (short)i.get("year"));
      })
      .collect(Collectors.toCollection(ArrayList::new));
    for (CustomDate i : objects) {
       if(i.getId() == id){
          objects.set(objects.indexOf(i), t); 
       }
    }
    this.jsonUtilsAdapter.writeToJson(objects);
  }
  */
  
  @Override
  public void update(long id, CustomDate t) {
     // Lee la lista de LinkedHashMap desde el JSON
    ArrayList<Map<String, Object>> jsonList = this.jsonUtilsAdapter.readFromJson(CustomDate.class);
   // this.jsonUtilsAdapter.writeToJson(objects);
  }


}
