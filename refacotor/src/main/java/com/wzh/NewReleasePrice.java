package com.wzh;

public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
    public double getCharge( int daysRented ) {
        return daysRented * 3;
    }
    public   double getFrequencyRentalPoint( int daysRented ) {
        return daysRented > 1 ? 2:1;

    }
}
