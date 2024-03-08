package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    // Lab 8: add method from the demo

    /**
     * Adds a city object to the list
     * @param city
     */

    public void addCity(City city){
        cities.add(city);
    }

    //Lab 8 implementation
    /**
     * This checks if a city is present in the cityList
     * @param city
     * @return true If city is present, false if city is absent.
     */
    public boolean hasCity(City city) {

        // Iterate through city list, see if there are matches

        for (City iteratedCity : cities) {
            if (city.getCityName().equals(iteratedCity.getCityName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This deletes a city from the list, as long as the city exists.
     * @param city to delete
     @throws IllegalArgumentException If the city to be deleted does not exist
     */
    public void deleteCity(City city) {
        if (cities.contains(city)) {
            // delete
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This will return a count of how many cities are in the list.
     * @return integer, representing the amount of cities in the list
     */
    public int countCities() {}
}
