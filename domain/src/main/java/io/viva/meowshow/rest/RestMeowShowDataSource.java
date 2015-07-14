package io.viva.meowshow.rest;


import com.squareup.otto.Bus;

import io.viva.meowshow.MeowShowDataSource;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RestMeowShowDataSource implements MeowShowDataSource {

    private static final String MEOWSHOW_HOST = "";

    private final MeowShowDataAPI api;
    private final Bus bus;

    public RestMeowShowDataSource(Bus bus) {

        RestAdapter rest = new RestAdapter.Builder()
            .setEndpoint(MEOWSHOW_HOST)
            .setLogLevel(RestAdapter.LogLevel.HEADERS_AND_ARGS)
            .build();

        api = rest.create(MeowShowDataAPI.class);
        this.bus = bus;
    }

    @Override
    public void getConfiguration() {
        api.getConfiguration(retrofitCallback);
    }

    public Callback retrofitCallback = new Callback() {
        @Override
        public void success(Object o, Response response) {

            /*if (o instanceof MovieDetail) {

                MovieDetail detailResponse = (MovieDetail) o;
                bus.post(detailResponse);

            } else if (o instanceof MoviesWrapper) {

                MoviesWrapper moviesApiResponse = (MoviesWrapper) o;
                bus.post(moviesApiResponse);

            } else if (o instanceof ConfigurationResponse) {

                ConfigurationResponse configurationResponse = (ConfigurationResponse) o;
                bus.post(configurationResponse);

            } else if (o instanceof ReviewsWrapper) {

                ReviewsWrapper reviewsWrapper = (ReviewsWrapper) o;
                bus.post(reviewsWrapper);

            } else if (o instanceof ImagesWrapper) {

                ImagesWrapper imagesWrapper = (ImagesWrapper) o;
                bus.post(imagesWrapper);
            }*/
        }

        @Override
        public void failure(RetrofitError error) {
            System.out.println("[DEBUG] RestMovieSource failure - " + error.getMessage());
        }
    };

}
