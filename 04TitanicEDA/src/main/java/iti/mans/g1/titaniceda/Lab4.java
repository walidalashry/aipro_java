package iti.mans.g1.titaniceda;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.NumericColumn;
import tech.tablesaw.api.Table;


public class Lab4 {
    
    
   
   public static void main(String[] args ) {
     String Path = "src/main/resources/titanic.csv";
     String Path2 = "src/main/resources/vgsales.csv";
      
     //get Statitistics for column:
     String Col ="age";
     getStatCol(Col,Path);
     
     //using 2 Coulmns from second table
     mergeTable(Path,Path2);
     addCol(Path,Path2);
     
        
       

  

   }
   
   public static void getStatCol(String name,String Path){
       
       
       Table statsTable  = null;
       try {
           statsTable = Table.read().csv(Path);
           Table structure = statsTable.structure();
           System.out.println(structure);
       
     
        NumericColumn MinCoulmn = statsTable.numberColumn (name);
        double Min = MinCoulmn.min();
        System.out.println("   Min     :   "+ Min);
        
        NumericColumn MaxCoulmn = statsTable.numberColumn (name);
        double Max = MaxCoulmn.max();
        System.out.println("   Max     :   "+ Max);
        
        NumericColumn STDCoulmn = statsTable.numberColumn (name);
        double STD = STDCoulmn.standardDeviation();
        System.out.println("   Std     :   "+ STD);
     
           System.out.println("Summary for All Table : "+statsTable.summary());
       } catch (IOException e) {
           e.printStackTrace ();
           System.out.println("Pug");
       }
       
  }
   public static void addCol(String Path , String Path2){
       //Titanic Table
      Table TitancTable  = null;
        try {
            TitancTable = Table.read().csv(Path);
             } catch (IOException ex) {
            Logger.getLogger(Lab4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(TitancTable.structure());
       

        Table VGSalesTable  = null;
        try {
            VGSalesTable = Table.read().csv(Path2);
             } catch (IOException ex) {
            Logger.getLogger(Lab4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(VGSalesTable.structure());

        int rowCount = TitancTable.rowCount();
        double[] theIndexing = new double[rowCount];
        for(int i = 0;i < rowCount;i++) theIndexing[i]=i;
        DoubleColumn myIndexColumn = DoubleColumn.create ("theIndexes", theIndexing);
        TitancTable.insertColumn (0, myIndexColumn);
        
        
        
        rowCount = VGSalesTable.rowCount();
        theIndexing = new double[rowCount];
        for(int i = 0;i < rowCount;i++) theIndexing[i]=i;
        myIndexColumn = DoubleColumn.create ("theIndexes", theIndexing);
        VGSalesTable.insertColumn (0, myIndexColumn);
     
   }
   public static void mergeTable(String Path,String Path2){
       
   
    Table TitancTable  = null;
        try {
            TitancTable = Table.read().csv(Path);
             } catch (IOException ex) {
            Logger.getLogger(Lab4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(TitancTable.structure());
       

        Table VGSalesTable  = null;
        try {
            VGSalesTable = Table.read().csv(Path2);
             } catch (IOException ex) {
            Logger.getLogger(Lab4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       Table a3 = TitancTable.addColumns(VGSalesTable.column("Year").first(TitancTable.rowCount()),VGSalesTable.column("Global_Sales").first(TitancTable.rowCount()));
       System.out.println(a3.summary());
       System.out.println(a3.first(10));
 
   }

}
