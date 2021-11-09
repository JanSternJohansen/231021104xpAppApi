package dk.tec.personapiclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IPersonService
{
    @GET("Person/{id}")
    Call<Person> getPersonById(@Path("id")int id);

    @GET("Person")
    Call<List<Person>> getAllPerson();
}
