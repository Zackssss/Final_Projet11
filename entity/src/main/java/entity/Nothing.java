package entity;

class Nothing extends Factory{

    public Nothing(String name, boolean state, Permeability permeability){
        super(name, state, Permeability.BLOCKING);
    }
}

