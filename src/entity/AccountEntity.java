package entity;

public class AccountEntity {
    private int accountId;
    private String password;
    private String name;

    public AccountEntity() {
    }

    public AccountEntity(String password, String name) {
        this.password = password;
        this.name = name;
    }

    public AccountEntity(int accountId, String password, String name) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "accountId=" + accountId +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
