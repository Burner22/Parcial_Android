package com.lospibescompany.menuactivity.ui.gallery;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lospibescompany.menuactivity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class GalleryViewModel extends AndroidViewModel {

    private MutableLiveData<List<String>> actividadesMutableLiveData;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        actividadesMutableLiveData = new MutableLiveData<>();
        cargarActividades();
    }

    private void cargarActividades() {
        List<String> actividades = new ArrayList<>();
        actividadesMutableLiveData.setValue(actividades);
    }

    public void actualizarLista(List<String> nuevaLista) {
        actividadesMutableLiveData.postValue(nuevaLista);
    }

    public MutableLiveData<List<String>> getActividades() {
        return actividadesMutableLiveData;
    }
}