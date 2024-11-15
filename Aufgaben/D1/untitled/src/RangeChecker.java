public class RangeChecker {

    private double lBound;
    private double uBound;
    private String inputName;

    private String message;

    public RangeChecker(String inputName, double lBound, double uBound) {
        this.lBound = lBound;
        this.uBound = uBound;
        this.inputName = inputName;
        this.message = " needs to be in the range of ";
    }

    public void confine(double input) throws Exception {
        if (input < this.lBound || input > this.uBound) {
            String message = formatMessage();
            throw new Exception(message);
        }
    }

    public  void confine(double input, double lBound, double uBound) throws Exception {
        if (input < lBound || input > uBound) {
            String message = formatMessage(lBound, uBound);
            throw new Exception(message);
        }
    }
//    public void confine(double input, int lBound, int uBound) throws Exception {
//        if (input < lBound || input > uBound) {
//            String message = formatMessage(lBound, uBound);
//            throw new Exception(message);
//        }
//    }
//    public void confine(int input, int lBound, int uBound) throws Exception {
//        if (input < lBound || input > uBound) {
//            String message = formatMessage(lBound, uBound);
//            throw new Exception(message);
//        }
//    }
//    public void confine(int input, double lBound, double uBound) throws Exception {
//        if (input < lBound || input > uBound) {
//            String message = formatMessage(lBound, uBound);
//            throw new Exception(message);
//        }
//    }
//
//    private String formatMessage(int lBound, int uBound) {
//        return "Input" + this.message + String.format("[%d, %d]", lBound, uBound);
//    }
    private String formatMessage(double lBound, double uBound) {
        return "Input" + this.message + String.format("[%f, %f]", lBound, uBound);
    }
    private String formatMessage() {
        return this.inputName + this.message + String.format("[%f, %f]", this.lBound, this.uBound);
    }

}
