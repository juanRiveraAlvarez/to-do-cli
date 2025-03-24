package org.infraestructure.ports;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface JsonUtilsPort<T>{
  
  List<Map<String, Object>> readFromJson(Class<T> clazz);
  ArrayList<T> writeToJson(ArrayList<T> t);

}
