/** Demonstrates constructors, getters, setters, selection and loops. */
public class Main {
    /** Starts a repeatable demonstration using fictional lab equipment. */
    public static void main(String[] args) {
        System.out.println("LAB EQUIPMENT TRACKING SYSTEM");

        // Use the no-argument constructor, then change all seven attributes.
        LabAsset computer = new LabAsset();
        computer.setAssetId("DEMO-PC-001");
        computer.setAssetName("Desktop computer");
        computer.setLabName("Training Lab A");
        computer.setCondition("Unknown");
        computer.setQuantity(2);
        computer.setUnitPrice(1500.00);
        computer.setCheckedThisWeek(false);

        // Use the parameterized constructor to create two separate objects.
        LabAsset projector = new LabAsset("DEMO-PJ-001", "Projector",
                "Training Lab A", "Not working", 1, 2200.00, true);
        LabAsset laptop = new LabAsset("DEMO-LP-001", "Laptop",
                "Training Lab A", "Working", 1, 3200.00, false);

        // An array lets a loop process multiple objects of the same class.
        LabAsset[] assets = {computer, projector, laptop};
        System.out.println("\nBEFORE THIS WEEK'S NEW INSPECTIONS");

        // Loop through every object and read its information using getters.
        for (LabAsset asset : assets) {
            System.out.println("\nAsset ID: " + asset.getAssetId());
            System.out.println("Name: " + asset.getAssetName());
            System.out.println("Lab: " + asset.getLabName());
            System.out.println("Stored condition: " + asset.getCondition());
            System.out.println("Quantity: " + asset.getQuantity());
            System.out.printf("Unit price: RM %.2f%n", asset.getUnitPrice());
            System.out.println("Checked this week: " + asset.getCheckedThisWeek());
            System.out.printf("Total value: RM %.2f%n", asset.calculateTotalValue());

            // Check recency first: an old Working result is not current evidence.
            if (!asset.getCheckedThisWeek()) {
                System.out.println("Action: inspect this week; stored result is not current.");
            } else if ("Unknown".equals(asset.getCondition())) {
                System.out.println("Action: condition is unknown; complete the inspection.");
            } else if (asset.needsMaintenance()) {
                System.out.println("Action: arrange maintenance.");
            } else {
                System.out.println("Action: checked and working this week.");
            }
        }

        // An operation changes related attributes together after an inspection.
        System.out.println("\nRECORD NEW INSPECTIONS");
        computer.recordInspection("Working");
        laptop.recordInspection("Not working");

        int totalUnits = 0;
        int workingUnits = 0;
        int maintenanceUnits = 0;
        int unverifiedUnits = 0;
        double inventoryValue = 0.0;
        System.out.println("\nAFTER INSPECTIONS");

        // Calculate totals and use selection to classify each record's units.
        for (LabAsset asset : assets) {
            totalUnits = totalUnits + asset.getQuantity();
            inventoryValue = inventoryValue + asset.calculateTotalValue();
            System.out.println(asset.getAssetId() + " | " + asset.getAssetName()
                    + " | " + asset.getCondition());

            if (!asset.getCheckedThisWeek()
                    || "Unknown".equals(asset.getCondition())) {
                unverifiedUnits = unverifiedUnits + asset.getQuantity();
            } else if (asset.needsMaintenance()) {
                maintenanceUnits = maintenanceUnits + asset.getQuantity();
            } else {
                workingUnits = workingUnits + asset.getQuantity();
            }
        }

        System.out.println("\nSUMMARY");
        System.out.println("Asset records: " + assets.length);
        System.out.println("Total units: " + totalUnits);
        System.out.println("Checked working units: " + workingUnits);
        System.out.println("Maintenance units: " + maintenanceUnits);
        System.out.println("Unverified units: " + unverifiedUnits);
        System.out.printf("Inventory value: RM %.2f%n", inventoryValue);
    }
}
