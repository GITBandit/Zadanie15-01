package pl.javastart.zadanie1501.model;

public class Car {

    private String carName;
    private int carPrice;

    public Car(String carName, int carPrice) {
        this.carName = carName;
        this.carPrice = carPrice;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPrice() {
        return carPrice;
    }

    @Override
    public String toString() {
        return  "<br>nazwa ='" + carName + '\'' +
                ", cena =" + carPrice +
                  "<br>";
    }
}
