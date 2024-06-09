import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


class Destination {
    private String name;
    private Date startDate;
    private Date endDate;

    public Destination(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {    
	    return "Destination{" +
        "name='" + name + '\'' +
		", startDate=" + startDate +
        ", endDate=" + endDate +
    '}';
   }
}

class Preference {
    private String type;
    private String detail;

    public Preference(String type, String detail){
        this.type = type;
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return "Preference{" +
        "type='" + type + '\'' +
        ", detail='" + detail + '\'' +
       '}';
    }
}
class Itinerary {
    private List<Destination> destinations;
    private List<Preference> preferences;

    public Itinerary() {
        this.destinations = new ArrayList<>();
        this.preferences = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        this.destinations.add(destination);
    }

    public void addPreference(Preference preference) {
        this.preferences.add(preference);
    }

    public void generateItinerary() {
          System.out.println("Travel Itinerary:");
         for (Destination destination : destinations) {
            System.out.println(destination);
        }
         System.out.println("Preferences:");
         for (Preference preference : preferences) {
            System.out.println(preference);
		}
	} 
}
public class TravelPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Itinerary itinerary = new Itinerary();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("Enter destination name (or 'done' to finish): ");
            String destinationName = scanner.nextLine();
            if (destinationName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Enter start date (yyyy-MM-dd): ");
            Date startDate = null;
            try {
                startDate = sdf.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
                continue;
            }

            System.out.println("Enter end date (yyyy-MM-dd): ");
            Date endDate = null;
            try {
                endDate = sdf.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
                continue;
			}

            Destination destination = new Destination(destinationName, startDate, endDate);
            itinerary.addDestination(destination);

            System.out.println("Enter preference type (e.g., accommodation, activities): ");
            String preferenceType = scanner.nextLine();
            System.out.println("Enter preference detail: ");
            String preferenceDetail = scanner.nextLine();
            Preference preference = new Preference(preferenceType, preferenceDetail);
            itinerary.addPreference(preference);
        }
        itinerary.generateItinerary();
        scanner.close();
}
}

