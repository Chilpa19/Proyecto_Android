package mx.mauriciogs.consumiendoapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import mx.mauriciogs.consumiendoapi.databinding.FragmentCharactersBinding
import mx.mauriciogs.consumiendoapi.ui.adapters.CharacterAdapter
import androidx.recyclerview.widget.LinearLayoutManager


class CharactersFragment : Fragment() {
    private var _binding: FragmentCharactersBinding? = null
    private val mainViewModel: MainViewModel by viewModels()
    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentCharactersBinding
            .inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun  initAdapter() {
        binding.rvCharacters.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvCharacters.adapter = CharacterAdapter(
            requireActivity(),
            mainViewModel.ListChar
        )
    }
}