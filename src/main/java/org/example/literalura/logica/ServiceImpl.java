package org.example.literalura.logica;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.literalura.api.ApiBooks;
import org.example.literalura.dto.ApiListBooksDTO;
import org.example.literalura.dto.LibroDTO;
import org.example.literalura.models.Autor;
import org.example.literalura.models.Libro;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceImpl implements IService {

    private final ApiBooks api = new ApiBooks();
    private final ObjectMapper mapper = new ObjectMapper();
    HttpClient client = HttpClient.newHttpClient();

    public ServiceImpl() {
    }

    @Override
    public Libro buscarLibro(String titulo) throws IOException, InterruptedException {
        URI uri = URI.create(api.getUri().toString() + "/books/?search=" + titulo);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ApiListBooksDTO libros = mapper.readValue(response.body(), ApiListBooksDTO.class);

        Optional<LibroDTO> libro = libros.results().stream().findFirst();

        if (libro.isPresent()) {
            LibroDTO libroDTO = libro.get();
            return new Libro(libroDTO);
        }

        return null;
    }

    @Override
    public List<Libro> buscarLibrosRegistrados() {
        return List.of();
    }

    @Override
    public List<Autor> buscarAutoresRegistrados() {
        return List.of();
    }

    @Override
    public List<Autor> autoresVivosFechaDeterminada(LocalDate fechaInicial, LocalDate fechaFinal) {
        return List.of();
    }

    @Override
    public List<Libro> buscarLibrosIdioma(String idioma) {
        return List.of();
    }
}
