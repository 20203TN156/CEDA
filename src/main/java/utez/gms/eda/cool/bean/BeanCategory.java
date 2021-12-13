package utez.gms.eda.cool.bean;

public class BeanCategory {
    private int id_category;
    private String name_category;
    private String description;

    public BeanCategory(String name_category, String description) {
        this.name_category = name_category;
        this.description = description;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
