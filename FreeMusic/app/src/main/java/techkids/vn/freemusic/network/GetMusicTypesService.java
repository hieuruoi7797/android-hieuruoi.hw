package techkids.vn.freemusic.network;

import retrofit2.Call;
import retrofit2.http.GET;
import techkids.vn.freemusic.network.json_model.MainObjectJSON;

/**
 * Created by ctrls on 12/10/2017.
 */

public interface GetMusicTypesService {
    @GET("api")
    Call<MainObjectJSON> getMusicType();

}
