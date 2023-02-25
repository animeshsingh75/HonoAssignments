package com.example.honoassigment1;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.NavAction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import com.example.honoassigment1.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

    FragmentFirstBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            FirstFragmentArgs args = FirstFragmentArgs.fromBundle(getArguments());
            if (args.getSecondFragmentResult() != null) {
                binding.resultTv.setText(args.getSecondFragmentResult());
                Log.d("Hello", "onViewCreated:" + args.getSecondFragmentResult());
            }
        }
        binding.addBtn.setOnClickListener(v -> {
            int firstNum = Integer.parseInt(binding.edtv1.getText().toString());
            int secondNum = Integer.parseInt(binding.edtv2.getText().toString());
            NavDirections action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(firstNum + secondNum);
            Navigation.findNavController(v).navigate(action);
        });
    }
}