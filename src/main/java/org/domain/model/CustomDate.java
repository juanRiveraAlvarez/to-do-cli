package org.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CustomDate{
  
  private short day;
  private short month;
  private short year;

  public CustomDate(short day, short month, short year){
    this.day = day;
    this.month = month;
    this.year = year;
  }
  
  public CustomDate(){
  }

}
