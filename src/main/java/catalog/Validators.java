package catalog;

import java.util.List;

public class Validators {

    public static boolean isBlank(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(List<Object> list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }
}
