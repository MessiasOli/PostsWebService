package br.edu.ifsp.scl.ads.s5.pdm.postswebservice.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.ifsp.scl.ads.s5.pdm.postswebservice.R
import br.edu.ifsp.scl.ads.s5.pdm.postswebservice.adapter.OnPostClickListener
import br.edu.ifsp.scl.ads.s5.pdm.postswebservice.adapter.PostAdapter
import br.edu.ifsp.scl.ads.s5.pdm.postswebservice.databinding.ActivityMainBinding
import br.edu.ifsp.scl.ads.s5.pdm.postswebservice.model.Post
import br.edu.ifsp.scl.ads.s5.pdm.postswebservice.model.PostList

class MainActivity : AppCompatActivity(), OnPostClickListener {
    companion object {
        const val POST_EXTRA: String = "POST_EXTRA"
    }

    // viewBinding
    private lateinit var activityMainBinding: ActivityMainBinding

    // Data source para o Adapter
    private lateinit var postList: PostList
    // Adapter do RecyclerView
    private lateinit var postAdapter: PostAdapter
    // LayoutManager para o RecyclerView
    private lateinit var postLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(activityMainBinding.root)

        // Inicializando data source do Adapter
        postList = PostList()
        for(i in 1..30) {
            val post = Post(i, i, i.toString(), i.toString())
            postList.add(post)
        }

        // Instanciando LayoutManager
        postLayoutManager = LinearLayoutManager(this)

        // Instanciando Adapter
        postAdapter = PostAdapter(postList, this)

        // Associando RecyclerView com Adapter e layoutManager
        activityMainBinding.postListRv.adapter = postAdapter
        activityMainBinding.postListRv.layoutManager = postLayoutManager
    }

    override fun onPostClick(position: Int) {
        // Mostrar post completo em uma nova Activity
        val postIntent = Intent(this, PostActivity::class.java)
        postIntent.putExtra(POST_EXTRA, postList[position])
        startActivity(postIntent)
    }
}