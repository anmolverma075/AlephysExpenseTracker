import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class AlephysManager{
    List<AlephysRecord> records = new ArrayList<>();

    public void add(String type , String category , double amount){
        AlephysRecord r = new AlephysRecord(type , category , amount , LocalDate.now());
        records.add(r);
        System.out.println("Alephys: Transaction recorded.");
    }

    public void summary(int month){
        double incomeTotal = 0;
        double expenseTotal = 0;

        System.out.println("\n Alephys Monthly Summary (Month " + month + "):");
        for(AlephysRecord r : records){
            if(r.date.getMonthValue() == month){
                if(r.type.equals("income")){
                    incomeTotal += r.amount;
                }
                else{
                    expenseTotal += r.amount;
                }
            }
        }

        System.out.println("Total Income  : Rs" + incomeTotal);
        System.out.println("Total Expense : Rs" + expenseTotal);
        System.out.println("Net Savings   : Rs" + (incomeTotal - expenseTotal));
    }

    public void save(String fileName){
        try{
            PrintWriter writer = new PrintWriter(fileName);
            for(AlephysRecord r : records){
                writer.println(r.format());
            }
            writer.close();
            System.out.println("Alephys: Records saved.");
        }
        catch(IOException e){
            System.out.println("Alephys: Error saving file.");
        }
    }

    public void load(String fileName){
        File file = new File(fileName);
        if(!file.exists()){
            System.out.println("Alephys: File not found.");
            return;
        }

        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                AlephysRecord r = AlephysRecord.parse(reader.nextLine());
                records.add(r);
            }
            reader.close();
            System.out.println("Alephys: Records loaded.");
        }
        catch (IOException e){
            System.out.println("Alephys: Error loading file.");
        }
    }
}
