package cl.ucn.disc.dsm.directorio;

import android.app.Application;
import android.content.Context;

import org.acra.ACRA;
import org.acra.annotation.AcraCore;

@AcraCore(buildConfigClass = BuildConfig.class)

public class App extends Application {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        //The following Line triggers the initialization of ACRA
        ACRA.init(this);
    }
}
