package Model;

import com.google.gson.annotations.SerializedName;

public class WorkOff {
    @SerializedName("e_id")
    private int eId;
    @SerializedName("id")
    private int wId;
    @SerializedName("dateoff")
    private String dayOff;
    @SerializedName("timeoff")
    private String timeOff;
    private String reason;

    public WorkOff(int eId, String dayOff, String timeOff, String reason) {
        this.eId = eId;
        this.dayOff = dayOff;
        this.timeOff = timeOff;
        this.reason = reason;
    }

    public WorkOff(int eId, int wId, String timeOff, String dayOff, String reason) {
        this.eId = eId;
        this.wId = wId;
        this.dayOff = dayOff;
        this.timeOff = timeOff;
        this.reason = reason;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {
        this.wId = wId;
    }

    public String getDayOff() {
        return dayOff;
    }

    public void setDayOff(String dayOff) {
        this.dayOff = dayOff;
    }

    public String getTimeOff() {
        return timeOff;
    }

    public void setTimeOff(String timeOff) {
        this.timeOff = timeOff;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
