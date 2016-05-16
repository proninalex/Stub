package apronin.com.stub.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import apronin.com.stub.DI;
import apronin.com.stub.R;
import apronin.com.stub.component.SomeComponent;

public class MainActivity extends AppCompatActivity {

    @Inject
    SomeComponent mSomeComponent;

    @Inject
    EventBus mEventBus;

    public MainActivity(){
        DI.get().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.main_activity_hello)).setText(mSomeComponent.getText());
        Button button = (Button) findViewById(R.id.main_activity_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventBus.post(new MainActivityEvent());
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MainActivityEvent event){
        Toast.makeText(this, "event from bus", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        mEventBus.register(this);
    }

    @Override
    public void onStop() {
        mEventBus.unregister(this);
        super.onStop();
    }

    public class MainActivityEvent {

    }
}
