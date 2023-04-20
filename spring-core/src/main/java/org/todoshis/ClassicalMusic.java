package org.todoshis;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ClassicalMusic implements Music {
    @Override
    public List<String> getSongs() {
        return Arrays.asList("classical 1", "classical 2", "classical 3");
    }
}
