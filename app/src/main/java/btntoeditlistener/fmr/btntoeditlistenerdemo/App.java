package btntoeditlistener.fmr.btntoeditlistenerdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/2/28.
 */

public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getAppContext(){
        return mContext;
    }
}
