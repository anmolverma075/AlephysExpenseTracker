import java.time.LocalDate;

public class AlephysRecord{
    static int nextId = 1;
    int id;
    String type;
    String category;
    double amount;
    LocalDate date;

    public AlephysRecord(String type , String category , double amount , LocalDate date){
        this.id = nextId++;
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String format(){
        return id + "#" + type + "#" + category + "#" + amount + "#" + date;
    }

    public static AlephysRecord parse(String line){
        String[] parts = line.split("#");
        return new AlephysRecord(parts[1] , parts[2] , Double.parseDouble(parts[3]) , LocalDate.parse(parts[4]));
    }
}
