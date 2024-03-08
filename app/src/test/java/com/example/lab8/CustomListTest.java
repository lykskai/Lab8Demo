package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>()); return list;
    }

    /**
     * LAB 8 DEMO
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }


    /**
     * LAB 8 IMPLEMENTATION
     * 1)  Make a mock city list
     * 2)  Make two new cities
     * 3)  Only add cityToAdd
     * 4) assert true if cityToAdd is in the list, assert false if cityNotAdded is in the list
     */

    @Test
    void hasCityTest() {
        // Make a mock city
        list = MockCityList();



        // make the cities
        City cityToAdd = new City("Yellowknife", "Northwest Territories");
        City cityNotAdded = new City("City", "Province");

        // add only one
        list.addCity(cityToAdd);
        assertTrue(list.hasCity(cityToAdd)); // should be true
        assertFalse(list.hasCity(cityNotAdded)); // should be false
    }


}
