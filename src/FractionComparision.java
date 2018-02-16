public class FractionComparision implements Comparable<FractionComparision> {
    private String value;
    private int numerator;
    private int denominator;

    FractionComparision(String inputString) {
        if (!inputString.contains("/")) {
            this.numerator = Integer.parseInt(inputString);
            this.denominator = 1;
            this.value = numerator + "/" + "1";
        } else {
            try {
                String[] slash = inputString.split("/");
                this.numerator = Integer.parseInt(slash[0]);
                this.denominator = Integer.parseInt(slash[1]);
                this.value = inputString;
            } catch (Exception e) {
                throw new NonNumericException("Improperly formatted fraction found!", "Improper Fraction");
            }
        }
    }

    public String toString() {
        return value;
    }

    public int compareTo(FractionComparision otherString) {
        int a = numerator * otherString.denominator;
        int b = otherString.numerator * denominator;
        return a - b;
    }
}
