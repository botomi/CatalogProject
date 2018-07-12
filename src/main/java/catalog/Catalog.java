package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        if (catalogItem == null) {
            throw new IllegalArgumentException("Catalog item must not be null!");
        }
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int pageNumber) {
        if (pageNumber <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        int sum = 0;
        int count = 0;
        for (CatalogItem catalogItem: getPrintedLibraryItems()) {
            if (catalogItem.numberOfPagesAtOneItem() > pageNumber) {
                sum += catalogItem.numberOfPagesAtOneItem();
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("No page");
        }
        return sum / count;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        if (Validators.isBlank(registrationNumber)) {
            throw new IllegalArgumentException("Registration number must not be empty or null!");
        }
        CatalogItem tmp = null;
        for (CatalogItem catalogItem: catalogItems) {
            if (catalogItem.getRegistrationNumber().equals(registrationNumber)) {
                tmp = catalogItem;
            }
        }
        if (tmp == null) {
            throw new IllegalArgumentException("Registration number not found!");
        }
        catalogItems.remove(tmp);
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        if (searchCriteria == null) {
            throw new IllegalArgumentException("Search criteria must not be null!");
        }
        List<CatalogItem> results = new ArrayList<>();
        if (searchCriteria.hasContributor() && searchCriteria.hasTitle()) {
            for (CatalogItem catalogItem: catalogItems) {
                for (Feature feature: catalogItem.getFeatures()) {
                    if (feature.getContributors().contains(searchCriteria.getContributor()) && searchCriteria.getTitle().equals(feature.getTitle())) {
                        results.add(catalogItem);
                        break;
                    }
                }
            }
        } else if (searchCriteria.hasContributor()) {
            for (CatalogItem catalogItem: catalogItems) {
                for (Feature feature: catalogItem.getFeatures()) {
                    if (feature.getContributors().contains(searchCriteria.getContributor())) {
                        results.add(catalogItem);
                        break;
                    }
                }
            }
        } else {
            for (CatalogItem catalogItem: catalogItems) {
                for (Feature feature: catalogItem.getFeatures()) {
                    if (searchCriteria.getTitle().equals(feature.getTitle())) {
                        results.add(catalogItem);
                        break;
                    }
                }
            }
        }
        if (results.size() == 0) {
            throw new IllegalArgumentException("Not found!");
        }
        return results;
    }

    public int getAllPageNumber() {
        if (catalogItems.size() == 0) {
            return 0;
        }
        int sum = 0;
        for (CatalogItem catalogItem: getPrintedLibraryItems()) {
            sum += catalogItem.numberOfPagesAtOneItem();
        }
        return sum;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioLibraryItems = new ArrayList<>();
        for (CatalogItem catalogItem: catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                audioLibraryItems.add(catalogItem);
            }
        }
        return audioLibraryItems;
    }

    public int getFullLength() {
        if (catalogItems.size() == 0) {
            return 0;
        }
        int sum = 0;
        for (CatalogItem catalogItem: getAudioLibraryItems()) {
            sum += catalogItem.fullLengthAtOneItem();
        }
        return sum;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedLibraryItems = new ArrayList<>();
        for (CatalogItem catalogItem: catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                printedLibraryItems.add(catalogItem);
            }
        }
        return printedLibraryItems;
    }
}
