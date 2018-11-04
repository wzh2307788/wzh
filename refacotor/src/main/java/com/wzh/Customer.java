package com.wzh;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental rental) {
        _rentals.add(rental);

    }

    public String getName() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }


    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement(); // determine amounts for each line
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRentalPoint()) + " frequent renter points";
        return result;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        Enumeration e = _rentals.elements();
        while (e.hasMoreElements()) {
            Rental rental = (Rental) e.nextElement();
            totalAmount += rental.getCharge();
        }
        return totalAmount;
    }

    public double getFrequentRentalPoint() {
        double frequentRentalPoint = 0;
        Enumeration e = _rentals.elements();
        while (e.hasMoreElements()) {
            Rental rental = (Rental) e.nextElement();
            frequentRentalPoint += rental.getFrequentRenterPoints();
        }
        return frequentRentalPoint;
    }


}
