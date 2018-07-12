package catalog;

import java.util.List;

public class PrintedFeatures implements Feature {

    private List<String> authors;
    private int numberOfPages;
    private String title;

    public PrintedFeatures(List<String> authors, int numberOfPages, String title) {
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
