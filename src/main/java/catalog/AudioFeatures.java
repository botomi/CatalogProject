package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private List<String> composer;
    private int length;
    private List<String> performers;
    private String title;

    public AudioFeatures(List<String> composer, int length, String title) {
        // kivételkezelés
        this.composer = composer;
        this.length = length;
        this.title = title;
    }

    public AudioFeatures(List<String> composer, int length, List<String> performers, String title) {
        // kivételkezelés
        this.composer = composer;
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    @Override
    public List<String> getContributors() {
        // kivételkezelés
        List<String> contributors = new ArrayList<>(composer);
        contributors.addAll(performers);
        return contributors;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
