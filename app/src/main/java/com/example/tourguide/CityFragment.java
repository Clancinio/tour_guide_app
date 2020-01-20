package com.example.tourguide;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CityFragment<FragmentActionListener> extends Fragment {

    View view;
    String[] cities;
    String[] descriptions;
    ListView listView;
    DescriptionFragment text;
    int mPosition;


    public CityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Get views
        this.view = inflater.inflate(R.layout.fragment_city, container, false);
        cities = getResources().getStringArray(R.array.cities);
        descriptions = getResources().getStringArray(R.array.cities_description);
        listView = this.view.findViewById(R.id.city_list);

        // Create an ArrayAdapter
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, cities);

        // Set adapter on the listView
        listView.setAdapter(listViewAdapter);

        // Set an item click listener for ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                text = (DescriptionFragment) getFragmentManager().findFragmentById(R.id.fragmentBottom);
                text.change(descriptions[Integer.parseInt(String.valueOf(position))], cities[Integer.parseInt(String.valueOf(position))]);
                mPosition = position;
            }
        });

        // Inflate the layout for this fragment
        return this.view;

    }

}

