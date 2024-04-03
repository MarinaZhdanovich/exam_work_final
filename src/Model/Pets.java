package Model;

public class Pets extends Animals{
    protected String type;

    public Pets(int id, String animalGroups, String type) {
        super(id, animalGroups);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
