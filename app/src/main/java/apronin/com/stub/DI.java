package apronin.com.stub;

import android.content.Context;

import apronin.com.stub.ApplicationComponent;
import apronin.com.stub.ApplicationModule;
import apronin.com.stub.DaggerApplicationComponent;

/**
 * Created by pronin_a on 5/16/2016.
 */
public class DI {

    private static ApplicationComponent mComponent;

    private DI () {

    }

    public static synchronized void init(Context context) {
        if (mComponent == null) {
            mComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(context)).build();
        }
    }

    public static ApplicationComponent get() {
        return mComponent;
    }
}
