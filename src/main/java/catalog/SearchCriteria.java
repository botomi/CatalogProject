package catalog;

public class SearchCriteria {

    private String contributor;
    private String title;

    private SearchCriteria(String contributor, String title) {
        this.contributor = contributor;
        this.title = title;
    }

    private SearchCriteria(String contributor) {
        this.contributor = contributor;
    }

    private SearchCriteria(String title) {
        this.title = title;
    }



    public static SearchCriteria createByBoth(String title, String contributor) {
        if (Validators.isBlank(title) || Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Parameter must not be null!");
        }
        return new SearchCriteria(contributor, title);
    }

    public static SearchCriteria createByContributor(String contributor){
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Parameter must not be null!");
        }


    }
}
