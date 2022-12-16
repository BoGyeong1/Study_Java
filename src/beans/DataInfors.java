package beans;

public class DataInfors {
    public MemberBean getDataWithMemberBean() {
        MemberBean memberBean = new MemberBean();
        memberBean.setFirstName("Mark");
        memberBean.setSecondName("otto");
        memberBean.setHandleName("@mdo");

        return memberBean;
    }

}
