package com.wzh;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie _movie, int _daysRented) {
        this._movie = _movie;
        this._daysRented = _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public void set_movie(Movie _movie) {
        this._movie = _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public void set_dayRented(int getDaysRented) {
        this._daysRented = getDaysRented;
    }


    public double getCharge(  ) {
        return _movie.getCharge(_daysRented);
    }

    public int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(_daysRented);
    }
}
