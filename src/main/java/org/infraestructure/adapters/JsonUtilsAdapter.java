package org.infraestructure.adapters;

import org.infraestructure.ports.JsonUtilsPort;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;

import java.util.Properties;

public class JsonUtilsAdapter<T> implements JsonUtilsPort<T>{

  public static Properties properties = new Properties();

  private ObjectMapper objectMapper;

  static{
    try{
      if(JsonUtilsAdapter.class.getClassLoader().getResourceAsStream("config.properties") == null){
        System.out.println("no");
      }else{
        properties.load(JsonUtilsAdapter.class.getClassLoader().getResourceAsStream("config.properties"));
      }
    }catch(IOException e){
      System.out.println(e);
    }
  }

  public JsonUtilsAdapter(){
    this.objectMapper = new ObjectMapper();
//    this.file = new File(properties.getProperty(".path"));
  }

  @Override
  public T readFromJson(Class<T> clazz , T t){
    try{
      return this.objectMapper.readValue(new File(properties.getProperty(t.getClass().getSimpleName()+".path")), clazz);
    }catch(Exception e){
      System.out.println(e);
    }
      return null;
  }

  @Override
  public void writeToJson(T t){
    try{
      //System.out.println(properties.getProperty(t.getClass().getSimpleName()+".path"));
      this.objectMapper.writeValue(new File(properties.getProperty(t.getClass().getSimpleName()+".path")), t);
    }catch(Exception e){
      System.out.println(e);
    }
  }

}
