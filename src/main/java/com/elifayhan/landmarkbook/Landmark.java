package com.elifayhan.landmarkbook;

import java.io.Serializable;

public class Landmark implements Serializable { //serileştirme, bir veriyi
    //bir yerden bir yere yollarken bunu veriyi çevirip diğer tarafta tekrar eski haline çevirebilir.
    String name;
    String country;
    int image;
    public Landmark(String name, String country, int image){
        this.name=name;
        this.country=country;
        this.image=image;
    }
}
