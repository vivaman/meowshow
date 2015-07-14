package io.viva.meowshow.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.viva.meowshow.MApp;

@Module
public class ApplicationModule {

    private final MApp application;

    public ApplicationModule(MApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

}
