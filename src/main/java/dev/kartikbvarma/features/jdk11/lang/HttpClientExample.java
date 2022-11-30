package dev.kartikbvarma.features.jdk11.lang;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Synchronous Get
        var httpClient = HttpClient.newBuilder().build();
        var uri = "https://httpbin.org/";
        var httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
                .build();
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.printf("Received %d%n", response.statusCode());

        // Async POST
        var postUrl = "https://httpbin.org/post";
        var postRequest = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .uri(URI.create(postUrl))
                .header("Content-Type", "application/json")
                .build();

        HttpClient.newHttpClient()
                .sendAsync(postRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);
    }
}
