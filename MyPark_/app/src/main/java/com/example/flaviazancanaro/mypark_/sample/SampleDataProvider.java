package com.example.flaviazancanaro.mypark_.sample;


/**
 * Created by flaviazancanaro on 11/5/17.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import  com.example.flaviazancanaro.mypark_.model.DataItem;

public class SampleDataProvider {
    public static List<DataItem> dataItemList;
    public static Map<String, DataItem> dataItemMap;

    static {
        dataItemList = new ArrayList<>();
        dataItemMap = new HashMap<>();

        addItem(new DataItem(null, "Blaxland Riverside Park", "Playground",
                "Blaxland Riverside Park is a spectacular waterside park in Sydney located along the Parramatta River. It is open everyday of the year from sunrise to sunset.",
                1, 12, "blaxland1.jpg"));

        addItem(new DataItem(null, "Centennial Park", "Playground",
                "Located moments from the CBD and easily accessible by car or public transport, Centennial Parklands is a must see location in Sydney. Made up of three major urban parks covering 360 hectares, the Parklands are aesthetically beautiful as well as historically significant, housing Australia’s Federation monument, The Federation Pavilion.",
                2, 9, "centennial1.jpg"));

        addItem(new DataItem(null, "Pratten Park", "Playground",
                "Pratten Park is very simple in its facilities. There is a small grandstand in the north-western corner with the rest of the ground surrounded by grass hills. For several years the grandstand had fallen into disrepair and had been closed; but restoration work saw it re-opened in late 2007.",
                3, 7, "pratten1.jpg"));


        addItem(new DataItem(null, "Sydney Park", "Cycling",
                "Sydney Park Cycling Centre is located within Sydney Park next to the children's bicycle track.\n" +
                        "The foyer area, kitchenette and toilets in the centre are available for hire: Monday to Friday after 5pm, and on Saturdays and Sundays from 2.30pm until midnight.",
                4, 10, "sydneypark.jpg"));

    }

    private static void addItem(DataItem item) {
        dataItemList.add(item);
        dataItemMap.put(item.getItemId(), item);
    }


}