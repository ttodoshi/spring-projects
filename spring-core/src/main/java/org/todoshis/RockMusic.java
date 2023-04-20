package org.todoshis;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RockMusic implements Music{
    @Override
    public List<String> getSongs() {
        return Arrays.asList("rock 1", "rock 2", "rock 3");
    }
}
