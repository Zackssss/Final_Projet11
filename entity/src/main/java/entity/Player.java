package entity;

public class Player extends Factory {

    public Player(String name, boolean state, Permeability permeability){
        super(name, state, Permeability.BLOCKING);
    }
}
