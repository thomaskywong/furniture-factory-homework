package com.javahongkong.bootcamp.exercise;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    HashMap<Furniture, Integer> ordersOfFurnitures;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    public FurnitureOrder() {
        this.ordersOfFurnitures = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        Objects.requireNonNull(type);

        if (furnitureCount < 0)
            throw new IllegalArgumentException("Invalid count amount < 0");

        int initialCount = 0;
        if (this.ordersOfFurnitures.containsKey(type)) {
            initialCount = this.ordersOfFurnitures.get(type);
        }

        this.ordersOfFurnitures.put(type, furnitureCount + initialCount);

    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return this.ordersOfFurnitures;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        BigDecimal total = BigDecimal.valueOf(0.0);
        
        for (Map.Entry<Furniture,Integer> entry : this.ordersOfFurnitures.entrySet()) {
            total = total.add(
                        BigDecimal.valueOf(entry.getValue())
                        .multiply(BigDecimal.valueOf(entry.getKey().cost())));
        }
        return total.floatValue();
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        if (this.ordersOfFurnitures.containsKey(type)) 
            return this.ordersOfFurnitures.get(type);
        
        return 0;
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        BigDecimal total = BigDecimal.valueOf(0.0);
        if (this.ordersOfFurnitures.containsKey(type)) {
            total = total.add(
                        BigDecimal.valueOf(type.cost())
                        .multiply(BigDecimal.valueOf(this.getTypeCount(type))));
        } 

        return total.floatValue();
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        int count = 0;
        
        for (Map.Entry<Furniture,Integer> entry : this.ordersOfFurnitures.entrySet()) {
            count += entry.getValue();
        }
        return count;
    }

    @Override
    public String toString() {
        return "Furniture(orderOfFurniture=" + this.ordersOfFurnitures + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj)
            return true;

        if (!(obj instanceof FurnitureOrder))
            return false;
        
        FurnitureOrder furnitureOrder = (FurnitureOrder) obj;

        return Objects.equals(this.ordersOfFurnitures, furnitureOrder.getOrderedFurniture());
    }

    @Override 
    public int hashCode() {
        return Objects.hash(this.ordersOfFurnitures);
    }
}