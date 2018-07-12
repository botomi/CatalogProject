package catalog;

import java.util.ArrayList;
import java.util.List;

import static catalog.Validators.isBlank;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int pageNumber) {


        return 0.0;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        if (isBlank(registrationNumber)) {
            throw new IllegalArgumentException("Registration number must not be empty or null!");
        }
        CatalogItem tmp = null;
        for (CatalogItem catalogItem: catalogItems) {
            if (catalogItem.getRegistrationNumber.equals(registrationNumber)) {
                tmp = catalogItem;
            }
        }
        if (tmp == null) {
            throw new IllegalArgumentException("Registration number not found!");
        }



//        return getRegistrationNumber;
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {




        return null;
    }

    public int getAllPageNumber() {
        int sum = 0;
        for (CatalogItem catalogItem: getPrintedLibraryItems()) {
            sum += catalogItem.numberOfPagesAtOneItem();
        }
        return sum;
    }

    public List<CatalogItem> getAudioLibraryItems() {




        return null;
    }

    public int getFullLength() {
        int sum = 0;
        for (CatalogItem catalogItem: getAudioLibraryItems()) {
            sum += catalogItem.fullLengthAtOneItem();
        }
        return sum;
    }

    public List<CatalogItem> getPrintedLibraryItems() {




        return null;
    }













}
