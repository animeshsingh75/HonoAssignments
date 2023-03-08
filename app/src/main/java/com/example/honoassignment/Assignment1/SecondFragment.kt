package com.example.honoassignment.Assignment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigation.findNavController
import com.example.honoassignment.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    var binding: FragmentSecondBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {
            val args = SecondFragmentArgs.fromBundle(requireArguments())
            binding!!.resultTv.text = args.firstFragmentResult.toString()
        }
        binding!!.addBtn.setOnClickListener { v: View? ->
            val firstNum = binding!!.resultTv.text.toString().toInt()
            val secondNum = binding!!.edtv2.text.toString().toInt()
            val sum = (firstNum + secondNum).toString()
            val action: NavDirections =
                SecondFragmentDirections.actionSecondFragmentToFirstFragment()
                    .setSecondFragmentResult(sum)
            val controller = findNavController(v!!)
            val navOptions: NavOptions = NavOptions.Builder()
                .setPopUpTo(R.id.firstFragment, true)
                .build()
            controller.navigate(action, navOptions)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}