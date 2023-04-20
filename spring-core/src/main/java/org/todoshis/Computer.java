package org.todoshis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private final MusicPlayer musicPlayer;

    @Autowired
    public Computer(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    public void playMusic(MusicGenre genre) {
        musicPlayer.playMusic(genre);
    }

    @Override
    public String toString() {
        return "Computer " + super.toString() + "is working on " + musicPlayer.getVolume() + " volume";
    }
}
