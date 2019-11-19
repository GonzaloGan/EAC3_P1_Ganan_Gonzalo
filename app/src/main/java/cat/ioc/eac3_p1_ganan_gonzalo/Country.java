package cat.ioc.eac3_p1_ganan_gonzalo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Country {

    private String id;
    private String name;
    private String detail;

    private static final String[] countryArray = {"Australia", "Estonia", "Chile",
            "China", "Uganda", "Congo", "Egypt", "India", "Portugal", "Russia"};

    public Country() {
    }

    public Country(String id, String name, String detail) {
        this.id = id;
        this.name = name;
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    private static String describe(String countryName) {
        return countryName;
    }

    public static List<Country> getCountryList() {
        List<Country> countryList = new ArrayList<>();
        for (int i = 0; i < countryArray.length; i++) {
            countryList.add(new Country(
                    String.valueOf(i),
                    countryArray[i],
                    describe(countryArray[i].toLowerCase())
            ));
        }
        return countryList;
    }

    public static Map<String, Country> getCountryMap() {
        Map<String, Country> countryMap = new HashMap<>();
        for (int i = 0; i < countryArray.length; i++) {
            String s = String.valueOf(i);
            countryMap.put(s, new Country(
                    s,
                    countryArray[i],
                    describe(countryArray[i].toLowerCase())
            ));
        }
        return countryMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return getId().equals(country.getId()) &&
                getName().equals(country.getName()) &&
                Objects.equals(getDetail(), country.getDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDetail());
    }

    @Override
    public String toString() {
        return name;
    }
}
