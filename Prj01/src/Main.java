import com.epam.hometask.entity.Building;
import com.epam.hometask.entity.Furniture;
import com.epam.hometask.entity.LightBulb;
import com.epam.hometask.entity.SoftFurniture;
import com.epam.hometask.exception.IlluminanceTooLittleException;
import com.epam.hometask.exception.IlluminanceTooMuchException;
import com.epam.hometask.exception.SpaceUsageTooMuchException;
import com.epam.hometask.validation.BuildingValidator;

public class Main {

    public static void main(String[] args) {
        BuildingValidator bv = new BuildingValidator();
        Building building = new Building("Building");
        building.addRoom("Room1", 100, 0);
        building.addRoom("Room2", 5, 2);
        building.getRoom("Room1").add(new LightBulb(50));
        building.getRoom("Room1").add(new LightBulb(50));
        building.getRoom("Room1").add(new LightBulb(50));
        building.getRoom("Room1").add(new Furniture("Table", 3));
        building.getRoom("Room1").add(new SoftFurniture("Chair", 1, 2));
        try {
            bv.validateBuilding(building);
        } catch (IlluminanceTooLittleException a) {
            System.out.println(a.getMessage());
            return;
        } catch (IlluminanceTooMuchException b) {
            System.out.println(b.getMessage());
            return;
        } catch (SpaceUsageTooMuchException c) {
            System.out.println(c.getMessage());
            return;
        }
        System.out.println(building.describe());
    }

}
