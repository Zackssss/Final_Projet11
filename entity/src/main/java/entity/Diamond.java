package entity;

/**
 * The Class Diamond.
 *
 * Defines diamonds parameters
 *
 * @author Zachary Morello &amp;&amp; Hugo Bouillon
 */

public class Diamond extends Factory{

    /**
     * Defines Diamond as a Factory object.
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

    public Diamond(final String name, final Boolean state, final Boolean collectibility, final Boolean destructibility, final Boolean permeability, final FallingReaction reaction){
        super(name, state, collectibility, destructibility, permeability, reaction);


    }
}


