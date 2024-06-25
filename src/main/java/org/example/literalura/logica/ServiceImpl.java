package org.example.literalura.logica;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.literalura.api.ApiBooks;
import org.example.literalura.dto.ApiListBooksDTO;
import org.example.literalura.dto.LibroDTO;
import org.example.literalura.models.Autor;
import org.example.literalura.models.Libro;
import org.example.literalura.repository.AutorRepository;
import org.example.literalura.repository.LibroRepository;
import org.example.literalura.utils.Idioma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements IService {

    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    private final ApiBooks api = new ApiBooks();
    private final ObjectMapper mapper = new ObjectMapper();
    HttpClient client = HttpClient.newHttpClient();

    @Autowired
    public ServiceImpl(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

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
            Libro nuevoLibro = new Libro(libroDTO);

            Optional<Libro> libroExistente = libroRepository.findByTitulo(nuevoLibro.getTitulo());

            if (libroExistente.isPresent()) {
                return libroExistente.get();
            }

            List<Autor> autores = libroDTO.authors().stream()
                    .map(Autor::new)
                    .toList();

            autores.forEach(autor -> {autor.getLibros().add(nuevoLibro);});

            autorRepository.saveAll(autores);
            nuevoLibro.setAutores(autores);
            return libroRepository.save(nuevoLibro) ;
        }

        return null;
    }

    @Override
    public List<Libro> buscarLibrosRegistrados() {
        return libroRepository.findAll();
    }

    @Override
    public List<Autor> buscarAutoresRegistrados() {
        return autorRepository.findAll();
    }

    @Override
    public List<Autor> autoresVivosFechaDeterminada(Integer fechaInicial, Integer fechaFinal) {
        List<Autor> autores = autorRepository.findByFechaNacimientoBetween(fechaInicial, fechaFinal);
        return autores.stream().filter(x->x.getFechaFallecimiento() > fechaFinal).toList();
    }

    @Override
    public List<Libro> buscarLibrosIdioma(Idioma idioma) {
        return libroRepository.findByIdiomas(idioma);
    }
}
