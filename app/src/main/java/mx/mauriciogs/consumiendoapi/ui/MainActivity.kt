package mx.mauriciogs.consumiendoapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import mx.mauriciogs.consumiendoapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var charactersFragment: CharactersFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        mainViewModel.getOneCharacter(1)
        initObservers()
        initListener()
        charactersFragment= CharactersFragment()
    }


    private fun initListener() {
        binding.button.setOnClickListener {
            binding.materialCardView.visibility= View.GONE
            binding.button.visibility=View.GONE
            supportFragmentManager
                .beginTransaction()
                .add(binding.frameLayout.id, charactersFragment)
                .commit()
        }
    }

    private fun initObservers() {
        // Observamos la variable anyCharacter del ViewModel, cuando esta cambie su valor
        // se llamará a setUI pasando dicho valor
        mainViewModel.oneCharacter.observe(this) {  character ->
            setUI(character)
        }
        // Observamos la variable showError para mostrar en pantalla cuando falle algo al obtener los datos
        mainViewModel.showError.observe(this) { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG)
        }
        // Observar la variable creada en el viewModel que trae la lista de personajes y pasarle
        // dicha lista al Recycler View actualizando su contenido
        mainViewModel.anyCharacter.observe(this){ page ->
            mainViewModel.getAllCharacter(1)
        }
    }

    // Por ahora pintamos la UI con los datos de un personaje obtenido, algo similar se debe aplicar
    // cuando se listen los personajes, pero se utilizará un RecyclerView
    private fun setUI(personaje: mx.mauriciogs.consumiendoapi.domain.model.Character) {
        Glide.with(this@MainActivity)
            .load(personaje.image)
            .centerCrop()
            .into(binding.ivCharacter)
        binding.tvNameCharacter.text = personaje.name
        binding.tvGenderCharacter.text = personaje.gender
        binding.tvSpecieCharacter.text = personaje.species
        binding.tvStateCharacter.text = personaje.status
    }
}