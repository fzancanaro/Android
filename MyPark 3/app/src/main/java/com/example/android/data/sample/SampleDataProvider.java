package com.example.android.data.sample;

import com.example.android.data.model.DataItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDataProvider {
    public static List<DataItem> dataItemList;
    public static Map<String, DataItem> dataItemMap;

    static {
        dataItemList = new ArrayList<>();
        dataItemMap = new HashMap<>();

        addItem(new DataItem(null, "Blaxland Riverside Park", "Playground",
                "Blaxland Riverside Park is a spectacular waterside park in Sydney located along the Parramatta River. It is open everyday of the year from sunrise to sunset.",
                1, 12, "blaxland.jpg"));

        addItem(new DataItem(null, "Centennial Park", "Playground",
                "Located moments from the CBD and easily accessible by car or public transport, Centennial Parklands is a must see location in Sydney. Made up of three major urban parks covering 360 hectares, the Parklands are aesthetically beautiful as well as historically significant, housing Australia’s Federation monument, The Federation Pavilion.",
                2, 9, "centennial.jpg"));

        addItem(new DataItem(null, "Pratten Park", "Playground",
                "Pratten Park is very simple in its facilities. There is a small grandstand in the north-western corner with the rest of the ground surrounded by grass hills. For several years the grandstand had fallen into disrepair and had been closed; but restoration work saw it re-opened in late 2007.",
                3, 7, "pratten.jpg"));

        addItem(new DataItem(null, "Redfern Park", "Playground",
                "The aim of the oval refurbishment was to provide sporting, athletic and recreational opportunities for a broad range of community, school and sporting groups.",
                4, 10, "redfern.jpg"));

        addItem(new DataItem(null, "Tumbalong Park", "Playground",
                "The Darling Quarter Kids Playground is one of the most spectacular ever built in Australia, featuring an array of fun activities that promote learning and imagination for all ages. Water games, climbing ropes, swings, slides, and a flying fox will keep the kids entertained for hours. And best of all, it’s free!",
                1, 8, "tumbalong.jpg"));

        addItem(new DataItem(null, "Bicentennial Park", "Cycling",
                "Bicentennial Park is a diverse natural asset combining the Badu Mangroves wetlands on Homebush Bay with 40 hectares of beautiful parklands in Sydney featuring gentle hills, lakeside meadows and soothing green vistas.",
                2, 7, "bicentennial.JPG"));

        addItem(new DataItem(null, "Centennial Parklands", "Cycling",
                "Centennial Parklands is one of the most cycling-friendly public spaces in Sydney, with over 750,000 cycling visits made each year (and growing).",
                3, 7, "parklands.jpg"));

        addItem(new DataItem(null, "Narrabeen Lagoon Trail", "Cycling",
                "The Narrabeen Lagoon Trail has opened, providing an iconic tourist facility for the northern beaches with maximum accessibility and minimum disruption to the environment.",
                4, 9, "narrabeen.jpg"));

        addItem(new DataItem(null, "Blue Montains National Park", "Cycling",
                "An exhilarating cycling route along a peninsula, Narrow Neck trail offers walking options and scenic views across Blue Mountains National Park, near Katoomba.",
                5, 8, "narrow.jpg"));

        addItem(new DataItem(null, "Prince Alfred Park", "Swimming",
                "Set in the heart of Sydney next to Central train station, Prince Alfred Park Pool is the ideal location for you to relax and recharge your batteries. This iconic facility offers a state of the art 50m lap pool, toddlers splash pad and a large shaded area.",
                1, 10, "princepark.jpg"));

        addItem(new DataItem(null, "Victoria Park", "Swimming",
                "Victoria Park Pool (VPP) is an oasis in the middle of a tranquil, nine-hectare park (itself a big drawcard). As well as an old-school outdoor pool the centre boasts a fitness centre and popular cafe.",
                2, 14, "victoriapool.jpg"));

        addItem(new DataItem(null, "Icebergs", "Swimming",
                "Undeniably the best place to see the spectacular views of Bondi Beach, Icebergs has been around almost one hundred years and has become a Sydney institution.",
                3, 10, "icebergs.jpg"));

        addItem(new DataItem(null, "Prince Alfred Park Pool", "Swimming",
                "For the carless locals of inner Sydney who can't quite make it to the coast for a swim, Prince Alfred Park Pool is known as 'Redfern Beach'.",
                4, 10, "princepool.jpg"));

    }

    private static void addItem(DataItem item) {
        dataItemList.add(item);
        dataItemMap.put(item.getItemId(), item);
    }

}
