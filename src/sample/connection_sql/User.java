package sample.connection_sql;

public class User {
    public String login;
    public String passwor_reg;
    public String name;
    public String second_name;
    public String date;

    public User(String login, String passwor_reg, String name, String second_name, String date) {
        this.login = login;
        this.passwor_reg = passwor_reg;
        this.name = name;
        this.second_name = second_name;
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswor_reg() {
        return passwor_reg;
    }

    public void setPasswor_reg(String passwor_reg) {
        this.passwor_reg = passwor_reg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
