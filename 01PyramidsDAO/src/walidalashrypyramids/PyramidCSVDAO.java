package walidalashrypyramids;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class PyramidCSVDAO {
    List<Pyramid> pyramids;
    public List<Pyramid> PyramidCSVDAO (String rawFileName){
        this.pyramids = new ArrayList<Pyramid>();
        
        //access the data csv file:
        File pyramidFile = new File(rawFileName);
        
        //read all data:
        List<String> lines = new ArrayList<String>();
        try{
            lines = Files.readAllLines(pyramidFile.toPath());
            
        } catch (IOException e){
            System.out.println("an issue while readind" + e);
        }
        
        //extraction:
        for(int lineIndx = 1; lineIndx<lines.size(); lineIndx++){
            String line = lines.get(lineIndx);
            String[] fields = line.split(",");
            
            for(int fieldIndex = 0; fieldIndex < fields.length; fieldIndex++){
                fields[fieldIndex] = fields[fieldIndex].trim();
                
            }
            Pyramid pyramid = new Pyramid();

            try{
                pyramid.setPharaoh(fields[0]);
            }catch(Exception e){
                pyramid.setPharaoh("-1");
            }
            
            try{
                pyramid.setModern_name(fields[2]);
            }catch(Exception e){
                pyramid.setModern_name("-1");
            }
            
            try{
                pyramid.setSite(fields[4]);
            }catch(Exception e){
                pyramid.setSite("-1");
            }
            
            try{
                pyramid.setHeight(Integer.parseInt(fields[7]));
            }catch(Exception e){
                pyramid.setHeight(0);
            }
            pyramids.add(pyramid);
        }
        
        System.out.println("Total number of Pyramids is "+ pyramids.size());
        return pyramids;
    }


    
}
