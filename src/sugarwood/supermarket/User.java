package sugarwood.supermarket;

public class User {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String mail;
    private String password;
    
    public User(int id, String name, String address, String phone, String mail,
                                                            String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        String text = "ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Addr: " + getAddress()+ "\n" +
                "Phone: " + getPhone()+ "\n" +
                "Mail: " + getMail() + "\n" +
                "Pwd: " + getPassword()+ "\n";
        
        return text;
    }
}
