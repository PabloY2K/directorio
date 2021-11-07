package cl.ucn.disc.dsm.directorio;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import lombok.NonNull;

public class FuncionarioViewModel extends AndroidViewModel {

    private MutableLiveData<List<Funcionario>> funcionarios;

    public FuncionarioViewModel(@NonNull Application application){
        super(application);
    }

    public LiveData<List<Funcionario>> getFuncionarios(){
        if(this.funcionarios ==null){
            this.funcionarios = new MutableLiveData<>();
            this.loadFuncionarios();
        }
        return this.funcionarios;
    }

    private void loadFuncionarios(){
        AsyncTask.execute(()-> {
            List<Funcionario> theFuncionarios;

            try(final InputStream is = super.getApplication().getAssets().open("funcionarios.json")) {

                final Type funcionariosListType = new TypeToken<List<Funcionario>>(){}.getType();
                final Reader reader = new InputStreamReader(is);
                final Gson gson = new GsonBuilder().create();
                theFuncionarios = gson.fromJson(reader,funcionariosListType);


            }catch (IOException e ) {
                e.printStackTrace();
                return;
            }
            this.funcionarios.postValue(theFuncionarios);

        });
    }
}
