package com.lospibescompany.menuactivity.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.lospibescompany.menuactivity.MainActivity;
import com.lospibescompany.menuactivity.databinding.FragmentHomeBinding;
import com.lospibescompany.menuactivity.ui.gallery.GalleryViewModel;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel vm =
                new ViewModelProvider(this).get(HomeViewModel.class);
        GalleryViewModel gm =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gm.getActividades().observe(getActivity(), new Observer<List<String>>() {
                    @Override
                    public void onChanged(List<String> strings) {
                        vm.agregarNota(MainActivity.notas,binding.nombreNota.getText()+"");
                    }
                });
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}