package org.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;
import lombok.Data;

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

}
