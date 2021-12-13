package utez.gms.eda.cool.bean;

public class BeanBrand {
    private int id_brand;
    private String name_brand;
    private String description;

    public BeanBrand(String name_brand, String description) {
        this.name_brand = name_brand;
        this.description = description;
    }

    public int getId_brand() {
        return id_brand;
    }

    public void setId_brand(int id_brand) {
        this.id_brand = id_brand;
    }

    public String getName_brand() {
        return name_brand;
    }

    public void setName_brand(String name_brand) {
        this.name_brand = name_brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
