package model;

class PhoneNumber {
    private final Integer areaCode;
    private final Integer prefix;
    private final Integer lineNumber;

    private static final int pn = 10000000;

    private PhoneNumber(Integer areaCode, Integer prefix, Integer lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    public PhoneNumber(Integer number) {
        this(number / pn, (number % pn) / 1000, number % 1000);
    }

    public PhoneNumber(String number) {
        areaCode = Integer.valueOf(number.substring(number.indexOf('(') + 1,
                number.indexOf(')')));
        prefix = Integer.valueOf(number.substring(number.indexOf('-') - 3,
                number.indexOf('-')));
        lineNumber = Integer.valueOf(number.substring(number.indexOf("-") + 1));
    }

    @Override
    public String toString() {
        return "(" + areaCode + ") " + prefix + "-" + lineNumber;
    }
}
