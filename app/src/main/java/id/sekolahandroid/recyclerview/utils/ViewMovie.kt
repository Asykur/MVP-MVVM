package id.sekolahandroid.recyclerview.utils

import id.sekolahandroid.recyclerview.model.MovieModel

interface ViewMovie {
    fun showLoading()
    fun hideLoading()
    fun receiveDataMovie(movie: List<MovieModel>)
}