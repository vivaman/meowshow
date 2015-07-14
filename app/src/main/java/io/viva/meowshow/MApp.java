package io.viva.meowshow;

import android.app.Application;
import android.os.StrictMode;

import io.viva.meowshow.config.AppConstant;
import io.viva.meowshow.di.components.AppComponent;
import io.viva.meowshow.di.components.DaggerAppComponent;
import io.viva.meowshow.di.modules.ApplicationModule;
import io.viva.meowshow.di.modules.DomainModule;

public class MApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (AppConstant.STRICT_MODE) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDialog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyDeath()
                    .penaltyLog()
                    .build());
        }

        initializeDependencyInjector();
    }

    private void initializeDependencyInjector() {

        mAppComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .domainModule(new DomainModule())
                .build();
    }

    public AppComponent getAppComponent() {

        return mAppComponent;
    }

}
