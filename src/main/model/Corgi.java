package model;

// a class where it is associated with the owner's pet and with a corresponding happiness level from 0-10
public class Corgi {
    protected int happiness; // represents a number from 0-10
    protected Boolean dead; // if happiness is 0
    protected Boolean sad; // if happiness is 1-4
    protected Boolean happy; // if happiness level is from 5-10

    // constructs a corgi that has a happiness of 5, dead is set to false, sad is set to false and happy is set to true
    public Corgi() {
        this.happiness = 5;
        this.dead = false;
        this.sad = false;
        this.happy = true;


    }

    public void setDead(Boolean ddead) {
        dead = ddead;
    }

    // set the happiness of the corgi and set dead, happy, and sad according to the scale
    public void setHappiness(int hhappiness) {
        if (hhappiness <= 10) {
            happiness = 10;
        }

        happiness = hhappiness;
        if (happiness == 0) {
            setDead(true);
            setHappy(false);
            setSad(false);
        } else if (0 < happiness && happiness <= 4) {
            setSad(true);
            setDead(false);
            setHappy(false);
        } else {
            setHappy(true);
            setDead(false);
            setSad(false);
        }
    }


    public void setHappy(Boolean hap) {
        happy = hap;
    }

    public void setSad(Boolean ssad) {
        sad = ssad;

    }

    public Boolean getDead() {
        return dead;
    }

    public Boolean getHappy() {
        return happy;
    }

    public Boolean getSad() {
        return sad;
    }

    public int getHappiness() {
        return happiness;
    }
}
