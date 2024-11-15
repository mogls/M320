public class Time {

    private int second;
    private int minute;
    private int hour;

    private final RangeChecker secondChecker;
    private final RangeChecker minuteChecker;
    private final RangeChecker hourChecker;


    // constructors
    public Time() {
        this.secondChecker = new RangeChecker("Second", 0, 59);
        this.minuteChecker = new RangeChecker("Minute", 0, 59);
        this.hourChecker = new RangeChecker("Hour", 0, 23);

        this.second = 0;
        this.minute = 0;
        this.hour = 0;
    }

    public Time(int sec, int min, int h) throws Exception {
        this.secondChecker = new RangeChecker("Second", 0, 59);
        this.minuteChecker = new RangeChecker("Minute", 0, 59);
        this.hourChecker = new RangeChecker("Hour", 0, 23);

        this.secondChecker.confine(sec);
        this.minuteChecker.confine(min);
        this.hourChecker.confine(h);

        this.second = sec;
        this.minute = min;
        this.hour = h;
    }

    // getters
    public int getHour() {
        return this.hour;
    }
    public int getMinute() {
        return this.minute;
    }
    public int getSecond() {
        return this.second;
    }

    // setters
    public void setHour(int hour) throws Exception {
        this.hourChecker.confine(hour);
        this.hour = hour;
    }

    public void setMinute(int minute) throws Exception {
        this.minuteChecker.confine(minute);
        this.minute = minute;
    }

    public void setSecond(int second) throws Exception {
        this.secondChecker.confine(second);
        this.second = second;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }

    public void setTime(int second, int minute, int hour) throws Exception {
        this.hourChecker.confine(hour);
        this.minuteChecker.confine(minute);
        this.secondChecker.confine(second);

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time nextSecond() {
        // check for overflow into next scale.
        if (this.second < 59) {
            this.second++;
            return this;
        } else if (this.minute < 59) {
            this.second = 0;
            this.minute++;
            return this;
        } else if (this.hour < 23) {
            this.second = 0;
            this.minute = 0;
            this.hour++;
            return this;
        }

        this.second = 0;
        this.minute = 0;
        this.hour = 0;

        return this;
    }

}
