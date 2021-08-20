package me.ltxom.patientapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import me.ltxom.patientapp.Adapter.AdapterClass;
import me.ltxom.patientapp.service.PatientService;

public class SearchPage extends AppCompatActivity {
    ListView list;
    SearchView editsearch;
    AdapterClass adapter;
    ArrayList<SearchQuery> arraylist = new ArrayList<SearchQuery>();

    PatientService mPatientService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);
        mPatientService = new PatientService();

        list = findViewById(R.id.list_view);
        editsearch = findViewById(R.id.search_view);
        editsearch.setFocusable(true);
        editsearch.setIconified(false);
        editsearch.requestFocusFromTouch();

        for (LinkedTreeMap p : mPatientService.listPatients()) {
            SearchQuery searchQuery1 = new SearchQuery(p.get("firstName") + " " + p.get("lastName") + ":" + p.get("email") + ":" + p.get("icon"));
            // Binds all strings into an array
            arraylist.add(searchQuery1);
        }
        adapter = new AdapterClass(this, arraylist);
        list.setAdapter(adapter);
        editsearch = findViewById(R.id.search_view);
        editsearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String text = newText;
                adapter.filter(text);
                return false;
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
