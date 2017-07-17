package edu.gsu.httpscs.finalproject.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import edu.gsu.httpscs.finalproject.R;

/**
 * Created by Tong on Jul/14/17.
 */

public class MusicService extends Service{
    public static final String PLAYING = "play";
    private final IBinder mBinder = new MusicBinder();
    MediaPlayer player;

    public MusicService() {
    }
    public class MusicBinder extends Binder {
        public MusicService getService() {
            return MusicService.this;
        }
    }
    @Override
    public IBinder onBind(Intent arg0) {
        return mBinder;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent();
        intent.setAction(PLAYING);
        intent.putExtra("MSG",PLAYING);
        sendBroadcast(intent);
        player = MediaPlayer.create(this, R.raw.bgm);
        if (player  != null) {
            player .setLooping(true);
            player .setVolume(100, 100);
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player != null) {
            try {
                player.stop();
                player.release();
            } finally {
                player = null;
            }
        }
    }
}
