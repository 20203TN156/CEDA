package utez.gms.eda.cool;

import utez.gms.eda.cool.bean.BeanBrand;
import utez.gms.eda.cool.bean.BeanCategory;
import utez.gms.eda.cool.pro.Brand;
import utez.gms.eda.cool.pro.Category;
import utez.gms.eda.cool.pro.LogIn;

import java.sql.SQLException;
import java.util.Scanner;

public class Final {
    public void finalPrint() throws SQLException {
        Scanner print = new Scanner(System.in);
        LogIn logIn = new LogIn();
        logIn.printLogIng();
        int cambio;
        String name, description;
        System.out.print("Elige una opción: ");
        System.out.println();
        System.out.println("\n1. Marca\n2. Categoría\n3. Producto");
        cambio = print.nextInt();
        switch (cambio){
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
                break;
            default:
                break;
        }
    }
}
