package Models;

import java.sql.Date;

public class Donkey extends PackAnimals{
    private String name;
    private Date birthDate;
    private String commands;

    public Donkey(int id, String animalGroups, String type, String name, Date birthDate, String commands) {
        super(id, animalGroups, type);
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getCommands() {
        return commands;
    }
}
