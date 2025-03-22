package org.domain.repository;

import org.domain.model.CustomDate;
import org.infraestructure.adapters.JsonUtilsAdapter;

import java.util.ArrayList;


public class CustomDateRepository implements PersistenceInterface<CustomDate>{

  private JsonUtilsAdapter<CustomDate> jsonUtilsAdapter;

  public CustomDateRepository(JsonUtilsAdapter<CustomDate> jsonUtilsAdapter){
    this.jsonUtilsAdapter = jsonUtilsAdapter;
  }

  @Override
  public CustomDate save(CustomDate t){
    return jsonUtilsAdapter.writeToJson(t);
  }

  @Override
  public ArrayList<CustomDate> getAll(){
    return new ArrayList<CustomDate>();
  }

  @Override
  public CustomDate getById(long id){
    return new CustomDate();
  }

  @Override
  public void deleteById(long id){
    System.out.println();
  }

  @Override
  public void update(long id, CustomDate t){
    System.out.println();
  }

}
