package utez.gms.eda.cool.pro;

import utez.gms.eda.cool.bean.BeanBrand;
import utez.gms.eda.cool.bean.BeanCategory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static utez.gms.eda.cool.Conexion.getConnection;

public class Category {

    public void insertCategory(BeanCategory beanCategory) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement("INSERT INTO category (name_category, description) VALUES (?, ?);");
            pst.setString(1, beanCategory.getName_category());
            pst.setString(2, beanCategory.getDescription());
            pst.executeUpdate();
            System.out.println("Dato insertado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
