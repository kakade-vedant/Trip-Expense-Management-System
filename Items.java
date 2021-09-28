package com.vedantkakade;

class Items {
    private final String itemName;
    private final double amountOfItemsBought;
    private final double pricePerItem;

    public Items(String itemName, double amountOfItemsBought, double pricePerItem) {
        this.itemName = itemName;
        this.amountOfItemsBought = amountOfItemsBought;
        this.pricePerItem = pricePerItem;
    }

    public String getItemName() {
        return itemName;
    }

    public double getAmountOfItemsBought() {
        return amountOfItemsBought;
    }

    public double  getPricePerItem() {
        return pricePerItem;
    }
}
