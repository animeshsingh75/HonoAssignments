package com.example.honoassigment1;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import com.example.honoassigment1.databinding.FragmentFirstBinding;
import com.example.honoassigment1.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {

    FragmentSecondBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            SecondFragmentArgs args = SecondFragmentArgs.fromBundle(getArguments());
            binding.resultTv.setText(String.valueOf(args.getFirstFragmentResult()));
        }
        binding.addBtn.setOnClickListener(v -> {
            int firstNum = Integer.parseInt(binding.resultTv.getText().toString());
            int secondNum = Integer.parseInt(binding.edtv2.getText().toString());
            String sum = String.valueOf(firstNum + secondNum);
            NavDirections action = SecondFragmentDirections.actionSecondFragmentToFirstFragment().setSecondFragmentResult(sum);
            NavController controller = Navigation.findNavController(v);
            NavOptions navOptions = new NavOptions.Builder()
                    .setPopUpTo(R.id.firstFragment, true)
                    .build();
            controller.navigate(action, navOptions);
        });
        super.onViewCreated(view, savedInstanceState);
    }
}