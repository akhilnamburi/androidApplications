package z1856517.niu.shippingcalculator;

public class ShippingItem
{
    //Constants
    static final Double BASE_AMOUNT = 3.00,
                        ADDED_AMOUNT = 0.50,
                        EXTRA_OUNCES = 4.0;
    static final int BASE_WEIGHT = 16;

    //Variables
    private Integer weight;
    private Double baseCost, addedCost, totalCost;

    public ShippingItem()
    {
        weight = 0;
        baseCost = BASE_AMOUNT;
        addedCost = 0.0;
        totalCost = 0.0;
    }

    public void setWeight(Integer newWeight)
    {
        this.weight = newWeight;
        computeCost();
    }//end setWeight method

    public void computeCost()
    {
        baseCost = BASE_AMOUNT;
        if(weight <= 0)
            baseCost = 0.0;

        //calculate the additional cost
        addedCost = 0.0;
        if(weight > BASE_WEIGHT)
            addedCost = Math.ceil( (weight - BASE_WEIGHT)/EXTRA_OUNCES ) * ADDED_AMOUNT;

        //calculate total cost
        totalCost = baseCost + addedCost;
    }//end computeCost


    public Double getBaseCost() {
        return baseCost;
    }

    public Double getAddedCost() {
        return addedCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }
}//end ShippingItem class
