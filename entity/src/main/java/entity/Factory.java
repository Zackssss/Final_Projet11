package entity;

public abstract class Factory {

    private String name;
    private boolean state;
    private Permeability permeability;

    public Factory(final String name, final boolean state, final Permeability permeability) {
        this.setName(name);
        this.setState(state);
        this.setPermeability(permeability);
    }

    public String getName() {return this.name;}

    public void setName(final String name) {
        this.name = (name);
    }

    public boolean getState() {return this.state;}

    public void setState(final boolean state){
        this.state = (state);
    }

    public Permeability getPermeability() {return this.permeability;}
    
    public void setPermeability(final Permeability permeability){
        this.permeability = (permeability);

    }
}



