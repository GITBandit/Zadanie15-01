package pl.javastart.zadanie1501.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.javastart.zadanie1501.db.ShoppingCart;
import pl.javastart.zadanie1501.model.Car;

import java.util.List;

@Controller
public class CarDealerController {

    private ShoppingCart shoppingCart;

    @Autowired
    public CarDealerController(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @PostMapping("/addtocart")
    public String addToCart(@RequestParam ("limo") String limoVolume, @RequestParam ("sportcar") String sportCarsVolume, @RequestParam ("usedcar") String usedCarsVolume){

        limoVolume = (limoVolume.equals("")) ? "0" : limoVolume;
        sportCarsVolume = (sportCarsVolume.equals("")) ? "0" : sportCarsVolume;
        usedCarsVolume = (usedCarsVolume.equals("")) ? "0" : usedCarsVolume;

        shoppingCart.addLimos(Integer.valueOf(limoVolume));
        shoppingCart.addSportCars(Integer.valueOf(sportCarsVolume));
        shoppingCart.addUsedCars(Integer.valueOf(usedCarsVolume));

        return "redirect:summary.html";
    }


    @GetMapping("/print")
    @ResponseBody
    public String printCart() {
        List<Car> cart = shoppingCart.getCart();
        return cart.toString();
    }

    @GetMapping("/sum")
    @ResponseBody
    public String shoppingSum(){
        return "Do zapłaty  " + shoppingCart.shoppingSum() + "zł";
    }

    @GetMapping("/clear")
    @ResponseBody
    public String emptyCart(){
        shoppingCart.clearCart();
        return "Koszyk został opróżniony";
    }

}
