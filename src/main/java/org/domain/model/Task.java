package org.domain.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task{

  private long id;
  private String title;
  private boolean isArchived;
  private boolean checked;

}
