package org;


import org.infraestructure.adapters.JsonUtilsAdapter;
import org.domain.model.CustomDate;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App{
  public static void main(String[] args) {
    JsonUtilsAdapter j = new JsonUtilsAdapter<CustomDate>();
    CustomDate cd = new CustomDate((short)1,(short)2,(short)2021);
    j.writeToJson(cd);
  }
}
