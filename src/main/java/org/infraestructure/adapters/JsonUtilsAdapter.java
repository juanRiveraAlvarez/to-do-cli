package org.infraestructure.ports;

public class JsonUtilsAdapter<T> implements JsonUtilsPort<T>{

  @Override
  public T readFromJson(T type){
    return type;
  }

  @Override
  public void writeToJson(T t){
    System.out.println("");
  }

}
