package org.infraestructure.ports;

public interface JsonUtilsPort<T>{
  
  T readFromJson(Class<T> clazz, T t);
  void writeToJson(T t);

}
