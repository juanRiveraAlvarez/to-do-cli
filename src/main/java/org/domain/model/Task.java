package org.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
public class Task{

  private long id;
  private String title;
  private boolean archived;
  private boolean checked;
  
  @JsonCreator
  public Task(
    @JsonProperty("id") long id,
    @JsonProperty("title") String title,
    @JsonProperty("archived") boolean archived,
    @JsonProperty("checked") boolean checked
    ){
      this.id = id;
      this.title = title;
      this.archived = archived;
      this.checked = checked;
    }

}
