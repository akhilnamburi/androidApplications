package z1856517.cs.niu.portfolio2;

public class Shipping_Item {

    static final Double BASE_AMOUNT = 3.00,
            ADDED_AMOUNT = 0.50,
            EXTRA_OUNCES = 4.0;

    static final Integer BASE_WEIGHT = 16;

    // Data Members

    private Integer weight;
    private Double baseCost, addedCost, totalCost;

    // Shipping_Item Constructor created using default android studio generator

    public Shipping_Item()
    {
        weight = 0;
        baseCost = BASE_AMOUNT;
        addedCost = 0.00;
        totalCost = 0.00;

    } // end of Shipping_Item constructor

    // Weight Constructor created using default android studio generator

    public void setWeight(Integer newWeight)
    {
        weight = newWeight;
        computeCost();
    } // End of SetWeight

    public Double getBaseCost()
    {
        return baseCost;
    }

    public Double getAddedCost()
    {
        return addedCost;
    }

    public Double getTotalCost()
    {
        return totalCost;
    }

    public void computeCost()
    {
        // Calculate baseCost

        baseCost = BASE_AMOUNT;

        // cover the case of 0 ounces

        if( weight <= 0 )
            baseCost = 0.00;

        // Calculate addedCost

        addedCost = 0.00;

        // Cover for more than 16 ounces

        if(weight > BASE_WEIGHT)
            addedCost = Math.ceil((weight - BASE_WEIGHT) / EXTRA_OUNCES ) * ADDED_AMOUNT;

        // Calculate totalCost

        totalCost = baseCost + addedCost;

    } // End of computeCost



}
