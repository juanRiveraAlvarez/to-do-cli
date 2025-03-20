package org.repository;

import org.domain.model.CustomDate;

import java.util.ArrayList;


public class CustomDateRepository implements PersistenceInterface<CustomDate>{

  @Override
  public void save(CustomDate t){
    System.out.println();
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
