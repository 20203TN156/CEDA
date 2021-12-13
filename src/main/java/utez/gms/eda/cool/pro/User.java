package utez.gms.eda.cool.pro;

import utez.gms.eda.cool.bean.BeanUser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utez.gms.eda.cool.Conexion.getConnection;

public class User {

    public boolean validate(BeanUser beanUser) throws SQLException {

        boolean status;

        PreparedStatement preparedStatement = getConnection().prepareStatement(
                "select * from user where user = ? and password = ? ");
        preparedStatement.setString(1, beanUser.getUser());
        preparedStatement.setString(2, beanUser.getPassword());
        ResultSet rs = preparedStatement.executeQuery();
        status = rs.next();
        return status;
    }
}
