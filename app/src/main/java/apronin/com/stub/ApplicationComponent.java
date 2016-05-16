package apronin.com.stub;

import javax.inject.Singleton;

import apronin.com.stub.activity.MainActivity;
import apronin.com.stub.component.SomeComponent;
import dagger.Component;

/**
 * Created by pronin_a on 5/16/2016.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(SomeComponent someComponent);
}
