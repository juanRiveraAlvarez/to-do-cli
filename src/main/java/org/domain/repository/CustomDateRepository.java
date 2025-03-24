package org.domain.repository;

import org.domain.model.CustomDate;
import org.infraestructure.adapters.JsonUtilsAdapter;

import java.util.ArrayList;
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
    ArrayList<CustomDate> customDates = objects.stream()
      .map( i -> new CustomDate(((Number)i.get("id")).longValue(), ((Number) i.get("day")).shortValue(), ((Number) i.get("month")).shortValue(), ((Number) i.get("year")).shortValue()))
      .collect(Collectors.toCollection(ArrayList::new));
    customDates.add(t);
    this.jsonUtilsAdapter.writeToJson(customDates);
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
    ArrayList<Map<String, Object>> objects = this.jsonUtilsAdapter.readFromJson(CustomDate.class);
    for (Map<String,Object> i : objects) {
      if(((Number)i.get("id")).longValue() == id){
        return new CustomDate(((Number)i.get("id")).longValue(), ((Number) i.get("day")).shortValue(), ((Number) i.get("month")).shortValue(), ((Number) i.get("year")).shortValue());
      } 
    }
    return null;
  }

  @Override
  public void deleteById(long id){
    ArrayList<Map<String, Object>> objects = this.jsonUtilsAdapter.readFromJson(CustomDate.class);
    objects.removeIf(i -> ((Number) i.get("id")).longValue() == id);
    ArrayList<CustomDate> customDates = objects.stream()
      .map( i -> new CustomDate(((Number)i.get("id")).longValue(), ((Number) i.get("day")).shortValue(), ((Number) i.get("month")).shortValue(), ((Number) i.get("year")).shortValue()))
      .collect(Collectors.toCollection(ArrayList::new));
    this.jsonUtilsAdapter.writeToJson(customDates);
  }
  
  @Override
  public void update(long id, CustomDate t) {
    ArrayList<Map<String, Object>> objects = this.jsonUtilsAdapter.readFromJson(CustomDate.class);
    ArrayList<CustomDate> customDates = objects.stream()
      .map( i -> new CustomDate(((Number)i.get("id")).longValue(), ((Number) i.get("day")).shortValue(), ((Number) i.get("month")).shortValue(), ((Number) i.get("year")).shortValue()))
      .collect(Collectors.toCollection(ArrayList::new));
    for (CustomDate customDate : customDates) {
      if(customDate.getId() == id){
        customDates.set(customDates.indexOf(customDate), t);
        break;
      } 
    }
    this.jsonUtilsAdapter.writeToJson(customDates);
  }


}
