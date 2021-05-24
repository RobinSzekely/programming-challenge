package de.exxcellent.challenge.models;

/**
 * Represents daily weather data of a single month, measured by various environmental variables
 */
public class Weather implements FileObject {
    private int day;
    private int mxt;
    private int mnt;
    private int avt;
    private double avdp;
    private int oneHrp_tpcpn;
    private int pdir;
    private double avsp;
    private int dir;
    private int mxs;
    private double skyc;
    private int mxr;
    private int mn;
    private double r_avslp;

    /**
     * Constructs minimal Weather object with three parameters required for programming challenge
     * @param day number of the day in a single month
     * @param mxt maximum temperature of the specific day
     * @param mnt minimum temperature of the specific day
     */
    public Weather(int day, int mxt, int mnt) {
        this.day = day;
        this.mxt = mxt;
        this.mnt = mnt;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMxt() {
        return mxt;
    }

    public void setMxt(int mxt) {
        this.mxt = mxt;
    }

    public int getMnt() {
        return mnt;
    }

    public void setMnt(int mnt) {
        this.mnt = mnt;
    }

    public int getAvt() {
        return avt;
    }

    public void setAvt(int avt) {
        this.avt = avt;
    }

    public double getAvdp() {
        return avdp;
    }

    public void setAvdp(double avdp) {
        this.avdp = avdp;
    }

    public int getOneHrp_tpcpn() {
        return oneHrp_tpcpn;
    }

    public void setOneHrp_tpcpn(int oneHrp_tpcpn) {
        this.oneHrp_tpcpn = oneHrp_tpcpn;
    }

    public int getPdir() {
        return pdir;
    }

    public void setPdir(int pdir) {
        this.pdir = pdir;
    }

    public double getAvsp() {
        return avsp;
    }

    public void setAvsp(double avsp) {
        this.avsp = avsp;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getMxs() {
        return mxs;
    }

    public void setMxs(int mxs) {
        this.mxs = mxs;
    }

    public double getSkyc() {
        return skyc;
    }

    public void setSkyc(double skyc) {
        this.skyc = skyc;
    }

    public int getMxr() {
        return mxr;
    }

    public void setMxr(int mxr) {
        this.mxr = mxr;
    }

    public int getMn() {
        return mn;
    }

    public void setMn(int mn) {
        this.mn = mn;
    }

    public double getR_avslp() {
        return r_avslp;
    }

    public void setR_avslp(double r_avslp) {
        this.r_avslp = r_avslp;
    }

    @Override
    public String toString() {
        return day + "," + mxt + "," + mnt + "," + avt + "," + avdp + "," +
                + oneHrp_tpcpn + "," + pdir + "," + avsp + "," + dir + ","
                + mxs + "," + skyc + "," + mxr + "," + mn + "," + r_avslp;
    }
}