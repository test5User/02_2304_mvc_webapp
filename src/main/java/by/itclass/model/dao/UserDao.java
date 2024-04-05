package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static final String QUERY1 = "SELECT id, email FROM user WHERE fio LIKE ?";
    public static final String QUERY2 = "SELECT id, fio, email FROM user WHERE id >= ? AND id <= ?";

    public User findUserByFio(String fio) {
        try (var cn = ConnectionManager.getConnection();
            var ps = cn.prepareStatement(QUERY1)){
            ps.setString(1, fio);
            var rs = ps.executeQuery();
            if (rs.next()) {
                var id = rs.getInt("id");
                var email = rs.getString("email");
                return new User(id, fio, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findUsersByIds(int fromId, int toId) {
        List<User> users = new ArrayList<>();
        try (var cn = ConnectionManager.getConnection();
            var ps = cn.prepareStatement(QUERY2)) {
            ps.setInt(1, fromId);
            ps.setInt(2, toId);
            var rs = ps.executeQuery();
            while (rs.next()) {
                var id = rs.getInt("id");
                var fio = rs.getString("fio");
                var email = rs.getString("email");
                users.add(new User(id, fio, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
