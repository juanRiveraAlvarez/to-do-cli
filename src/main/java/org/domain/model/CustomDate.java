package org.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomDate{
  
  private long id;
  private short day;
  private short month;
  private short year;
/*
  public CustomDate(short day, short month, short year){
    this.day = day;
    this.month = month;
    this.year = year;
  }
  
  public CustomDate(){
  }
  */
/*
  public short getDay(){
    return this.day;
  }

  public short getMonth(){
    return this.month;
  }

  public short getYear(){
    return this.year;
  }

*/
}
