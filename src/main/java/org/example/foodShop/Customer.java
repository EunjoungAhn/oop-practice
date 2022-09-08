package org.example.foodShop;

public class Customer {

    public void order(String muneName, Menu menu, Cooking cooking){
        MenuItem menuItem = menu.choose(muneName);
        Cook cook = cooking.makeCook(menuItem);
        return;
    }
}
