package com.example.foody.ui.fragments.instructions

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.foody.databinding.FragmentInstructionsBinding
import com.example.foody.models.Result
import com.example.foody.util.Constants

class InstructionsFragment : Fragment() {

    private var _binding: FragmentInstructionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInstructionsBinding.inflate(layoutInflater, container, false)

        val args = arguments
        val myBundle = if (Build.VERSION.SDK_INT >= 33) {
            args!!.getParcelable(Constants.RECIPE_RESULT_KEY, Result::class.java)
        } else {
            @Suppress("DEPRECATION")
            args!!.getParcelable<Result>(Constants.RECIPE_RESULT_KEY) as Result
        }

        binding.instructionsWebView.webViewClient = object : WebViewClient() {}
        val webSiteUrl: String = myBundle!!.sourceUrl
        binding.instructionsWebView.loadUrl(webSiteUrl)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}