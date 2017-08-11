package com.github.unit_testing.ex.range;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class RangeTest {
    private static String range1;
    private static String range2;
    private static Range rangeClass1;
    private static Range rangeClass2;

    @BeforeClass
    public static void setupClass(){
        range1="[3,14]";
        range2="[7,18]";
    }

    @Before
    public void setup() throws IllegalArgumentException{
        this.rangeClass1= new Range(range1);
        this.rangeClass2= new Range(range2);
    }


    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowErrorSetter(){
        rangeClass2=new Range();
        rangeClass2.setRange("x");
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowErrorConstructor(){
        rangeClass2=new Range("x");
    }

    @Test
    public void shouldGetIntegerValuesInRange (){
        Assert.assertEquals(Arrays.asList(3,4,5,6,7,8,9,10,11,12,13,14),rangeClass1.integerValuesInRange());
    }


}
