package se.yrgo.example;

public class DateHandler {
    private int month;
    private int dayOfMonth;

    public DateHandler(int month, int dayOfMonth) {
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    public boolean isNewYear() {
        return (dayOfMonth == 1 || dayOfMonth == 01) && (month == 1 || month == 01);
    }
}