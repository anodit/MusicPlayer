package com.example.mahit.musicplayer;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button play,pause,stop;
    MediaPlayer mMediaPlayer;
    int currentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play=(Button)findViewById(R.id.play);
        Button pause=(Button)findViewById(R.id.pause);
        Button stop=(Button)findViewById(R.id.stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.play:
                if(mMediaPlayer==null) {
                    mMediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.song);
                    mMediaPlayer.start();
                }
                else if(!mMediaPlayer.isPlaying()){
                    mMediaPlayer.seekTo(currentPosition);
                    mMediaPlayer.start();
                }
                break;
            case R.id.pause:
                if(mMediaPlayer!=null){
                    mMediaPlayer.pause();
                    currentPosition=mMediaPlayer.getCurrentPosition();
                }
                break;
            case R.id.stop:
                if(mMediaPlayer!=null){
                    mMediaPlayer.stop();
                    mMediaPlayer=null;
                }
                break;
        }
    }
}
