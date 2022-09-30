package fr.words.api.response;

import com.sun.net.httpserver.HttpHandler;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

public class DataHandler {

    public HttpHandler handler(Supplier<String> word) {
        return t -> {
            String response = "{\"word\":\"" + word.get() + "\"}";

            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

            System.out.println(response);

            t.getResponseHeaders().add("content-type", "application/json; charset=utf-8");

            t.getResponseHeaders().add("cache-control", "private, no-cache, no-store, must-revalidate, max-age=0");

            t.getResponseHeaders().add("pragma", "no-cache");

            t.sendResponseHeaders(200, bytes.length);

            try (OutputStream os = t.getResponseBody()) {
                os.write(bytes);
            }
        };
    }
}
