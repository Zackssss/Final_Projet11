package entity;

/**
 * The Class Factory.
 *
 * Permits the creation of Factory objects.
 *
 * @author Zachary Morello &amp;&amp; Hugo Bouillon
 */

public abstract class Factory {

    /** The name. */

    private String name;

    /** The state. */
    private Boolean state;

    /** The collectibility. */
    private Boolean collectibility;

    /** The destructibility. */
    private Boolean destructibility;

    /** The permeability. */
    private Boolean permeability;

    /** The reaction. */
    private FallingReaction reaction;

    /**
     * Instantiates a new Factory.
     *
     * @param name
     *          the sprite's name
     * @param state
     *          isFalling or not
     * @param collectibility
     *          isCollectable or not(diamonds)
     * @param destructibility
     *          isDestructible or not
     * @param permeability
     *          isDiggable or not
     * @param reaction
     *          Reaction to falling object
     */

    public Factory(final String name, final Boolean state, final Boolean collectibility, final Boolean destructibility, final Boolean permeability, final FallingReaction reaction) {
        this.setName(name);
        this.setState(state);
        this.setCollectibility(collectibility);
        this.setDestructibility(destructibility);
        this.setPermeability(permeability);
        this.setFallingReaction(reaction);

    }

    /**
     * Gets the name.
     *
     * @return the name
     *
     */
    public String getName() {return this.name;}

    /**
     * Sets the name.
     *
     * @param name
     *          the name
     */

    public void setName(final String name) {
        this.name = (name);
    }

    /**
     * Gets the state.
     *
     * @return the name
     *
     */
    public Boolean getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state
     *          the state
     */

    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * Gets the FallingReaction.
     *
     * @return the reaction
     */

    public FallingReaction getFallingReaction() {
        return this.reaction;
    }

    /**
     * Sets the FallingReaction.
     *
     * @param reaction
     *          the reaction
     */
    public void setFallingReaction(final FallingReaction reaction){
        this.reaction = (reaction);

    }

    /**
     * Gets the collectibility.
     *
     * @return the collectibility
     */
    public Boolean getCollectibility() {
        return collectibility;
    }

    /** Sets the collectibility.
     *
     * @param collectibility
     *                  the collectibility
     */

    public void setCollectibility(Boolean collectibility) {
        this.collectibility = collectibility;
    }

    /**
     * Gets the destructibility.
     *
     * @return the destructibility
     */

    public Boolean getDestructibility() {
        return destructibility;
    }

    /**
     * Sets the destructibility.
     *
     * @param destructibility
     *              the destructibility
     */

    public void setDestructibility(Boolean destructibility) {
        this.destructibility = destructibility;
    }

    /** Gets the permeability.
     *
     * @return the permeability
     */

    public Boolean getPermeability() {
        return permeability;
    }

    /** Sets the permeability.
     *
     * @param permeability
     *                  the permeability
     */

    public void setPermeability(Boolean permeability) {
        this.permeability = permeability;
    }

}



