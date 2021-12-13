package utez.gms.eda.cool;

import utez.gms.eda.cool.bean.BeanBrand;
import utez.gms.eda.cool.bean.BeanCategory;
import utez.gms.eda.cool.bean.BeanProduct;
import utez.gms.eda.cool.pro.Brand;
import utez.gms.eda.cool.pro.Category;
import utez.gms.eda.cool.pro.LogIn;
import utez.gms.eda.cool.pro.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static utez.gms.eda.cool.Conexion.getConnection;

public class Final {
    public void finalPrint() throws SQLException {
        Scanner print = new Scanner(System.in);
        LogIn logIn = new LogIn();
        logIn.printLogIng();
        int cambio;
        String name, description;
        int barnd_id_brand, category_id_category;
        int price, quantity;
        System.out.print("Elige una opción: ");
        System.out.println();
        System.out.println("\n1. Registrar\n2. Consultar");

        cambio = print.nextInt();

        switch (cambio) {
            case 1:
                System.out.print("Elige una opción: ");
                System.out.println();
                System.out.println("\n1. Marca\n2. Categoría\n3. Producto");
                cambio = print.nextInt();
                switch (cambio) {
                    case 1:
                        Brand brand = new Brand();
                        System.out.print("Marca: ");
                        name = print.next();
                        System.out.print("Descripción de la marca: ");
                        description = print.next();
                        BeanBrand beanBrand = new BeanBrand(name, description);
                        brand.insertBrand(beanBrand);
                        break;
                    case 2:
                        Category category = new Category();
                        System.out.print("Categoría: ");
                        name = print.next();
                        System.out.print("Descripción de la categoría: ");
                        description = print.next();
                        BeanCategory beanCategory = new BeanCategory(name, description);
                        category.insertCategory(beanCategory);
                        break;
                    case 3:
                        Product product = new Product();
                        System.out.println("Producto: ");
                        name = print.next();
                        System.out.print("Cantidad: ");
                        quantity = print.nextInt();
                        System.out.print("Precio: ");
                        price = print.nextInt();
                        System.out.print("Descripción del producto: ");
                        description = print.next();
                        printBrand();
                        System.out.println("ID de la marca: ");
                        barnd_id_brand = print.nextInt();
                        printCategory();
                        System.out.println("ID de la categoría");
                        category_id_category = print.nextInt();
                        BeanProduct beanProduct = new BeanProduct(name, quantity, price, description,
                                barnd_id_brand, category_id_category);
                        product.insertProduct(beanProduct);
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                System.out.print("Elige una opción: ");
                System.out.println();
                System.out.println("\n1. Marca\n2. Categoría\n3. Producto");
                cambio = print.nextInt();
                switch (cambio) {
                    case 1:
                        printBrand();
                        break;
                    case 2:
                        printCategory();
                        break;
                    case 3:
                        printProduct();
                        break;
                }
                break;
        }

    }

    public void printBrand() {
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM brand");
            System.out.println("-----------------------------------");
            System.out.println("\u001B[32m" + "ID | Nombre de la marca | Descripción");
            while (rs.next()) {
                //int id_brand = rs.getInt(beanBrand.getId_brand());
                String id_brand = rs.getString("id_brand");
                String name_brand = rs.getString("name_brand");
                String description = rs.getString("description");


                System.out.format("\u001B[0m"+ "%s | %s | %s\n", id_brand, name_brand, description);
            }
            System.out.println("-----------------------------------");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printCategory() {
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            System.out.println("-----------------------------------");
            System.out.println("\u001B[32m" + "ID | Nombre de la categoría | Descripción");
            while (rs.next()) {
                //int id_brand = rs.getInt(beanBrand.getId_brand());
                String id_category = rs.getString("id_category");
                String name_category = rs.getString("name_category");
                String description = rs.getString("description");


                System.out.format("\u001B[0m"+ "%s | %s | %s\n", id_category, name_category, description);
            }
            System.out.println("-----------------------------------");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printProduct() {
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT id_product, name_product, quantity, price , 'description', name_category, name_brand FROM product a\n" +
                    "inner join category b on a.category_id_category = b.id_category inner join brand c on a.brand_id_brand = c.id_brand;");
            System.out.println("-----------------------------------");
            System.out.println("\u001B[32m" + "ID | Nombre del producto | Cantidad, | Precio | Descripción | Categoría | Marca");
            while (rs.next()) {
                //int id_brand = rs.getInt(beanBrand.getId_brand());
                String id_product= rs.getString("id_product");
                String name_product = rs.getString("name_product");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                String description = rs.getString("description");
                String brand_id_brand = rs.getString("name_category");
                String category_id_category = rs.getString("name_brand");



                System.out.format("\u001B[0m"+ "%s | %s | %s | %s | %s | %s | %s\n", id_product, name_product, quantity,
                        price, description,brand_id_brand, category_id_category);
            }
            System.out.println("-----------------------------------");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
