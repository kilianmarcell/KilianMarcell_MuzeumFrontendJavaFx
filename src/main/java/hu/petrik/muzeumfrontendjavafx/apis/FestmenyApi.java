package hu.petrik.muzeumfrontendjavafx.apis;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hu.petrik.muzeumfrontendjavafx.Festmeny;
import hu.petrik.muzeumfrontendjavafx.RequestHandler;
import hu.petrik.muzeumfrontendjavafx.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FestmenyApi {
    private static final String BASE_URL = "http://localhost:8000";
    public static final String FESTMENY_API_URL = BASE_URL + "/api/paintings";

    public static List<Festmeny> getFestmeny() throws IOException {
        Response response = RequestHandler.get(FESTMENY_API_URL);
        String json = response.getContent();
        Gson jsonConvert = new Gson();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        Type type = new TypeToken<List<Festmeny>>(){}.getType();
        return jsonConvert.fromJson(json,type);
    }

    public static Festmeny addFestmeny(Festmeny ujFestmeny) throws IOException {
        Gson jsonConvert = new Gson();
        String festmenyJson = jsonConvert.toJson(ujFestmeny);
        Response response = RequestHandler.post(FESTMENY_API_URL, festmenyJson);

        String json = response.getContent();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return jsonConvert.fromJson(json, Festmeny.class);
    }

    public static Festmeny editFestmeny(Festmeny modositando) throws IOException {
        Gson jsonConvert = new Gson();
        String festmenyJson = jsonConvert.toJson(modositando);
        Response response = RequestHandler.put(FESTMENY_API_URL + "/" + modositando.getId(), festmenyJson);

        String json = response.getContent();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return jsonConvert.fromJson(json, Festmeny.class);
    }

    public static boolean deleteFestmeny(int id) throws IOException {
        Response response = RequestHandler.delete(FESTMENY_API_URL+ "/" + id);

        Gson jsonConvert = new Gson();
        String json = response.getContent();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return response.getResponseCode() == 204;
    }
}
