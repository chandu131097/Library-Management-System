public class Person {
    private String name;
    private String mobileNum;
    private String address;

    public Person(String name , String mobileNum , String address){
        this.address = address;
        this.mobileNum = mobileNum;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public void setName(String name) {
        this.name = name;
    }
}
