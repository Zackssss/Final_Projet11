package entity;

public abstract class Factory {

    private String name;
    private Boolean state;
    private Boolean collectibility;
    private Boolean destructibility;
    private Boolean permeability;

    private FallingReaction reaction;

    public Factory(final String name, final Boolean state, final Boolean collectibility, final Boolean destructibility, final Boolean permeability, final FallingReaction reaction) {
        this.setName(name);
        this.setState(state);
        this.setCollectibility(collectibility);
        this.setDestructibility(destructibility);
        this.setPermeability(permeability);
        this.setFallingReaction(reaction);

    }

    public String getName() {return this.name;}

    public void setName(final String name) {
        this.name = (name);
    }

    public Boolean getState(boolean b) {return this.state;}

    public Boolean setState(final Boolean state){
        this.state = (state);
        return false;
    }

    public FallingReaction getFallingReaction() {
        return this.reaction;
    }
    
    public void setFallingReaction(final FallingReaction reaction){
        this.reaction = (reaction);

    }

    public Boolean getCollectibility() {
        return collectibility;
    }

    public void setCollectibility(Boolean collectibility) {
        this.collectibility = collectibility;
    }

    public Boolean getDestructibility() {
        return destructibility;
    }

    public void setDestructibility(Boolean destructibility) {
        this.destructibility = destructibility;
    }

    public Boolean getPermeability() {
        return permeability;
    }

    public void setPermeability(Boolean permeability) {
        this.permeability = permeability;
    }
}



