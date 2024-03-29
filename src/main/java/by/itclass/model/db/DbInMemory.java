package by.itclass.model.db;

import by.itclass.model.entities.User;

import java.util.ArrayList;
import java.util.List;

public class DbInMemory {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "Vasia Pupkin", "vasiok@mail.ru"));
        users.add(new User(2, "Igor Oblomov", "igoriok@yandex.ru"));
        users.add(new User(3, "Ivan Ivanov", "vano@google.com"));
        users.add(new User(4, "Ivan Dulin", "dulia@yahoo.com"));
    }

    public static boolean isPresentByFio(String fio) {
        return users.stream()
                .anyMatch(user -> user.getFio().equals(fio));
    }
}
