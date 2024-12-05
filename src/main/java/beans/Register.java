package beans;

public class Register {
    private int regid;
    private String fname;
    private String lname;
    private String email;
    private String pass;
    private long mobile;
    private String address;

    public Register(int regid, String fname, String lname, String email, String pass, long mobile, String address) {
        super();
        this.regid = regid;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.pass = pass;
        this.mobile = mobile;
        this.address = address;
    }

    public int getRegid() {
        return regid;
    }

    public void setRegid(int regid) {
        this.regid = regid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return regid + " " + fname + " " + lname + " " + email + " " + pass + " " + mobile + " " + address;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj){
        boolean flag = false;
        if (obj instanceof Register){
            Register reg = (Register) obj;
            if(this.regid == reg.regid && this.fname.equals(reg.fname) && this.lname.equals(reg.lname) && this.email.equals(reg.email) && this.pass.equals(reg.pass) && this.mobile == reg.mobile && this.address.equals(reg.address)){
                flag = true;
            }
        }
        return flag;
    }
}