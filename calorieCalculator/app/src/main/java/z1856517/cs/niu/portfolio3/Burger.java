package z1856517.cs.niu.portfolio3;


public class Burger {
    //constants
    static final int CHICKEN = 95;
    static final int TURKEY = 170;
    static final int VEGGIE = 150;
    static final int CHEDDAR = 113;
    static final int MOZZ = 78;
    static final int BACON = 86;

    //data members
    private int pattyCalories, cheeseCalories, baconCalories, sauceCalories;

    //constructor


    public Burger()
    {
        pattyCalories =CHICKEN;
        cheeseCalories = 0;
        baconCalories =0;
        sauceCalories = 0;

    }//end constructor

    //Set methods

    public void setPattyCalories(int newCalories)

    {
        pattyCalories = newCalories;
    }

    public void setCheeseCalories(int newCalories)
    {
        cheeseCalories = newCalories;
    }

    public void setBaconCalories(boolean hasBacon)

    {
        if(hasBacon)
            baconCalories = BACON;
        else
            baconCalories = 0;
    }

    public void setSauceCalories(int newCalories)
    {
        sauceCalories = newCalories;
    }

    //method to calculate total number of calories
    public int getTotalCalories()
    {
        return pattyCalories + cheeseCalories + baconCalories + sauceCalories;
    }//end getTotalCalories

}//end Burger class
