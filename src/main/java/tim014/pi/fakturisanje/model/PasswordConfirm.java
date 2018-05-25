package tim014.pi.fakturisanje.model;

public class PasswordConfirm {
    private String oldPassword;
    private String password;
    private String confirmPassword;

    public  PasswordConfirm(){}

    public PasswordConfirm(String password, String confirmPassword, String oldPassword) {
        this.password = password;
        this.oldPassword = oldPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
