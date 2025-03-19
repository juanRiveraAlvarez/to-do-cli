package org;

import org.config.ConfigReader;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App{
  public static void main(String[] args) {
    System.out.println(ConfigReader.readJsonPath());
  }
}
