package com.lospibescompany.menuactivity.ui.home;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.lospibescompany.menuactivity.MainActivity;
import com.lospibescompany.menuactivity.ui.gallery.GalleryViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public List<String> agregarNota(List notas, String nota){
        if(nota.length() == 0){
            Toast.makeText(getApplication(), "Ingrese una nota!", Toast.LENGTH_SHORT).show();
            return notas;
        }
        else {
            notas.add(nota);
            Toast.makeText(getApplication(), "Nota agregada!", Toast.LENGTH_SHORT).show();
            return notas;
        }

    }


}