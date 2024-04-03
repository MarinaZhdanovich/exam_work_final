package Model;

import java.sql.Date;

public class Camel extends PackAnimals{
    private String name;
    private Date birthDate;
    private String commands;

    public Camel(int id, String animalGroups, String type, String name, Date birthDate, String commands) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return getId() + " " + getType() + " " + name + " " + birthDate + " " + commands;
    }
}
