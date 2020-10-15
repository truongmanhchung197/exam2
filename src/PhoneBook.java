public class PhoneBook {
    private String tel;
    private String group;
    private String fullName;
    private String gender;
    private String address;
    private String dateOFBirth;
    private String email;

    public PhoneBook(){
    }

    public PhoneBook(String tel, String group, String fullName, String gender, String address, String dateOFBirth, String email) {
        this.tel = tel;
        this.group = group;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.dateOFBirth = dateOFBirth;
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOFBirth() {
        return dateOFBirth;
    }

    public void setDateOFBirth(String dateOFBirth) {
        this.dateOFBirth = dateOFBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void display(){
        System.out.println(tel+", "+group+", "+fullName+", "+gender+", "+address+", "+dateOFBirth+", "+email);
    }
}
