package iti.mans.g1.titaniceda;

import java.io.IOException;
import static java.lang.Double.max;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.apache.commons.math3.stat.inference.TestUtils.t;
import static org.apache.commons.math3.stat.inference.TestUtils.t;
import static org.apache.commons.math3.stat.inference.TestUtils.t;
import static org.apache.commons.math3.stat.inference.TestUtils.t;
import smile.stat.Hypothesis.t;
import tech.tablesaw.api.*;


public class TitanicEDA {
    
    Table titanicData;
    String dataPath = "src/main/resources/titanic.csv";
    
    public TitanicEDA() {
    }
    
    public static void main (String[] args){
        TitanicEDA tda = new TitanicEDA ();
        
        Path relativePath = Paths.get("D:\\AI_pro\\java\\project\\Wazzuf_App\\Wuzzuf_Jobs.csv");
        System.out.println("Current relative path is: " + relativePath.toString());
        
        try {
            tda.titanicData = tda.loadDataFromCVS (tda.dataPath);
            //getting the Structure of the data
            String structure = tda.getDataInfoStructure (tda.titanicData);
            System.out.println (structure);
            
            
            //getting Data summery
            System.in.read ();
            String summary = tda.getDataSummary (tda.titanicData);
            System.out.println (summary);
            System.in.read ();
            // Adding date Column
            Table dataWithDate = tda.addDateColumnToData (tda.titanicData);
            System.out.println ("=====================================================================================");
            System.out.println (dataWithDate.structure ());
            System.in.read ();
            //Sorting on the added Date Field
            Table sortedData = dataWithDate.sortAscendingOn ("Fake Date");

            //getting the first 10 rows
            System.out.println ("Printing the first rows of the table");
            System.in.read ();
            Table firstTenRows = sortedData.first (50);

            System.out.println (firstTenRows);
            System.in.read ();
            
            Table mappedData = tda.mapTextColumnToNumber (tda.titanicData);
            Table firstFiveRows = mappedData.first (5);
            System.out.println ("=====================================================================================");
            System.out.println (firstFiveRows);
        } catch (IOException e) {
            e.printStackTrace ();
        }
        
        
        //• Using joinery and Tablesaw perform some data exploration activities
//such as getting information about the data (min, max, standard
//deviation, etc.)

        
        
    }
    
    // read csv
    public Table loadDataFromCVS(String path) throws IOException {
        Table titanicData = Table.read ().csv (path);
        return titanicData;
    }
    
    // get info
    public String getDataInfoStructure(Table data) {
        Table dataStructure = data.structure ();
        return dataStructure.toString ();
    }
    
    //get Data Summary
    public String getDataSummary(Table data) {
        Table summary = data.summary ();
        return summary.toString ();
    }
    
    //Adding Columns
    public Table addDateColumnToData(Table data) {
        int rowCount = data.rowCount ();
        List<LocalDate> dateList = new ArrayList<LocalDate> ();
        for (int i = 0; i < rowCount; i++) {
            dateList.add (LocalDate.of (2021, 3, i % 31 == 0 ? 1 : i % 31));
        }
        DateColumn dateColumn = DateColumn.create ("Fake Date", dateList);
        data.insertColumn (data.columnCount (), dateColumn);
        return data;
    }
    
    // mapping text data to numeric values on the sex field female=1,male=0 and adding a column named gender
    public Table mapTextColumnToNumber(Table data) {
        NumberColumn mappedGenderColumn = null;
        StringColumn gender = (StringColumn) data.column ("Sex");
        List<Number> mappedGenderValues = new ArrayList<Number> ();
        for (String v : gender) {
            if ((v != null) && (v.equals ("female"))) {
                mappedGenderValues.add (new Double (1));
            } else {
                mappedGenderValues.add (new Double (0));
            }
        }
        mappedGenderColumn = DoubleColumn.create ("gender", mappedGenderValues);
        data.addColumns (mappedGenderColumn);
        return data;
    }
    


    
    
//• Create 2 DataFrame Objects and try to join, merge, add columns of
//specific datatypes to both DataFrames (perform these activities using
//both libraries)
    
    
}
