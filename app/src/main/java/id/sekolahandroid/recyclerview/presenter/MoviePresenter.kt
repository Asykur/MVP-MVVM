package id.sekolahandroid.recyclerview.presenter

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import id.sekolahandroid.recyclerview.model.MovieModel
import id.sekolahandroid.recyclerview.R
import id.sekolahandroid.recyclerview.utils.ViewMovie
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MoviePresenter {

    fun getMovie(context: Context, lifecycleScope: LifecycleCoroutineScope, view: ViewMovie){
        view.showLoading()
        val movieList = ArrayList<MovieModel>()
        lifecycleScope.async {
            delay(2000)
            val titles = context.resources.getStringArray(R.array.titles)
            val images = context.resources.getStringArray(R.array.images)
            val overView = context.resources.getStringArray(R.array.overview)
            val vote = context.resources.getStringArray(R.array.vote_average)

            for (index in titles.indices){
                val movie = MovieModel(
                    titles[index],
                    images[index],
                    overView[index],
                    vote[index]
                )
                movieList.add(movie)
            }
            view.hideLoading()
            view.receiveDataMovie(movieList)
        }
    }
}