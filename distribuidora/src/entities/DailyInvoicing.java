package entities;

public class DailyInvoicing {

    private String date;
    private double value;

    public DailyInvoicing(String date, double value) {
        this.date = date;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }
}
