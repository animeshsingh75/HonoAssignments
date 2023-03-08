package com.example.honoassignment.Assignment1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import com.example.honoassignment.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    var binding: FragmentFirstBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val args = FirstFragmentArgs.fromBundle(requireArguments())
            if (args.secondFragmentResult != null) {
                binding!!.resultTv.text = args.secondFragmentResult
                Log.d("Hello", "onViewCreated:" + args.secondFragmentResult)
            }
        }
        binding!!.addBtn.setOnClickListener { v: View? ->
            val firstNum = binding!!.edtv1.text.toString().toInt()
            val secondNum = binding!!.edtv2.text.toString().toInt()
            val action: NavDirections =
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(firstNum + secondNum)
            findNavController(v!!).navigate(action)
        }
    }
}