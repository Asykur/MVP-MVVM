package id.sekolahandroid.recyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.sekolahandroid.recyclerview.R
import id.sekolahandroid.recyclerview.model.MovieModel
import id.sekolahandroid.recyclerview.presenter.MoviePresenter
import id.sekolahandroid.recyclerview.utils.ViewMovie
import kotlinx.android.synthetic.main.activity_mvp.*

class MvpActivity : AppCompatActivity(),ViewMovie {

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        title = "Belajar Android (MVP)"

        MoviePresenter().getMovie(this, lifecycleScope,this)

    }

    override fun showLoading() {
        pgMain.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pgMain.visibility = View.GONE
    }

    override fun receiveDataMovie(movie: List<MovieModel>) {
        if ( movie.isNotEmpty()){
            adapter = MovieAdapter(movie, applicationContext)
            rvMovie.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
            rvMovie.adapter = adapter
        }
    }
}
