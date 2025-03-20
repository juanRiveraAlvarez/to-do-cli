package org.repository;

import java.util.ArrayList;

public interface PersistenceInterface<T>{

  void save(T t);
  ArrayList<T> getAll();
  T getById(long id);
  void deleteById(long id);
  void update(long id, T t);

}
