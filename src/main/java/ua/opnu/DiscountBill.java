package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

import java.util.ArrayList;
import java.util.List;

public class DiscountBill extends GroceryBill {
    private final boolean regularCustomer;
    private final List<Item> discountItems;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountItems = new ArrayList<>();
    }

    @Override
    public void add(Item i) {
        super.add(i);
        discountItems.add(i);
    }

    public int getDiscountCount() {
        int discountCount = 0;
        if (!regularCustomer) {
            return discountCount;
        }

        for (Item item : discountItems) {
            if (item.getDiscount() > 0) {
                discountCount++;
            }
        }
        return discountCount;
    }

    public double getDiscountAmount() {
        double discountAmount = 0;
        if (regularCustomer) {
            for (Item item : discountItems) {
                if (item.getDiscount() > 0) {
                    discountAmount += item.getDiscount();
                }
            }
        }
        return discountAmount;
    }

    @Override
    public double getTotal() {
        double total = super.getTotal();
        if (regularCustomer) {
            double discountAmount = getDiscountAmount();
            total -= discountAmount;
        }
        return total;
    }

    public double getDiscountPercent() {
        double discountAmount = getDiscountAmount();
        double totalWithoutDiscount = 0.0;

        for (Item item : discountItems) {
            totalWithoutDiscount += item.getPrice();
        }

        if (totalWithoutDiscount == 0) return 0.0;

        return (discountAmount / totalWithoutDiscount) * 100;
    }

}
