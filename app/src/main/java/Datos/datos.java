package Datos;

import java.util.List;

import Models.wifi;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by linux on 24/11/17.
 */

public interface datos {

    @GET("f4kx-n3nn.json")
    Call<List<wifi>> obtenerListaPeajes();
}
