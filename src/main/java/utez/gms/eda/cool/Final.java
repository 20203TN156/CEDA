package utez.gms.eda.cool;

import utez.gms.eda.cool.bean.BeanBrand;
import utez.gms.eda.cool.bean.BeanCategory;
import utez.gms.eda.cool.bean.BeanProduct;
import utez.gms.eda.cool.pro.Brand;
import utez.gms.eda.cool.pro.Category;
import utez.gms.eda.cool.pro.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static utez.gms.eda.cool.Conexion.getConnection;

public class Final {
    public void finalPrint() {
        int repeat;
        do {
            Scanner print = new Scanner(System.in);
            int cambio;
            String name, description;
            int barnd_id_brand, category_id_category;
            int price, quantity;
            int id_delete, id_update;
            repeat = 1;

            //Selección de acción
            System.out.print("Elige una opción: ");
            System.out.println();
            System.out.println("\n1. Registrar\n2. Consultar\n3. Actualizar\n4. Eliminar");

            cambio = print.nextInt();
            //Ingresar
            switch (cambio) {
                case 1:
                    System.out.print("Elige una opción: ");
                    System.out.println();
                    System.out.println("\n1. Marca\n2. Categoría\n3. Producto\n4. Cancelar");
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
                        case 4:
                            repeat = 2;
                        default:
                            break;
                    }
                    break;
                    //Consultar
                case 2:
                    System.out.print("Elige una opción: ");
                    System.out.println();
                    System.out.println("\n1. Marca\n2. Categoría\n3. Producto\n4. Cancelar");
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
                        case 4:
                            repeat = 2;
                            break;
                    }
                    break;
                    //Eliminar
                case 3:
                    //Actualizar
                    System.out.print("Elige una opción: ");
                    System.out.println();
                    System.out.println("\n1. Marca\n2. Categoría\n3. Producto\n4. Cancelar");
                    cambio = print.nextInt();
                    switch (cambio) {
                        case 1:

                            break;
                        case 2:
                            printCategory();
                            System.out.print("Categoría a actualizar: ");
                            id_update = print.nextInt();
                            System.out.print("Nombre: ");
                            name = print.next();
                            System.out.print("Descrición: ");
                            description = print.next();
                            updateCategory(name,description , id_update);
                            break;
                        case 3:
                            break;
                        case 4:
                            repeat = 2;
                            break;
                    }
                    break;
                case 4:
                    //Eliminar
                    System.out.println("\n1. Marca\n2. Categoría\n3. Producto\n4. Cancelar");
                    cambio = print.nextInt();
                    switch (cambio) {
                        case 1:
                            printBrand();
                            System.out.print("Marca a eliminar: ");
                            id_delete = print.nextInt();
                            deleteBrand(id_delete);
                            break;
                        case 2:
                            printCategory();
                            id_delete = print.nextInt();
                            deleteCategory(id_delete);
                            break;
                        case 3:
                            printProduct();
                            id_delete = print.nextInt();
                            deleteProduct(id_delete);
                            break;
                            //Cancelar
                        case 4:
                            repeat = 2;
                            break;
                    }
                    break;
            }
            System.out.println("Ingresa «1» para continuar con el programa o cualquier número para salir");
            repeat = print.nextInt();
        } while (repeat == 1);
    }

    public void printBrand() {
        Lista lista = new Lista();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM brand");
            System.out.println("-----------------------------------");
            System.out.println("\u001B[32m" + "ID | Nombre de la marca | Descripción");
            while (rs.next()) {
                BeanBrand beanBrand = new BeanBrand();
                beanBrand.setId_brand(rs.getInt(1));
                beanBrand.setName_brand(rs.getString(2));
                beanBrand.setDescription(rs.getString(3));
                //int id_brand = rs.getInt(beanBrand.getId_brand());
                int id_brand = rs.getInt("id_brand");
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
                int id_category = rs.getInt("id_category");
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
                int id_product= rs.getInt("id_product");
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

    public void deleteBrand(int id_brand) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement("DELETE FROM brand WHERE (id_brand = ?);");
            pst.setInt(1, id_brand);
            pst.execute();
            pst.close();
            System.out.println("Marca eliminada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(int id_category)  {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement("DELETE FROM category WHERE (id_category = ?);");
            pst.setInt(1, id_category);
            pst.execute();
            pst.close();
            System.out.println("Categoría eliminada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id_product)  {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement("DELETE FROM product WHERE (id_product = ?);");
            pst.setInt(1, id_product);
            pst.execute();
            pst.close();
            System.out.println("Producto eliminado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCategory(String name, String description, int id_category){
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement("UPDATE category SET name_category = ?, description = ? WHERE (id_category = ?);");
            pst.setString(1, name);
            pst.setString(2, description);
            pst.setInt(3, id_category);
            pst.executeUpdate();
            pst.close();
            System.out.println("Categoría actualizada con éxito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
