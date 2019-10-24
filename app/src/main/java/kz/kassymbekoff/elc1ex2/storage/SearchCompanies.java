package kz.kassymbekoff.elc1ex2.storage;

import java.util.Arrays;
import java.util.List;

public class SearchCompanies {
    public static final String GOOGLE = "Google";
    public static final String YANDEX = "Яндекс";
    public static final String BING = "Bing";
    private static List<String> companies = Arrays.asList(GOOGLE, YANDEX, BING);

    public static String getDefaultCompany(){
        return companies.get(0);
    }
}
