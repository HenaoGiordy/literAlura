package org.example.literalura.api;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@Component
public class ApiBooks {

    private URI uri = URI.create("https://gutendex.com/");

    public ApiBooks() {
    }

    public URI getUri() {
        return uri;
    }
}
