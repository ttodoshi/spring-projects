package org.todoshis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MusicPlayer {
    private Music music1;
    private Music music2;
    private Music music3;
    private byte volume = 50;

    public void playMusic(MusicGenre genre) {
        this.getMusic(genre).getSongs().forEach(System.out::println);
    }

    public byte getVolume() {
        return volume;
    }

    @Value("${musicPlayer.volume}")
    public void setVolume(byte volume) {
        this.volume = volume;
    }

    public Music getMusic(MusicGenre genre) {
        switch (genre) {
            case POP:
                return music1;
            case CLASSICAL:
                return music2;
            case ROCK:
                return music3;
            default:
                return null;
        }
    }

    @Autowired
    public void setMusic(@Qualifier("popMusic") Music music1, @Qualifier("classicalMusic") Music music2, @Qualifier("rockMusic") Music music3) {
        this.music1 = music1;
        this.music2 = music2;
        this.music3 = music3;
    }
}
