package com.elifayhan.landmarkbook;

public class Singleton {

    private Landmark setLandmark;
    private static Singleton singleton;

    private Singleton() {


    }

    public Landmark getSetLandmark() {
        return setLandmark;
    }

    public void setSetLandmark(Landmark setLandmark) {
        this.setLandmark = setLandmark;
    }
    public static  Singleton getInstance(){
        if(singleton==null){
            singleton =new Singleton();
        }
        return singleton;
    }
}
