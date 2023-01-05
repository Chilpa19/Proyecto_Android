package mx.mauriciogs.consumiendoapi.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import mx.mauriciogs.consumiendoapi.databinding.CharactersElementBinding
import mx.mauriciogs.consumiendoapi.domain.model.Character
import mx.mauriciogs.consumiendoapi.domain.model.Characters
import mx.mauriciogs.consumiendoapi.ui.CharactersFragment

class CharacterAdapter(
    private val context: Context,
    private val datos: ArrayList<Characters>
    ): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    inner class ViewHolder(view: CharactersElementBinding): RecyclerView.ViewHolder(view.root){
        val tvName=view.tvNameCharacter
        val tvSpecie=view.tvSpecieCharacter
        val tvGender=view.tvGenderCharacter
        val tvState=view.tvStateCharacter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharactersElementBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = datos[position]

        with(holder){
            tvName.text=item.name
            tvSpecie.text=item.specie
            tvGender.text=item.gender
            tvState.text=item.state
        }
    }
    override fun getItemCount(): Int = datos.size
}