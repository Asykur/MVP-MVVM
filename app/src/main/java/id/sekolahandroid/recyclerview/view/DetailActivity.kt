package id.sekolahandroid.recyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import id.sekolahandroid.recyclerview.R
import id.sekolahandroid.recyclerview.model.MovieModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle = intent.extras
        if (bundle != null){
            // get movie data from MainActivity
            val movie = bundle.getParcelable<MovieModel>(MainActivity.DATA_MOVIE)
            Glide.with(this).load(movie?.image).into(imgMovieDetail)
            tvOverviewDetail.text = movie?.overview
            tvVote.text = movie?.vote_average

            // set Toolbar title
            title = movie?.title
        }
    }
}
