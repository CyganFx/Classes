import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
/**
 * Person class template
 */
public class Person {
    private String name;
    private LocalDate birthYear;
    private String information;
    private final LocalDate today = LocalDate.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    Person() { }

    Person(String name, String birthYear) {
        if (Period.between(LocalDate.parse(birthYear), today).getYears() > 127) {
            throw new ArithmeticException("Birth year is too big: "
                    + birthYear
                    + ", double check the input");
        }
        this.name = name;
        this.birthYear = LocalDate.parse(birthYear);
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public LocalDate getBirthYear() { return birthYear; }

    public void setBirthYear(String birthYear) {
        if (Period.between(LocalDate.parse(birthYear), today).getYears() > 127) {
            throw new ArithmeticException("Birth year is too big: "
                    + birthYear
                    + ", double check the input");
        }
        this.birthYear = LocalDate.parse(birthYear);
    }

    public byte age() {
        return (byte) Period.between(getBirthYear(), today).getYears();
    }

    public void input(String information) {
        this.information = information;
    }

    public void output() {
        if (information == null) {
            information = "No information";
        }
        System.out.println("Person {" +
                "name = '" + name + '\'' +
                ", birthYear = " + formatter.format(birthYear) +
                '}' + '\n' + " " + information + '\n');
    }
}
