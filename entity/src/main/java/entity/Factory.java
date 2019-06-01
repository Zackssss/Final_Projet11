package entity;

import javax.swing.plaf.nimbus.State;

public abstract class Factory {

    private String name;
    private String state;
    private Permeability permeability;

    public Factory(final String name, final String state, final Permeability permeability) {
        this.setName(name);
        this.setState(state);
        this.setPermeability(permeability);
    }

    public String getName() {return this.name;}

    public void setName(final String name) {
        this.name = (name);
    }

    public String getState() {return this.state;}

    public void setState(final String state){
        this.state = (state);
    }

    public Permeability getPermeability() {return this.permeability;}
    
    public void setPermeability(final Permeability permeability){
        this.permeability = (permeability);

    }
}



