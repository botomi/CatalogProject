package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private List<String> composer;
    private int length;
    private List<String> performers;
    private String title;

    public AudioFeatures(String title, int length, List<String> performers) {
        if (Validators.isBlank(title) || length <= 0 || Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("Empty title");
        }
        this.performers = performers;
        this.length = length;
        this.title = title;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        if (Validators.isBlank(title) || length <= 0 || Validators.isEmpty(performers) || Validators.isEmpty(composer)) {
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
        if (!Validators.isEmpty(composer)) {
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
