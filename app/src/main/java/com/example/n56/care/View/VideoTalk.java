package com.example.n56.care.View;

import android.content.Context;
import android.media.AudioManager;
import android.os.Message;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.n56.care.R;
import com.example.n56.care.Util.GifMovieView;

public class VideoTalk extends BaseActivity {

    private String name;
    private int head;
    private TextView videoTalkTitle;
    private GifMovieView videoTalkHead;
    private GifMovieView videoTalkMe;
    private SeekBar volumeBar;
    private TextView volumeText;
    private boolean isStartTrackingTouch;
    public AudioManager audiomanage;
    private int maxVolume, currentVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_talk);

        init();

        Bundle bundle = getIntent().getExtras();
        name = (String)bundle.get("name");
        head = (int)bundle.get("head");

        if(name!=null) {
            videoTalkTitle.setText(name);
            //videoTalkHead.setImageResource(head);
        }

        //final GifMovieView videoTalkHead = (GifMovieView) findViewById(R.id.VideoTalkHead);
        //videoTalkHead.setScaleX();
        videoTalkHead.setMovieResource(R.raw.w4);
        videoTalkMe.setMovieResource(R.raw.w3);
        // 进度条监听器
        volumeBar.setOnSeekBarChangeListener(new MySeekBarListener());

        getFragmentManager()
                .beginTransaction()
                .add(R.id.ring_holder, new Ring())
                .commit();
    }

    public void init(){
        videoTalkTitle = (TextView)findViewById(R.id.VideoTalkTitle);
        videoTalkHead = (GifMovieView)findViewById(R.id.VideoTalkHead);
        videoTalkMe = (GifMovieView)findViewById(R.id.VideoTalkMe);
        volumeBar = (SeekBar) findViewById(R.id.videoSeekBar);
        volumeText = (TextView) findViewById(R.id.videoVolumeText);
        audiomanage = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        maxVolume = audiomanage.getStreamMaxVolume(AudioManager.STREAM_MUSIC);  //获取系统最大音量
        volumeBar.setMax(maxVolume);   //拖动条最高值与系统最大声匹配
        currentVolume = audiomanage.getStreamVolume(AudioManager.STREAM_MUSIC);  //获取当前值
        volumeBar.setProgress(currentVolume);
        volumeText.setText(currentVolume*100/maxVolume + " %");
    }
    /*
         * 进度条监听器
         */
    private final class MySeekBarListener implements SeekBar.OnSeekBarChangeListener {
        // 移动触发
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            audiomanage.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            currentVolume = audiomanage.getStreamVolume(AudioManager.STREAM_MUSIC);  //获取当前值
            volumeBar.setProgress(currentVolume);

            volumeText.setText(currentVolume*100/maxVolume + " %");
        }

        // 起始触发
        public void onStartTrackingTouch(SeekBar seekBar) {
            isStartTrackingTouch = true;
        }

        // 结束触发
        public void onStopTrackingTouch(SeekBar seekBar) {
            isStartTrackingTouch = false;
        }
    }

    @Override
    public void processMessage(Message message) {

    }
}
