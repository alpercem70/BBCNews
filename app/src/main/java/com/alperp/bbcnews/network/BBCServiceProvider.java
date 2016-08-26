package com.alperp.bbcnews.network;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public final class BBCServiceProvider {

    private static final String API_BASE_URL = "http://feeds.bbci.co.uk";

    private static BBCService bbcService;

    // Suppress default constructor for noninstantiablility
    private BBCServiceProvider() {
        throw new AssertionError();
    }

    public static BBCService getService() {
        if (bbcService == null) {
            bbcService = createService(BBCService.class);
        }

        return bbcService;
    }

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }
}
