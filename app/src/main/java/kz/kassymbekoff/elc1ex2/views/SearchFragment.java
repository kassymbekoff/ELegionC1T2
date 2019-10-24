package kz.kassymbekoff.elc1ex2.views;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import kz.kassymbekoff.elc1ex2.R;
import kz.kassymbekoff.elc1ex2.storage.SearchCompanies;
import kz.kassymbekoff.elc1ex2.storage.SharedPreferencesHelper;

public class SearchFragment extends Fragment {

    private EditText contentET;
    private SharedPreferencesHelper sharedPreferencesHelper;
    public SearchFragment() {
        // Required empty public constructor
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(contentET != null && !TextUtils.isEmpty(contentET.getText().toString().trim())){
                String searchSystem = sharedPreferencesHelper.getSelectedSystem();
                String url = "";
                if(searchSystem.equals(SearchCompanies.GOOGLE)){
                    url = "https://www.google.ru/search?q=";
                }else if(searchSystem.equals(SearchCompanies.BING)){
                    url = "https://www.bing.com/search?q=";
                }else if(searchSystem.equals(SearchCompanies.YANDEX)){
                    url = "https://yandex.kz/search/?text=";
                }

                if(!url.equals("")){
                    Intent searchIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url + contentET.getText().toString()));
                    startActivity(searchIntent);
                }
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        sharedPreferencesHelper = new SharedPreferencesHelper(getActivity());
        Button button = view.findViewById(R.id.searchBtn);
        contentET = view.findViewById(R.id.contentET);
        button.setOnClickListener(onClickListener);
        return view;
    }
}
