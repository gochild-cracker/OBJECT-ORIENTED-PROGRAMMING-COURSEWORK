/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vic.inc.coursework;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Heifer
 */
public class skmotors {
    public static void main (String[] args){;
     Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.println("===== SK MOTORS AUCTION SYSTEM =====\n");

        // Vehicle details 
        System.out.println("Select Vehicle Registration Number:");
        System.out.println("1) 123K");
        System.out.println("2) 567K");
        System.out.println("3) 890K");
        System.out.print("Enter choice (1-3): ");
        int choice = input.nextInt();
        input.nextLine(); // clear buffer

        String regNo;
        if (choice == 1) {
            regNo = "123K";
        } else if (choice == 2) {
            regNo = "567K";
        } else if (choice == 3) {
            regNo = "890K";
        } else {
            regNo = "123K"; // default
            System.out.println("Invalid choice! Default selected: 123K");
        }

        System.out.print("Enter Vehicle Cost: ");
        double vehicleCost = input.nextDouble();

        System.out.print("Enter Balance Left on the Vehicle: ");
        double balanceLeft = input.nextDouble();

        // Deposits
        System.out.print("\nEnter number of deposits: ");
        int depCount = input.nextInt();

        double totalDeposits = 0;
        for (int i = 1; i <= depCount; i++) {
            System.out.print("Enter deposit amount " + i + ": ");
            totalDeposits += input.nextDouble();
        }

        // Expenses
        System.out.print("\nEnter number of expenses: ");
        int expCount = input.nextInt();
        while (expCount < 0 ){
            System.out.println("Wrong input, enter expenses again");
            expCount = input.nextInt();
        }

        double totalExpenses = 0;
        for (int i = 1; i <= expCount; i++) {
            System.out.print("Enter expense amount " + i + ": ");
            totalExpenses += input.nextDouble();
        }

        // Accept 3 bidders
        System.out.println("\n--- BIDDING ROUND ---");
        double[] bids = new double[3];
        double highestBid = -1;
        int winningBidder = 0;

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter bid price for Bidder " + (i + 1) + ": ");
            bids[i] = input.nextDouble();

            if (bids[i] > highestBid) {
                highestBid = bids[i];
                winningBidder = i + 1;
            }
        }

        // Calculations
        double totalCost = vehicleCost + totalExpenses + balanceLeft;
        double netCostAfterDeposits = totalCost - totalDeposits;
        double profitOrLoss = highestBid - netCostAfterDeposits;

        // Display report
        System.out.println("\n========== SK MOTORS AUCTION REPORT ==========");
        System.out.println("Vehicle Registration Number: " + regNo);
        System.out.println("Vehicle Cost: UGX " + df.format(vehicleCost));
        System.out.println("Balance Left: UGX " + df.format(balanceLeft));
        System.out.println("Total Expenses: UGX " + df.format(totalExpenses));
        System.out.println("Total Deposits: UGX " + df.format(totalDeposits));

        System.out.println("\n--- All Bids ---");
        for (int i = 0; i < 3; i++) {
            System.out.println("Bidder " + (i + 1) + ": UGX " + df.format(bids[i]));
        }

        System.out.println("\n--- FINANCIAL BREAKDOWN ---");
        System.out.println("Total Cost (Vehicle + Expenses + Balance): UGX " + df.format(totalCost));
        System.out.println("Less: Deposits Received: UGX " + df.format(totalDeposits));
        System.out.println("Net Amount Required: UGX " + df.format(netCostAfterDeposits));

        System.out.println("\n--- AUCTION RESULT ---");
        System.out.println("Winner: Bidder " + winningBidder);
        System.out.println("Winning Bid: UGX " + df.format(highestBid));

        if (profitOrLoss > 0) {
            System.out.println("\n✓ PROFIT: UGX " + df.format(profitOrLoss));
        } else if (profitOrLoss < 0) {
            System.out.println("\n✗ LOSS: UGX " + df.format(Math.abs(profitOrLoss)));
        } else {
            System.out.println("\n○ BREAK EVEN (No Profit, No Loss)");
        }

        System.out.println("==============================================");

        input.close();
    }

    
}
