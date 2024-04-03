package Models;

public class PackAnimals extends Animals{
    protected String type;

    public PackAnimals(int id, String animalGroups, String type) {
        super(id, animalGroups);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
