package com.example.mymusicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.databinding.ActivitySongListBinding
import com.example.mymusicapp.adapter.SongListAdapter
import com.example.mymusicapp.models.CategaryModel

class SongList : AppCompatActivity() {

    companion object{
        lateinit var category: CategaryModel
    }

    lateinit var binding: ActivitySongListBinding
    lateinit var songListAdapter: SongListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySongListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nameTextView.text= category.name

        Glide.with(binding.coverImageView).load(category.coverUrl)
            .apply(
                RequestOptions().transform(RoundedCorners(32))
            )
            .into(binding.coverImageView)

        setupSongRecyclerView()
    }

    fun setupSongRecyclerView(){
        songListAdapter= SongListAdapter(category.song)
        binding.songsListRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.songsListRecyclerView.adapter=songListAdapter
    }
}