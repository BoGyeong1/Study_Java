package beans;

public class MemberBean {
    private String firstName;
    private String secondName;
    private String handleName;

    public MemberBean(String firstName, String secondName, String handleName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.handleName = handleName;

    }

    public MemberBean() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getHandleName() {
        return this.handleName;
    }

    public void setHandleName(String handleName) {
        this.handleName = handleName;
    }

}
