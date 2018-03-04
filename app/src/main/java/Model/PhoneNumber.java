package Model;

/**
 * Created by jpbronsted on 3/4/18.
 */

public class PhoneNumber {
    Integer areaCode;
    Integer prefix;
    Integer lineNumber;

    public PhoneNumber(Integer areaCode, Integer prefix, Integer lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    public PhoneNumber(Integer number) {
        this(number / 10000000, (number % 10000000) / 1000, number % 1000);
    }

    @Override
    public String toString() {
        return "(" + areaCode + ") " + prefix + "-" + lineNumber;
    }
}
