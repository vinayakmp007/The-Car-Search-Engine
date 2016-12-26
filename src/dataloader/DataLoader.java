    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package dataloader;

    import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
   // import org.apache.commons.io.FilenameUtils;
    /**
     *
     * @author vinayak
     */
    public class DataLoader {
        static String locatn="/home/vinayak/mini project data";  //your location here
      /**
         * @param args the command line arguments
         */

    /**
     *
     * @param args the command line arguments
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
              //
            final File folder = new File(locatn);
            insertData(folder);
        }


        public static void insertData(final File folder) throws ParserConfigurationException, SAXException, IOException {
            int count=0;
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                //insertData(fileEntry);//recurse through directories
            } else {
                String filname=fileEntry.getName();
                
                if(filname.endsWith(".xml"))
                {
                System.out.println(filname);     
                data a =new data();
                a.getdata(locatn+"/"+filname);    // for unix filesystem
              //  a.getdata(locatn+"\\"+filname); //for windows filesystem
                count++;
                
                
                
                }
           System.out.println(count); 
                
            }
        }
    }


    }
