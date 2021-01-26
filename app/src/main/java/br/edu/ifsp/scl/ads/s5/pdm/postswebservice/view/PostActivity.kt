package br.edu.ifsp.scl.ads.s5.pdm.postswebservice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.children
import br.edu.ifsp.scl.ads.s5.pdm.postswebservice.databinding.ActivityPostBinding
import br.edu.ifsp.scl.ads.s5.pdm.postswebservice.model.Post

class PostActivity : AppCompatActivity() {
    // viewBinding
    private lateinit var activityPostBinding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityPostBinding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(activityPostBinding.root)

        val post = intent.getParcelableExtra<Post>(MainActivity.POST_EXTRA)
        if (post != null) {
            with (activityPostBinding) {
                postIdTv.text = post.id.toString()
                postUserIdTv.text = post.userId.toString()
                postTitleTv.text = post.title
                postBodyTv.text = post.body
            }
        }
    }
}