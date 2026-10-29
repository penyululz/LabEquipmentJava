/**
 * Models one record of identical lab items with the same stored condition.
 * All seven attributes are private. Other classes use public methods.
 */
public class LabAsset {
    private String assetId;
    private String assetName;
    private String labName;
    private String condition;
    private int quantity;
    private double unitPrice;
    private boolean checkedThisWeek;

    /** Creates an unassigned record that has not been inspected. */
    public LabAsset() {
        assetId = "UNASSIGNED";
        assetName = "Unnamed item";
        labName = "Unassigned lab";
        condition = "Unknown";
        quantity = 0;
        unitPrice = 0.0;
        checkedThisWeek = false;
    }

    /** Creates a record using supplied values and the setters' checks. */
    public LabAsset(String newAssetId, String newAssetName, String newLabName,
                    String newCondition, int newQuantity, double newUnitPrice,
                    boolean newCheckedThisWeek) {
        this(); // Start with the safe values from the no-argument constructor.
        setAssetId(newAssetId);
        setAssetName(newAssetName);
        setLabName(newLabName);
        setCondition(newCondition);
        setQuantity(newQuantity);
        setUnitPrice(newUnitPrice);
        setCheckedThisWeek(newCheckedThisWeek);
    }

    /** Returns the identifier of this asset record. */
    public String getAssetId() {
        return assetId;
    }

    /** Changes the identifier only when the supplied text is not blank. */
    public void setAssetId(String newAssetId) {
        if (newAssetId == null || newAssetId.trim().isEmpty()) {
            System.out.println("Asset ID must not be blank. Value unchanged.");
        } else {
            assetId = newAssetId.trim();
        }
    }

    /** Returns the name of the item. */
    public String getAssetName() {
        return assetName;
    }

    /** Changes the item name only when the supplied text is not blank. */
    public void setAssetName(String newAssetName) {
        if (newAssetName == null || newAssetName.trim().isEmpty()) {
            System.out.println("Asset name must not be blank. Value unchanged.");
        } else {
            assetName = newAssetName.trim();
        }
    }

    /** Returns the lab assigned to this record. */
    public String getLabName() {
        return labName;
    }

    /** Changes the lab only when the supplied text is not blank. */
    public void setLabName(String newLabName) {
        if (newLabName == null || newLabName.trim().isEmpty()) {
            System.out.println("Lab name must not be blank. Value unchanged.");
        } else {
            labName = newLabName.trim();
        }
    }

    /** Returns the stored condition, which may be from an earlier week. */
    public String getCondition() {
        return condition;
    }

    /** Accepts only the three conditions supported by this small project. */
    public void setCondition(String newCondition) {
        if ("Unknown".equals(newCondition)
                || "Working".equals(newCondition)
                || "Not working".equals(newCondition)) {
            condition = newCondition;
        } else {
            System.out.println("Use Unknown, Working or Not working. Value unchanged.");
        }
    }

    /** Returns the number of identical units represented by the record. */
    public int getQuantity() {
        return quantity;
    }

    /** Refuses a negative quantity and keeps the existing value. */
    public void setQuantity(int newQuantity) {
        if (newQuantity < 0) {
            System.out.println("Quantity cannot be negative. Value unchanged.");
        } else {
            quantity = newQuantity;
        }
    }

    /** Returns the price of one unit in Malaysian ringgit. */
    public double getUnitPrice() {
        return unitPrice;
    }

    /** Accepts finite, non-negative prices and keeps the old value otherwise. */
    public void setUnitPrice(double newUnitPrice) {
        if (!Double.isFinite(newUnitPrice) || newUnitPrice < 0) {
            System.out.println("Unit price must be finite and non-negative. Value unchanged.");
        } else {
            unitPrice = newUnitPrice;
        }
    }

    /** Returns whether this record has been checked during the current week. */
    public boolean getCheckedThisWeek() {
        return checkedThisWeek;
    }

    /** Updates the flag; a previous condition can remain for reference. */
    public void setCheckedThisWeek(boolean newCheckedThisWeek) {
        checkedThisWeek = newCheckedThisWeek;
    }

    /** Additional method 1: calculates the value of every unit in this record. */
    public double calculateTotalValue() {
        return quantity * unitPrice;
    }

    /** Additional method 2: checks whether the stored condition needs repair. */
    public boolean needsMaintenance() {
        return "Not working".equals(condition);
    }

    /**
     * Additional method 3: records a known inspection result and marks it current.
     * Every unit in this simplified record receives the same inspection result.
     */
    public void recordInspection(String result) {
        if ("Working".equals(result) || "Not working".equals(result)) {
            setCondition(result);
            setCheckedThisWeek(true);
            System.out.println("Inspection recorded for " + assetId + ": " + condition);
        } else {
            System.out.println("Inspection must be Working or Not working. Record unchanged.");
        }
    }
}
