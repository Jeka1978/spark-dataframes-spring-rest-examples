package ru.jug.jpoint.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Evegeny on 20/04/2016.
 */
@Component
public class UserConfig implements Serializable{
    public List<String> garbage;

    @Value("${garbage}")
    private void setGarbage(String[] garbage) {
        this.garbage = Arrays.asList(garbage);
    }
}
