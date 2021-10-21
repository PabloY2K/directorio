package cl.ucn.disc.dsm.directorio;

import android.app.Application;
import android.content.Context;
import org.acra.ACRA;
import org.acra.config.CoreConfigurationBuilder;
import org.acra.config.DialogConfigurationBuilder;
import org.acra.config.MailSenderConfigurationBuilder;
import org.acra.data.StringFormat;



public class App extends Application {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        CoreConfigurationBuilder builder = new CoreConfigurationBuilder(this);
        builder
                .withBuildConfigClass(BuildConfig.class)
                .withReportFormat(StringFormat.JSON)
                .withEnabled(true);

        //ACRA Dialog Configuration
        builder.getPluginConfigurationBuilder(DialogConfigurationBuilder.class)
                //required
                .withResText(R.string.acra_dialog_title)
                .withResCommentPrompt(R.string.acra_dialog_comment)
                .withEnabled(true);

        //ACRA Email Configuration
        builder.getPluginConfigurationBuilder(MailSenderConfigurationBuilder.class)
                .withMailTo("pablo.herrera@alumnos.ucn.cl")
                .withReportFileName("crash.txt")
                .withSubject(getString(R.string.acra_dialog_title))
                .withBody(getString(R.string.acra_dialog_comment))
                .withEnabled(true);



        //The following Line triggers the initialization of ACRA
        ACRA.init(this, builder);
    }
}
