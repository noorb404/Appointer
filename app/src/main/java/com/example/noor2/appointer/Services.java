package com.example.noor2.appointer;

public class Services {
    private String ServiceName;
    private String SerivcePrice;
    private String ServiceTime;
    private String CustomerName;
    private String ProName;
    private int ID;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    Services(int id, String Name, String Price, String Time, String customerName, String proName)
    {

        this.CustomerName=customerName;
        this.ProName=proName;
        this.ID=id;
        this.SerivcePrice=Price;
        this.ServiceName=Name;

        this.ServiceTime=Time;

    }


    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getProName() {
        return ProName;
    }

    public void setProName(String proName) {
        ProName = proName;
    }
    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public String getSerivcePrice() {
        return SerivcePrice;
    }

    public void setSerivcePrice(String serivcePrice) {
        SerivcePrice = serivcePrice;
    }

    public String getServiceTime() {
        return ServiceTime;
    }

    public void setServiceTime(String serviceTime) {
        ServiceTime = serviceTime;
    }

}
