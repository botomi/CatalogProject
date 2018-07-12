package catalog;

import java.util.ArrayList;
import java.util.List;

import static catalog.Validators.isBlank;
import static catalog.Validators.isEmpty;

public class AudioFeatures implements Feature {

    private List<String> composer;
    private int length;
    private List<String> performers;
    private String title;

    public AudioFeatures(String title, int length, List<String> performers) {
        if (isBlank(title) || length <= 0 || isEmpty(performers)) {
            throw new IllegalArgumentException("Empty title");
        }
        this.performers = performers;
        this.length = length;
        this.title = title;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        if (isBlank(title) || length <= 0 || isEmpty(performers) || isEmpty(composer)) {
            throw new IllegalArgumentException("Empty title");
        }
        this.composer = composer;
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        if (!isEmpty(composer)) {
            contributors.addAll(composer);
        }
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
