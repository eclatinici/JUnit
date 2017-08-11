package com.github.unit_testing.ex.range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Task implement and test a Range that accepts a string representing a numeric range
 * that may have an inclusive or exclusive start and end range value
 *
 * 1) Input and validation of a range
 * 2) Return all the integer values in that range
 * 3) Check Range inclusion:
 *          * [3,5] contains [3,5)
 *          * [2,5) does not contain [3,6)
 * 4) Check if individual numbers are within the range
 * 5) Check if two ranges are equal
 * 6) Union and Intersection of two ranges
 */
public class Range {

    private String range;

    private boolean validateRange(String range){
        String regex="[(\\[](-?[0-9]+),(-?[0-9]+)[)\\]]";
        return range.matches(regex);
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) throws IllegalArgumentException{
        if(validateRange(range))
            this.range = range;
        else
            throw new IllegalArgumentException("mai incearca");
    }

    public Range(){}

    public Range(String range)throws IllegalArgumentException {
        if(validateRange(range))
            this.range=range;
        else
            throw new IllegalArgumentException("vezi ca nu e bine");
    }

    private int getFirstInt(){
        switch (this.range.charAt(0)) {
            case '(':return Integer.parseInt(this.range.substring(this.range.indexOf('(')+1,this.range.indexOf(',')))+1;
            case '[':return Integer.parseInt(this.range.substring(this.range.indexOf('[')+1,this.range.indexOf(',')));
            default: return 0;
        }
    }

    private int getSecondInt(){
        switch (this.range.charAt(4)){
            case ')':return Integer.parseInt(this.range.substring(this.range.indexOf(')')+1,this.range.indexOf(',')))-1;
            case ']':return Integer.parseInt(this.range.substring(this.range.indexOf(']')+1,this.range.indexOf(',')));
            default:return 0;
        }
    }

    public List<Integer> integerValuesInRange()
    {
        List<Integer> integers=new ArrayList<>();
        for(int i=getFirstInt();i<=getSecondInt();i++)
            integers.add(i);
        return integers;
    }

    private boolean containsLowerBoundary(Range range2){
        return (getFirstInt() < range2.getFirstInt() ||
                (getFirstInt()==range2.getFirstInt() &&
                        this.range.substring(0,1).equals("[")));
    }

    private boolean containsUpperBoundary(Range range2){
        return (getSecondInt()>range2.getSecondInt() ||
                (getSecondInt()==range2.getSecondInt() &&
                this.range.substring(this.range.length()-1,this.range.length()).equals("]")));
    }

    public boolean isInRange(Range range2){
        return containsLowerBoundary(range2) && containsUpperBoundary(range2);
    }

    public boolean isInRange(int i){
        return (getFirstInt() <= i) && (getSecondInt() >= i);
    }

    public boolean areEqual(Range range2){
        return (getFirstInt() == range2.getFirstInt()) && (getSecondInt() == range2.getSecondInt());
    }

    public List<Integer> unionIntegers(Range range2){
        List<Integer> list=new ArrayList<>();
        for(int i=getFirstInt();i<=getSecondInt();i++)
            list.add(i);
        for(int i=range2.getFirstInt(); i<=range2.getSecondInt();i++)
            if(!list.contains(i))
                list.add(i);
        return list;

    }

}
