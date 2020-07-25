package Model;

import com.google.gson.annotations.SerializedName;

public class Salary {
    @SerializedName("e_id")
    private int eId;
    @SerializedName("id")
    private int sId;
    @SerializedName("time")
    private String sDate;
    private int pay;
    @SerializedName("figure")
    private double coefficient;
    @SerializedName("reward")
    private double bonus;
    private String note;
    private int sub;
    private int total;

    public Salary(int eId, String sDate, String note, int total) {
        this.eId = eId;
        this.sDate = sDate;
        this.note = note;
        this.total = total;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getSub() {
        return sub;
    }

    public void setSub(int sub) {
        this.sub = sub;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
