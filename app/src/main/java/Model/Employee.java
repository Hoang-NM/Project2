package Model;

import com.google.gson.annotations.SerializedName;

public class Employee {
    @SerializedName("id")
    private int eId;
    @SerializedName("name")
    private String eName;
    private String address;
    private String dob;
    private String start;
    private String end;
    private int phone;
    private String position;

    public Employee() {
    }

    public Employee(int eId, String eName, int phone, String position) {
        this.eId = eId;
        this.eName = eName;
        this.phone = phone;
        this.position = position;
    }

    public Employee(int eId, String eName, String address, String dob, String start, String end, int phone, String position) {
        this.eId = eId;
        this.eName = eName;
        this.address = address;
        this.dob = dob;
        this.start = start;
        this.end = end;
        this.phone = phone;
        this.position = position;
    }

    public int getEId() {
        return eId;
    }

    public void setEId(int eId) {
        this.eId = eId;
    }

    public String getEName() {
        return eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
