package cat.ioc.eac3_p1_ganan_gonzalo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.CollapsingToolbarLayout;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link CountyListActivity}
 * in two-pane mode (on tablets) or a {@link CountryDetailActivity}
 * on handsets.
 */
public class CountryDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";


    private Country country;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CountryDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        assert getArguments() != null;
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            country = Country.getCountryMap().get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            assert activity != null;
            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(country.getName());
            }
        }
    }

    // no se me esta ocurrin com millorar aixo :'(
    // https://stackoverflow.com/questions/29541914/using-string-from-resource-xml-in-switch
    // https://stackoverflow.com/questions/7493287/android-how-do-i-get-string-from-resources-using-its-name
    private String getCountryDetailFromResource(String countryName) {
        if ("Australia".equals(countryName)) {
            return getResources().getString(R.string.australia_detail);
        } else if ("Estonia".equals(countryName)) {
            return getResources().getString(R.string.estonia_detail);
        } else if ("Chile".equals(countryName)) {
            return getResources().getString(R.string.chile_detail);
        } else if ("China".equals(countryName)) {
            return getResources().getString(R.string.china_detail);
        } else if ("Uganda".equals(countryName)) {
            return getResources().getString(R.string.uganda_detail);
        } else if ("Congo".equals(countryName)) {
            return getResources().getString(R.string.congo_detail);
        } else if ("Egypt".equals(countryName)) {
            return getResources().getString(R.string.egypt_detail);
        } else if ("India".equals(countryName)) {
            return getResources().getString(R.string.india_detail);
        } else if ("Portugal".equals(countryName)) {
            return getResources().getString(R.string.portugal_detail);
        } else if ("Russia".equals(countryName)) {
            return getResources().getString(R.string.russia_detail);
        }
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.country_detail, container, false);

        if (country != null) {
            ((TextView) rootView.findViewById(R.id.country_detail)).setText(getCountryDetailFromResource(country.getName()));
        }
        return rootView;
    }
}
