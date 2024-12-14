package com.example.mymusicapp

import android.content.Context
import android.media.browse.MediaBrowser.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.mymusicapp.models.SongModel

object MyExoplayer {
    
    private  var exoplayer:ExoPlayer ? =null
    private var currentSong:SongModel?=null
    
    fun getInstance():ExoPlayer?{
        return exoplayer
    }
    
    fun startPlaying(context: Context , song : SongModel){
        if(exoplayer==null)
            exoplayer = ExoPlayer.Builder(context).build()
        
        currentSong =song
        currentSong?.url.apply { 
            //val mediaItem=MediaItem.fromUri(this)
        }
            
        
    }
}