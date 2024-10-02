package com.murad.quickcart.random;

import java.util.HashMap;
import java.util.Map;

public class CommissionComparison {

    public static void main(String[] args) {
        String actualCommison = "name, model, commission\n" +
                "Toyota, 2003, 300.00\n" +
                "Audi, 2003, 100.00\n" +
                "Honda, 2010, 350.00\n" +
                "BMW, 2015, 400.00\n" +
                "Mercedes, 2018, 500.00";

        String aceptedCommison = "name, model, commission\n" +
                "Toyota, 2003, 300.00\n" +
                "Audi, 2003, 200.00\n" +
                "Honda, 2010, 250.00\n" +
                "BMW, 2015, 400.00";

        // Split the strings into lines
        String[] actualLines = actualCommison.split("\n");
        String[] acceptedLines = aceptedCommison.split("\n");

        // Create a map to store accepted commission values
        Map<String, Double> acceptedCommissionMap = new HashMap<>();
        for (int i = 1; i < acceptedLines.length; i++) {
            String[] parts = acceptedLines[i].split(", ");
            String key = parts[0] + ", " + parts[1];
            double commission = Double.parseDouble(parts[2]);
            acceptedCommissionMap.put(key, commission);
        }

        // Compare the actual commission values with the accepted commission values
        StringBuilder result = new StringBuilder("name, model, actual commission, accepted commission, remarks\n");
        for (int i = 1; i < actualLines.length; i++) {
            String[] parts = actualLines[i].split(", ");
            String key = parts[0] + ", " + parts[1];
            double actualCommission = Double.parseDouble(parts[2]);

            if (acceptedCommissionMap.containsKey(key)) {
                double acceptedCommission = acceptedCommissionMap.get(key);
                String remark;
                if (actualCommission == acceptedCommission) {
                    remark = "matched";
                } else if (actualCommission > acceptedCommission) {
                    remark = "overpaid";
                } else {
                    remark = "underpaid";
                }
                result.append(parts[0]).append(", ").append(parts[1]).append(", ")
                        .append(actualCommission).append(", ").append(acceptedCommission).append(", ").append(remark).append("\n");
            } else {
                result.append(parts[0]).append(", ").append(parts[1]).append(", ")
                        .append(actualCommission).append(", ").append("N/A").append(", ").append("unaccepted commission").append("\n");
            }
        }

        // Print the result
        System.out.println(result.toString());
    }
}