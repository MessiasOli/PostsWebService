package br.edu.ifsp.scl.ads.s5.pdm.postswebservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.scl.ads.s5.pdm.postswebservice.R
import br.edu.ifsp.scl.ads.s5.pdm.postswebservice.model.PostList

class PostAdapter(private val postList: PostList, private val onPostClickListener: OnPostClickListener): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    // ViewHolder
    inner class PostViewHolder(postView: View): RecyclerView.ViewHolder(postView) {
        val idTv: TextView = postView.findViewById(R.id.idTv)
        val titleTv: TextView = postView.findViewById(R.id.titleTv)
    }

    // Chamado pelo LayoutManager para criar uma nova View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        // Cria uma nova View
        val postView: View = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)

        // Criar e retorna um ViewHolder associado a nova View
        return PostViewHolder(postView)
    }

    // Chamado pelo ViewHolder para alterar o conteúdo de uma View
    override fun onBindViewHolder(postViewHolder: PostViewHolder, position: Int) {
        // Busca o post para pegar os valores
        val post = postList[position]

        // Seta os novos valores no ViewHolder
        postViewHolder.idTv.text = post.id.toString()
        postViewHolder.titleTv.text = post.title

        // Seta o onClickListener da View associada ao ViewHolder como uma lambda que
        // chama a função definida na interface OnPostClickListener, implementada na Activity e
        // recebida como parâmetro no construtor do Adapter. Ou seja, ao ser clicada a
        // View terá chamará a função definida na Activity passando a posição
        postViewHolder.itemView.setOnClickListener{
            onPostClickListener.onPostClick(position)
        }
    }

    // Chamado pelo LayoutManager para buscar a quantidade de dados e preparar a quantidade de Views e ViewHolders
    override fun getItemCount(): Int = postList.size
}