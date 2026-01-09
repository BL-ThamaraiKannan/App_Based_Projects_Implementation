package com.bridgelabz.OceanFleet;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        System.out.println("Enter the number of vessels to be added");
        int n = scanner.nextInt();
        if(n<1) {
        	System.out.println("Enter valid quantity !");
        }
        scanner.nextLine(); // consume newline

        System.out.println("Enter vessel details in the format - vesselId:vesselName:averageSpeed:vesselType");
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            // Empty input check
            if (input == null || input.trim().isEmpty()) {
                System.out.println("Invalid input. Please enter vessel details again.");
                i--; // repeat this iteration
                continue;
            }

            String[] parts = input.split(":");

            // Format validation
            if (parts.length != 4) {
                System.out.println("Invalid format. Use vesselId:vesselName:averageSpeed:vesselType");
                i--;
                continue;
            }
            
            String vesselId = parts[0].trim();
            String vesselName = parts[1].trim();
            String vesselType = parts[3].trim();

            double averageSpeed;

            // Average speed validation
            try {
                averageSpeed = Double.parseDouble(parts[2].trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid average speed. Please enter numeric value.");
                i--;
                continue;
            }

            Vessel vessel = new Vessel(vesselId, vesselName, averageSpeed, vesselType);
            vesselUtil.addVesselPerformance(vessel);
        }

        System.out.println("Enter the Vessel Id to check speed");
        String searchId = scanner.nextLine();

        Vessel result = vesselUtil.getVesselById(searchId);

        if (result != null) {
            System.out.println(result.getVesselId() + " | " +
                    result.getVesselName() + " | " +
                    result.getVesselType() + " | " +
                    result.getAverageSpeed() + " knots");
        } else {
            System.out.println("Vessel Id " + searchId + " not found");
        }

        System.out.println("High performance vessels are");
        List<Vessel> highPerformanceVessels = vesselUtil.getHighPerformanceVessels();

        for (Vessel vessel : highPerformanceVessels) {
            System.out.println(vessel.getVesselId() + " | " +
                    vessel.getVesselName() + " | " +
                    vessel.getVesselType() + " | " +
                    vessel.getAverageSpeed() + " knots");
        }
    }
}
