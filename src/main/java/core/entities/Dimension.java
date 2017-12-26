package core.entities;

/**
 * Created by Altair on 26.09.2017.
 */
public class Dimension extends DataObject {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (object != null || object instanceof Dimension) {
            Dimension dimension = (Dimension) object;
            if (this.getId() != null && dimension.getId() != null && this.getId().equals(dimension.getId())) {
                return true;
            }
            if (this.name != null && this.name.equals(dimension.name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (getId() != null) {
            long id = getId();
            return (int) id * 10;
        } else {
            return name.hashCode();
        }

    }

    @Override
    public String toString() {
        return "Dimension: " + name;
    }
}
