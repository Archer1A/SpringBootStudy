package com.hotelhelp.hotelhelp.domain;

public class SendTerminalCheckInSms {
    private String advances;
    private String checkInTime;
    private String checkOutTime;
    private String hotelName;
    private String mobilePhone;
    private String name;
    //public string orderNumber;
    private String roomNumber;
    private String roomType;

    public String getAdvances() {
        return advances;
    }

    public void setAdvances(String advances) {
        this.advances = advances;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public SendTerminalCheckInSms() {
        this.advances = "";
        this.checkInTime = "";
        this.checkOutTime = "";
        this.hotelName = "";
        this.mobilePhone = "15088777251";
        this.name = "";
        this.roomNumber = "";
        this.roomType = "";
    }

    public SendTerminalCheckInSms(String advances, String checkInTime, String checkOutTime, String hotelName, String mobilePhone, String name, String roomNumber, String roomType) {

        this.advances = advances;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.hotelName = hotelName;
        this.mobilePhone = mobilePhone;
        this.name = name;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }
}
