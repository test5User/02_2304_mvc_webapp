package by.itclass.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private int id;
    private String fio;
    private String email;
}
