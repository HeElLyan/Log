public class Goods {
    public static int current_id = 0;
    public int id;
    public String product;
    public int count;

    public Goods(String product, int id) {
        this.id = id;
        this.product = product;
    }

    public int getId(){
        return id;
    }

    public String getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }
}
