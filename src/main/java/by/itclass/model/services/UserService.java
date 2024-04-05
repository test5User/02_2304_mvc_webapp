package by.itclass.model.services;

import by.itclass.model.dao.UserDao;
import by.itclass.model.db.DbInMemory;
import by.itclass.model.entities.User;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    private final UserDao dao;

    public UserService() {
       dao = new UserDao();
    }

//    public List<User> getUsersByCriteria(Map<String, String[]> params) {
//        var users = new ArrayList<User>();
//        var criteria = params.get("criteria")[0];
//        switch (criteria) {
//            case "fio" : {
//                var fio = params.get("fio")[0];
//                users.add(DbInMemory.findUserByFio(fio));
//                users = users.stream()
//                        .filter(Objects::nonNull)
//                        .collect(Collectors.toCollection(ArrayList::new));
//                break;
//            }
//            case "id" : {
//                var fromId = Integer.parseInt(params.get("fromId")[0]);
//                var toId = Integer.parseInt(params.get("toId")[0]);
//                users = new ArrayList<>(DbInMemory.findUsersByIds(fromId, toId));
//                break;
//            }
//            default: break;
//        }
//        return users;
//    }

    public List<User> getUsersByCriteria(Map<String, String[]> params) {
        List<User> users = new ArrayList<>();
        var criteria = params.get("criteria")[0];
        switch (criteria) {
            case "fio" -> {
                users.add(dao.findUserByFio(params.get("fio")[0]));
                users = users.stream().filter(Objects::nonNull).toList();
            }
            case "id" -> {
                var fromId = Integer.parseInt(params.get("fromId")[0]);
                var toId = Integer.parseInt(params.get("toId")[0]);
                users = dao.findUsersByIds(fromId, toId);
            }
        }
        return users;
    }
}
