package entity;

public class Border extends Factory{

        public Border(final String name, final Boolean state, final Boolean collectibility, final Boolean destructibility, final Boolean permeability, final FallingReaction reaction){
            super(name, state, collectibility, destructibility, permeability, reaction);
        }
}
