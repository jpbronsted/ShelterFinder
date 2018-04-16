package model;

// --Commented out by Inspection START (2018-04-15 오후 11:46):
//public class PhoneNumber {
//    final Integer areaCode;
//    final Integer prefix;
//    final Integer lineNumber;
//
//// --Commented out by Inspection START (2018-04-15 오후 11:46):
////    public PhoneNumber(Integer areaCode, Integer prefix, Integer lineNumber) {
////        this.areaCode = areaCode;
////        this.prefix = prefix;
////        this.lineNumber = lineNumber;
////    }
//// --Commented out by Inspection STOP (2018-04-15 오후 11:46)
//
//// --Commented out by Inspection START (2018-04-15 오후 11:46):
////    public PhoneNumber(Integer number) {
////        this(number / 10000000, (number % 10000000) / 1000, number % 1000);
////    }
//// --Commented out by Inspection STOP (2018-04-15 오후 11:46)
//
//// --Commented out by Inspection START (2018-04-15 오후 11:46):
////    public PhoneNumber(String number) {
////        areaCode = Integer.valueOf(number.substring(number.indexOf('(') + 1,
////                number.indexOf(')')));
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)
//        prefix = Integer.valueOf(number.substring(number.indexOf('-') - 3,
//                number.indexOf('-')));
//        lineNumber = Integer.valueOf(number.substring(number.indexOf("-") + 1));
//    }
// --Commented out by Inspection STOP (2018-04-15 오후 11:46)

    @Override
    public String toString() {
        return "(" + areaCode + ") " + prefix + "-" + lineNumber;
    }
}
