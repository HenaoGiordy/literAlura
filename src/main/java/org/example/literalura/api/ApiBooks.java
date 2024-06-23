package org.example.literalura.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ApiBooks {

    private HttpClient client = HttpClient.newHttpClient();

    private URI uri = URI.create("https://gutendex.com/");

    private HttpRequest request = HttpRequest.newBuilder(uri).build();
}
