package com.wasala.moviebase.payloads.requests;

import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieRequest {
  @NotBlank
  private String name;
  private List<Long> genres;
}
