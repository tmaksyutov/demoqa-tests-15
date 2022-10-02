package com.demoqa.utils;

import java.util.Random;

public enum  Month {
    January, February, March, April,
    May, June, July, August,
    September, October, November, December;

    public static Month getRandomMonth(){
        int picture = new Random().nextInt(Month.values().length);
        return Month.values()[picture];
    }

}
