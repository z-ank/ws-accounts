package loc.zank.services.model;

public class Account {
    private int id;
    private int sum;

    public Account(int id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    public Account(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", sum=" + sum + "}";
    }
}
