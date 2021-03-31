package io.github.twosquirrels.httpasfunctions;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import spark.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.*;

/**
 * HTTP as Functions library
 * Use Gson, Spark and OkHttp3.
 * Require Gson.
 * @author TwoSquirrels
 * @version 1.3.0
 */
public class HttpAsFunctions {

    static private final String TYPE = "application/json";

    static private final Gson gson = new Gson();
    static private final Map<Integer, Service> services = new HashMap<Integer, Service>();
    static private final OkHttpClient client = new OkHttpClient.Builder().build();

    /**
     * Make a new interprocess or internet function.
     * add function example:<pre>
     * {@code
     * makeFunc(8080, "add", args -> {
     *   JsonObjectArgs jsonObjectArgs = new JsonObjectArgs(args);
     *   return new JsonPrimitive(jsonObjectArgs.getAsFloat("x") + jsonObjectArgs.getAsFloat("y"));
     * });
     * }
     * </pre>
     * @param port port to put the function to make
     * @param name function name
     * @param function function to make
     */
    static public void makeFunc(int port, String name, UnaryOperator<JsonElement> function) {
        services.computeIfAbsent(port, port_ -> {
            // If there is a Service, use it, if not, make it.
            Service newService = Service.ignite();
            newService.port(port_);
            return newService;
        }).post("/" + name, TYPE, (req, res) -> {
            // Convert json using Gson.
            res.type(TYPE);
            JsonElement request;
            try {
                request = gson.fromJson(
                        req.body(),
                        JsonElement.class
                );
            } catch(JsonSyntaxException e) {
                JsonObject response = new JsonObject();
                response.add("error", new JsonObject());
                response.get("error").getAsJsonObject().addProperty("code", 400);
                response.get("error").getAsJsonObject().addProperty("message", "REQUEST JSON FORMAT ERROR: " + e.getMessage());
                return gson.toJson(response);
            }
            // run function and respond
            try {
                return gson.toJson(function.apply(request));
            } catch(HaFException e) {
                JsonObject response = new JsonObject();
                response.add("error", new JsonObject());
                response.get("error").getAsJsonObject().addProperty("code", e.getStatusCode());
                response.get("error").getAsJsonObject().addProperty("message", e.getMessage());
                return gson.toJson(response);
            } catch(Exception e) {
                JsonObject response = new JsonObject();
                response.add("error", new JsonObject());
                response.get("error").getAsJsonObject().addProperty("code", 500);
                response.get("error").getAsJsonObject().addProperty("message", "SERVER PROGRAM ERROR: " + e.getMessage());
                return gson.toJson(response);
            }
        });
    }

    /**
     * Call an interprocess function.
     * @param port the port(ex:8080) where the function to call is
     * @param name the function name
     * @param request the function argument JsonElement
     * @return return value JsonElement of the return value of the function
     * @throws IllegalArgumentException Avoid this exception by calling HttpUrl.parse(java.lang.String); it returns null for invalid URLs.
     * @throws NullPointerException when response body is null.
     * @throws IOException If the request could not be executed due to cancellation, a connectivity problem or timeout. Becau/e networks can fail during an exchange, it is possible that the remote server accepted the request before the failure.
     * @throws JsonSyntaxException When the JSON conversion of the response fails.
     * @throws IllegalStateException When the call has already been http request executed.
     * @throws HaFException When the response is error format.
     */
    static public JsonElement callFunc(int port, String name, JsonElement request) throws IllegalArgumentException, NullPointerException, IOException, JsonSyntaxException, IllegalStateException, HaFException {
        return callFunc("localhost", false, port, name, request);
    }
    /**
     * Call an internet function.
     * @param host the host(ex:"localhost") where the function to call is
     * @param port the port(ex:8080) where the function to call is
     * @param secure whether it is "https"
     * @param name the function name
     * @param request the function argument JsonElement
     * @return return value JsonElement of the return value of the function
     * @throws IllegalArgumentException Avoid this exception by calling HttpUrl.parse(java.lang.String); it returns null for invalid URLs.
     * @throws NullPointerException when response body is null.
     * @throws IOException If the request could not be executed due to cancellation, a connectivity problem or timeout. Becau/e networks can fail during an exchange, it is possible that the remote server accepted the request before the failure.
     * @throws JsonSyntaxException When the JSON conversion of the response fails.
     * @throws IllegalStateException When the call has already been http request executed.
     * @throws HaFException When the response is error format.
     */
    static public JsonElement callFunc(String host, boolean secure, int port, String name, JsonElement request) throws IllegalArgumentException, NullPointerException, IOException, JsonSyntaxException, IllegalStateException, HaFException {
        final Request okRequest = new Request.Builder()
                .url((secure ? "https" : "http") + "://" + host + ":" + port + "/" + name)
                .post(
                        RequestBody.Companion.create(
                                gson.toJson(request),
                                MediaType.get(TYPE + "; charset=utf-8")
                        )
                )
                .build();
        JsonElement response = gson.fromJson(
                Objects.requireNonNull(client.newCall(okRequest).execute().body()).string(),
                JsonElement.class
        );
        try {
            JsonObject error =
                    Objects.requireNonNull(response.getAsJsonObject()
                            .get("error")).getAsJsonObject();
            throw new HaFException(
                    Objects.requireNonNull(error.get("code")).getAsInt(),
                    Objects.requireNonNull(error.get("message")).getAsString()
            );
        } catch(IllegalStateException | NullPointerException | ClassCastException thisIsNoError) {
            // no problem so no program
        }
        return response;
    }

}
