package apronin.com.stub.component;

import apronin.com.stub.DI;

/**
 * Created by pronin_a on 5/16/2016.
 */
public class SomeComponent {

    public SomeComponent () {
        DI.get().inject(this);
    }

    public String getText(){
        return "Component example";
    }
}
