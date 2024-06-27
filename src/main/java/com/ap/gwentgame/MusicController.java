package com.ap.gwentgame;

import com.ap.gwentgame.enums.assets.Musics;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicController {

    private static MusicController instance = null;
    private MediaPlayer mediaPlayer;
    private Media music;
    private boolean isMuted = false;

    private MusicController() {
        music = Musics.STARTINGMUSIC.getMusic();
        mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void play() {
        mediaPlayer.play();
    }

    public static MusicController getInstance() {
        if (instance == null) {
            instance = new MusicController();
        }
        return instance;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}
