package br.edu.ifsp.scl.ads.s5.pdm.postswebservice.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    var userId: Int?,
    var id: Int?,
    var title: String?,
    var body: String?
): Parcelable