package com.wzh;

public class Movie {
public  static final int CHILDREN=2;
public static final int REGULAR=0;
public static final int NEW_RELEASE=1;
private String _title;
private int _priceCode;
private Price _price;

    public Movie(String _titile, int _priceCode) {
        this._title = _titile;
        setPriceCode(_priceCode);
    }

    public static int getCHILDREN() {
        return CHILDREN;
    }

    public static int getREGULAR() {
        return REGULAR;
    }

    public static int getNewRelease() {
        return NEW_RELEASE;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int _priceCode) {
        switch(_priceCode){
            case REGULAR:
                _price=new RegularPrice();
                break;
            case CHILDREN:
                _price= new ChildrenPrice();
                break;
            case NEW_RELEASE:
                _price=new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }

        this._priceCode = _priceCode;
    }

    public double getCharge( int daysRented ) {
        return  _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
         return _price.getFrequentRenterPoints(daysRented);
    }

    public Price getPrice() {
        return _price;
    }

    public void setPrice(Price _price) {
        this._price = _price;
    }


}
