package apronin.com.stub;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import apronin.com.stub.component.SomeComponent;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Context mContext;

    public ApplicationModule(Context context){
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    SomeComponent provideSomeComponent() {
        return new SomeComponent();
    }

    @Provides
    @Singleton
    EventBus provideEventbus(){
        return new EventBus();
    }
}
