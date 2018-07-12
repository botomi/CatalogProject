package catalog;

import java.util.List;

import static catalog.Validators.isBlank;
import static catalog.Validators.isEmpty;

public class PrintedFeatures implements Feature {

    private List<String> authors;
    private int numberOfPages;
    private String title;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (isEmpty(authors) || isBlank(title) || numberOfPages <= 0) {
            throw new IllegalArgumentException("Empty title");
        }
        // kivételkezelés
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public List<String> getContributors() {
        // kivételkezelés
        return authors;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
