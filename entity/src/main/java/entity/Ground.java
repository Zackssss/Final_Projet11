package entity;

class Ground extends Factory{

    public Ground(String name, boolean state, Permeability permeability){
        super(name, state, Permeability.BLOCKING);
    }
}