package id.sekolahandroid.recyclerview.viewmodel

import android.app.Application
import androidx.lifecycle.*
import id.sekolahandroid.recyclerview.R
import id.sekolahandroid.recyclerview.model.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private var movieData: MutableLiveData<ArrayList<MovieModel>>? = null
    // Flag untuk menampilkan progressbar (loading)
    private val loading = MutableLiveData<Boolean>()

    fun loadMovie(application: Application) {
        if (movieData == null) {
            movieData = MutableLiveData<ArrayList<MovieModel>>()
            loading.value = true // UI Thread
            viewModelScope.launch(Dispatchers.IO) {
                delay(2000)
                val titles = application.resources.getStringArray(R.array.titles)
                val images = application.resources.getStringArray(R.array.images)
                val overView = application.resources.getStringArray(R.array.overview)
                val vote = application.resources.getStringArray(R.array.vote_average)

                val movieList = ArrayList<MovieModel>()
                for (index in titles.indices) {
                    val movie = MovieModel(
                        titles[index],
                        images[index],
                        overView[index],
                        vote[index]
                    )
                    movieList.add(movie)
                    movieData?.postValue(movieList) // Background Thread
                }
                loading.postValue(false)
            }
        }
    }

    fun getMovie(): LiveData<ArrayList<MovieModel>>? {
        return movieData
    }

    fun isLoading(): LiveData<Boolean> {
        return loading
    }
}