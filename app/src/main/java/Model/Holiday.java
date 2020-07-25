package Model;

import com.google.gson.annotations.SerializedName;

public class Holiday {
    @SerializedName("id")
    private int hId;
    @SerializedName("name")
    private String hName;
    @SerializedName("dateoff")
    private String date;
    private int dayOffs;
    private String infor;

    public Holiday(String date, int dayOffs) {
        this.date = date;
        this.dayOffs = dayOffs;
    }

    public Holiday(String hName, String date, String infor) {
        this.hName = hName;
        this.date = date;
        this.infor = infor;
    }

    public int getHId() {
        return hId;
    }

    public void setHId(int hId) {
        this.hId = hId;
    }

    public String getHName() {
        return hName;
    }

    public void setHName(String hName) {
        this.hName = hName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDayOffs() {
        return dayOffs;
    }

    public void setDayOffs(int dayOffs) {
        this.dayOffs = dayOffs;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }
}
