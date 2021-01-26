package br.edu.ifsp.scl.ads.s5.pdm.postswebservice.adapter

// Interface que será implementada na Activity para tratar os eventos de clique
// e usada no Adapter para tratar os eventos de clique no Post
interface OnPostClickListener {
    fun onPostClick(position: Int)
}