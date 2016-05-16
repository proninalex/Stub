package apronin.com.stub;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DI.init(this);
    }
}
