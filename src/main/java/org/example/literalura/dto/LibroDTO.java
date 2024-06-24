package org.example.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDTO(@JsonProperty String title,
                       @JsonProperty List<AutorDTO> authors,
                       @JsonProperty List<String> languages,
                       @JsonProperty Integer download_count) {
}
