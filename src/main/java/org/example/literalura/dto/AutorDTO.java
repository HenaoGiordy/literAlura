package org.example.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO(@JsonProperty String name,
                       @JsonProperty Integer birth_year,
                       @JsonProperty Integer death_year) {
}
