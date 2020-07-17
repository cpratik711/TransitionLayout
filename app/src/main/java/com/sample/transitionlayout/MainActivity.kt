package com.sample.transitionlayout

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Pair
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cardView.setOnClickListener { view ->
            startDetailActivity()
            Log.e("called", "called");
        }
    }

    private fun startDetailActivity() {
        val intent = Intent(this, DetailActivity::class.java)

        val pairImage =
            Pair<View, String>(imageView, resources.getString(R.string.transition_image))
        val pairTitle = Pair<View, String>(tvTitle, resources.getString(R.string.transition_title))
        val pairDesc =
            Pair<View, String>(tvDescription, resources.getString(R.string.transition_body))
        val pairBack =
            Pair<View, String>(cardView, resources.getString(R.string.transition_container))

        val activityOptions = ActivityOptions.makeSceneTransitionAnimation(
            this
            , pairImage, pairTitle, pairDesc, pairImage, pairBack
        )
        startActivity(intent, activityOptions.toBundle())
    }
}