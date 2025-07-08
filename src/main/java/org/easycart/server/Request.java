package main.java.org.easycart.server;

import java.util.Map;

public class Request<T> {
    private Map<String, String> headers;
    private T body;

    public Request() { }

    public Map<String, String> getHeaders() { return headers; }
    public void setHeaders(Map<String, String> headers) { this.headers = headers; }

    public T getBody() { return body; }
    public void setBody(T body) { this.body = body; }
}
