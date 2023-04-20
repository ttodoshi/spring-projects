package org.todoshis;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PopMusic implements Music {
    @Override
    public List<String> getSongs() {
        return Arrays.asList("song 1", "song 2", "song 3");
    }
}
