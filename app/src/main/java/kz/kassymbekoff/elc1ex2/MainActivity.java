package kz.kassymbekoff.elc1ex2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import kz.kassymbekoff.elc1ex2.storage.SearchCompanies;
import kz.kassymbekoff.elc1ex2.storage.SharedPreferencesHelper;
import kz.kassymbekoff.elc1ex2.views.SearchFragment;
import kz.kassymbekoff.elc1ex2.views.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(this);
        if(sharedPreferencesHelper.getSelectedSystem() == null){
            sharedPreferencesHelper.addChecked(SearchCompanies.getDefaultCompany());
        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.getBackStackEntryCount() == 1){
            finish();
        }else {
            fragmentManager.popBackStack();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionLogout:
                finish();
                break;
            case R.id.actionSearch:
                Fragment searchFragment = new SearchFragment();
                changePage(searchFragment);
                break;
            case R.id.actionSettings:
                Fragment settingsFragment = new SettingsFragment();
                changePage(settingsFragment);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void changePage(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment)
                .addToBackStack(fragment.getClass().getName()).commit();
    }
}
