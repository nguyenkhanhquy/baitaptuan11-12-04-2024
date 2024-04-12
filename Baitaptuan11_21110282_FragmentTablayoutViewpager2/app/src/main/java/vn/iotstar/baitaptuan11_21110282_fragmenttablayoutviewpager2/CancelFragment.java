package vn.iotstar.baitaptuan11_21110282_fragmenttablayoutviewpager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vn.iotstar.baitaptuan11_21110282_fragmenttablayoutviewpager2.databinding.FragmentCancelBinding;
import vn.iotstar.baitaptuan11_21110282_fragmenttablayoutviewpager2.databinding.FragmentNeworderBinding;

public class CancelFragment extends Fragment {
    FragmentCancelBinding binding;

    public CancelFragment() {

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
        binding = FragmentCancelBinding.inflate(inflater, container, false);

        //recyclerView

        return binding.getRoot();
    }
}
