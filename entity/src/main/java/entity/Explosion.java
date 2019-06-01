package entity;

public class Explosion extends Factory{

    public Explosion(String name, boolean state, Permeability permeability){
        super(name, state, Permeability.BLOCKING);
    }
}

