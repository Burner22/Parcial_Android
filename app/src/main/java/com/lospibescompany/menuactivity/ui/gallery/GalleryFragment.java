package com.lospibescompany.menuactivity.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lospibescompany.menuactivity.MainActivity;
import com.lospibescompany.menuactivity.R;
import com.lospibescompany.menuactivity.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotaAdapter misActividadesAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        recyclerView = root.findViewById(R.id.recycler_view_mis_actividades);
        if (recyclerView == null) {
            Log.d("misactividadesFragment", "recyclerView is null");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        misActividadesAdapter = new NotaAdapter();
        recyclerView.setAdapter(misActividadesAdapter);

        GalleryViewModel actividadViewModel = new ViewModelProvider(requireActivity()).get(GalleryViewModel.class);
        actividadViewModel.getActividades().observe(getViewLifecycleOwner(), actividades -> {
            misActividadesAdapter.setActividades(getContext(), MainActivity.notas);
        });
        return root;
    }


}