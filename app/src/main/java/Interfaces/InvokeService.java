package Interfaces;

import ApiResponses.Responses;
import ApiResponses.Results;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InvokeService {

    String API_CONSUMER = "https://rickandmortyapi.com/";
    @GET("api/character")
    Call<Responses> getCharacters();

}
