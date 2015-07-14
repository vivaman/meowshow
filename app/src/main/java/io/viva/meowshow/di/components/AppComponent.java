package io.viva.meowshow.di.components;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;
import io.viva.meowshow.di.modules.ApplicationModule;
import io.viva.meowshow.di.modules.DomainModule;
import io.viva.meowshow.rest.RestMeowShowDataSource;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                DomainModule.class,
        })
public interface AppComponent {

    Bus getBus();

    RestMeowShowDataSource getRestMeowShowDataSource();

}
