package kz.kassymbekoff.elc1ex2.views;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import kz.kassymbekoff.elc1ex2.R;
import kz.kassymbekoff.elc1ex2.storage.SearchCompanies;
import kz.kassymbekoff.elc1ex2.storage.SharedPreferencesHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    private SharedPreferencesHelper sharedPreferencesHelper;

    public SettingsFragment() {
        // Required empty public constructor
    }

    private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
            switch (checkId){
                case R.id.googleRB:
                    sharedPreferencesHelper.addChecked(SearchCompanies.GOOGLE);
                    showConfirmationMessage(SearchCompanies.GOOGLE);
                    break;
                case R.id.yandexRB:
                    sharedPreferencesHelper.addChecked(SearchCompanies.YANDEX);
                    showConfirmationMessage(SearchCompanies.YANDEX);
                    break;
                case R.id.bingRB:
                    sharedPreferencesHelper.addChecked(SearchCompanies.BING);
                    showConfirmationMessage(SearchCompanies.BING);
                    break;
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        sharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

        RadioGroup settingsGP = view.findViewById(R.id.searchRG);
        settingsGP.setOnCheckedChangeListener(listener);
        RadioButton googleRB              = view.findViewById(R.id.googleRB);
        RadioButton yandexRB              = view.findViewById(R.id.yandexRB);
        RadioButton bingRB                = view.findViewById(R.id.bingRB);

        String selected = sharedPreferencesHelper.getSelectedSystem();
        if(selected != null){
            if(selected.equals(SearchCompanies.GOOGLE)){
                googleRB.setChecked(true);
            }else if(selected.equals(SearchCompanies.YANDEX)){
                yandexRB.setChecked(true);
            }else if(selected.equals(SearchCompanies.BING)){
                bingRB.setChecked(true);
            }
        }
        return view;
    }

    private void showConfirmationMessage(String companyName){
        Toast.makeText(getActivity(), "Выбран поиск по умолчанию - " + companyName, Toast.LENGTH_SHORT).show();
    }
}
