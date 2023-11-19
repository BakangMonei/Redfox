package dao;

import bean.Admin;
public class AdminDataHolder {
    private Admin admin;
    private final static AdminDataHolder INSTANCE = new AdminDataHolder();

    private AdminDataHolder(){}

    public static AdminDataHolder getInstance(){
        return INSTANCE;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
