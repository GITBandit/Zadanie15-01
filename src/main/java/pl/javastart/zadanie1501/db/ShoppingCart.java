package pl.javastart.zadanie1501.db;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.javastart.zadanie1501.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShoppingCart {

     private List<Car> cart = new ArrayList<>();

     private Car limo = new Car("Limuzyna",125000);
     private Car sportCar = new Car("Samochód sportowy",92000);
     private Car usedCar = new Car("Samochód używany",40000);

     public void addLimos (int volume){
         for (int i = 0; i < volume; i++){
            cart.add(limo);
         }
     }

    public void addSportCars (int volume){
        for (int i = 0; i < volume; i++){
            cart.add(sportCar);
        }
    }

    public void addUsedCars (int volume){
        for (int i = 0; i < volume; i++){
            cart.add(usedCar);
        }
    }

    public List<Car> getCart(){
        return cart;
    }


    public int shoppingSum(){
        int sum = 0;
        for (Car car : cart) {
            sum += car.getCarPrice();
        }
        return sum;
    }

    public void clearCart(){
        cart.clear();
    }
}


