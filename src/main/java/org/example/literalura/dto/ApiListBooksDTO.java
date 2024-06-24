package org.example.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.literalura.models.Libro;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiListBooksDTO(@JsonProperty List<LibroDTO> results) {
}
