package com.javahongkong.bootcamp.exercise;

import java.util.HashMap;

public interface FurnitureOrderInterface {

    /**
     * @param type The type of Furniture being added to the order.
     * @param count The number of units of Furniture type 'type' to add to the order.
     */
    void addToOrder(final Furniture type, final int count);

    /**
     * @return All the ordered furniture as a mapping of Furniture types to Integer quantities.
     */
    HashMap<Furniture, Integer> getOrderedFurniture();

    /**
     * @param type The type of Furniture
     * @return The total number of units of Furniture 'type' in the order.
     */
    int getTypeCount(Furniture type);

    /**
     *
     * @param type The type of Furniture being ordered
     * @return The total cost of just the Furniture units of 'type' in the order.
     */
    float getTypeCost(Furniture type);

    /**
     * @return The total cost of the order.
     */
    float getTotalOrderCost();

	/**
	 * @return The total number of all types of Furniture units in the order.
	 */
    int getTotalOrderQuantity();
}