package utez.gms.eda.cool.pro;

import utez.gms.eda.cool.bean.BeanProduct;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static utez.gms.eda.cool.Conexion.getConnection;

public class Product {

    public void insertProduct(BeanProduct beanProduct) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement("INSERT INTO product (name_product, quantity, price, description, " +
                    "brand_id_brand, category_id_category) VALUES (?, ?, ?, ?, ?, ?);");
            pst.setString(1, beanProduct.getName());
            pst.setInt(2, beanProduct.getQuantity());
            pst.setInt(3, beanProduct.getPrice());
            pst.setString(4, beanProduct.getDescription());
            pst.setInt(5, beanProduct.getBarnd_id_brand());
            pst.setInt(6, beanProduct.getCategory_id_category());
            pst.executeUpdate();
            System.out.println("Producto insertado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}