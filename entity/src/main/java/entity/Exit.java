package entity;


public class Exit extends Factory{

    public Exit(final String name, final Boolean state, final Boolean collectibility, final Boolean destructibility, final Boolean permeability, final FallingReaction reaction){
        super(name, state, collectibility, destructibility, permeability, reaction);
    }
}
