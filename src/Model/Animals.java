package Models;

public class Animals {
    protected int id;
    protected String animalGroups;

    public Animals(int id, String animalGroups) {
        this.id = id;
        this.animalGroups = animalGroups;
    }

    public int getId() {
        return id;
    }

    public String getAnimalGroups() {
        return animalGroups;
    }
}
