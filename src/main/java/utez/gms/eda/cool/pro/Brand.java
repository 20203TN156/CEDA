package utez.gms.eda.cool.pro;

import utez.gms.eda.cool.bean.BeanBrand;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static utez.gms.eda.cool.Conexion.getConnection;

public class Brand {

    public void insertBrand(BeanBrand beanBrand) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement("INSERT INTO brand (name_brand, description) VALUES (?, ?);");
            pst.setString(1, beanBrand.getName_brand());
            pst.setString(2, beanBrand.getDescription());
            pst.executeUpdate();
            System.out.println("Dato insertado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
