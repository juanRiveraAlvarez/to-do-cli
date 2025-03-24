package org.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Data
@NoArgsConstructor
public class CustomDate{
  
  private long id;
  private short day;
  private short month;
  private short year;

  @JsonCreator
  public CustomDate(
    @JsonProperty("id") long id,
    @JsonProperty("day") short day,
    @JsonProperty("month") short month,
    @JsonProperty("year") short year
    ){
      this.id = id;
      this.day = day;
      this.month = month;
      this.year = year;
    }
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
