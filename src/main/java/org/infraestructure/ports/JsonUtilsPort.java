package org.infraestructure.ports;

import java.util.List;

public interface JsonUtilsPort<T>{
  
  List<T> readFromJson(Class<T> clazz);
  T writeToJson(T t);

}
