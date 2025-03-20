package org.infraestructure.ports;

public interface JsonUtilsPort<T>{
  
  T readFromJson(T type);
  void writeToJson(T t);

}
