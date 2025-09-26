package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

import java.util.ArrayList;
import java.util.List;

public class DiscountBill2 {
    private GroceryBill groceryBill;
    private boolean regularCustomer;
    private List<Item> discountItems;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        groceryBill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountItems = new ArrayList<>();
    }

    public Employee getClerk() {
        return groceryBill.getClerk();
    }

    public void add(Item i) {
        groceryBill.add(i);
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

    public double getTotal() {
        double total = groceryBill.getTotal();
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
