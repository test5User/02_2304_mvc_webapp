package by.itclass.model.services;

import by.itclass.model.db.DbInMemory;
import by.itclass.model.entities.User;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    private static List<User> getUsersByCriteria(Map<String, String[]> params) {
        var users = new ArrayList<User>();
        var criteria = params.get("criteria")[0];
        switch (criteria) {
            case "fio" : {
                var fio = params.get("fio")[0];
                users.add(DbInMemory.findUserByFio(fio));
                users = users.stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.toCollection(ArrayList::new));
                break;
            }
            case "id" : {
                var fromId = Integer.parseInt(params.get("fromId")[0]);
                var toId = Integer.parseInt(params.get("toId")[0]);
                users = (ArrayList<User>) DbInMemory.findUsersByIds(fromId, toId);
                break;
            }
            default: break;
        }
        return users;
    }
}
