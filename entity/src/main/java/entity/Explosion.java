package entity;

public class Explosion extends Factory{

    public Explosion(String name, String state, Permeability permeability){
        super(name, state, Permeability.BLOCKING);
    }
}

