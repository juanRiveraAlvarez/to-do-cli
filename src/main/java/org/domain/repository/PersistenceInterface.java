package org.domain.repository;

import java.util.ArrayList;

public interface PersistenceInterface<T>{

  T save(T t);
  ArrayList<T> getAll();
  T getById(long id);
  void deleteById(long id);
  void update(long id, T t);

}
