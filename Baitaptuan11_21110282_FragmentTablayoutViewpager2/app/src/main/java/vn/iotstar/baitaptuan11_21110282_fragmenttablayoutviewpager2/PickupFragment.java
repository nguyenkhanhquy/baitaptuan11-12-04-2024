package vn.iotstar.baitaptuan11_21110282_fragmenttablayoutviewpager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vn.iotstar.baitaptuan11_21110282_fragmenttablayoutviewpager2.databinding.FragmentPickupBinding;

public class PickupFragment extends Fragment {
    FragmentPickupBinding binding;

    public PickupFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater
            , @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentPickupBinding.inflate(inflater, container, false);

        //recyclerView

        return binding.getRoot();
    }
}
