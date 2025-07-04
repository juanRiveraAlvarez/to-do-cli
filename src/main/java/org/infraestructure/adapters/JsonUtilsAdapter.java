package org.infraestructure.adapters;

import org.infraestructure.ports.JsonUtilsPort;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Map;


public class JsonUtilsAdapter<T> implements JsonUtilsPort<T>{

  public static Properties properties = new Properties();

  private ObjectMapper objectMapper;

  static{
    try{
      if(JsonUtilsAdapter.class.getClassLoader().getResourceAsStream("config.properties") == null){
        throw new IOException("config.properties not found");
      }else{
        properties.load(JsonUtilsAdapter.class.getClassLoader().getResourceAsStream("config.properties"));
      }
    }catch(IOException e){
      System.out.println(e);
    }
  }

  public JsonUtilsAdapter(ObjectMapper objectMapper){
    this.objectMapper = objectMapper;
  }

  @Override
  public ArrayList<Map<String, Object>> readFromJson(Class<T> clazz){
    try{
      return this.objectMapper.readValue(new File(properties.getProperty(clazz.getSimpleName()+".path")), new TypeReference<ArrayList<Map<String, Object>>>() {});
    }catch(Exception e){
      System.out.println(e);
    }
      return null;
  }

  @Override
  public ArrayList<T> writeToJson(ArrayList<T> t, Class<T> clazz){
    try{
      this.objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(properties.getProperty(clazz.getSimpleName()+".path")), t);
      return t;
    }catch(IOException e){
      System.out.println(e);
    }
    return null;
  }

}
