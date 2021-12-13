package utez.gms.eda.cool.bean;

public class BeanProduct {
    private int id_product;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private int barnd_id_brand;
    private int category_id_category;
    private BeanBrand beanBrand;
    private BeanCategory beanCategory;

    public BeanBrand getBeanBrand() {
        return beanBrand;
    }

    public void setBeanBrand(BeanBrand beanBrand) {
        this.beanBrand = beanBrand;
    }

    public BeanCategory getBeanCategory() {
        return beanCategory;
    }

    public void setBeanCategory(BeanCategory beanCategory) {
        this.beanCategory = beanCategory;
    }

    public BeanProduct(String name, int quantity, double price, String description, int brand_id_brand,
                       int category_id_category) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.barnd_id_brand = brand_id_brand;
        this.category_id_category = category_id_category;
    }

    public BeanProduct() {

    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBarnd_id_brand() {
        return barnd_id_brand;
    }

    public void setBarnd_id_brand(int barnd_id_brand) {
        this.barnd_id_brand = barnd_id_brand;
    }

    public int getCategory_id_category() {
        return category_id_category;
    }

    public void setCategory_id_category(int category_id_category) {
        this.category_id_category = category_id_category;
    }
}