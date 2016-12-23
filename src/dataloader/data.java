/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataloader;
import dataloader.DataLoader;
import java.io.File;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
/**
 *
 * @author vinayak
 */
public class data {
   String model_name,man_name,designer,head,image;
   boolean img;
    int year,nod;
    float wheelbase_in_mm,lenght_in_mm,width_in_mm,height_in_mm,ground_clr_in_mm;

    public void getdata(String fil) throws ParserConfigurationException, SAXException, IOException
    {
        img=false;
        int a =fil.length();
        image=new String(fil.substring(0,a-4).concat(".jpg"));
        System.out.println(image);
        File f =new File(fil);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document docfile =builder.parse(f);
        
        Element root = docfile.getDocumentElement(); // The root element
        if(root.getTagName().equals("vinyaks_car_data")){
        
            File temp=new File(image);
            img=temp.isFile();
            
             NodeList nList = docfile.getElementsByTagName("dat");
             for(int i=0;i<nList.getLength();i++)
             {
             Node item=nList.item(i);
             Element dat=(Element) item;
             Element datchild=(Element)item.getFirstChild();
                switch (dat.getAttribute("name")) {
                    case "manname":
                        man_name=datchild.getTextContent();
                        man_name.trim();
                        break;
                    case "modelname":
                        model_name=datchild.getTextContent();
                        model_name.trim();
                        break;
                    case "modelyear":
                        try {
                        year=Integer.parseInt(datchild.getTextContent().substring(0,4));
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        year=-1;
                        }
                        break;
                    case "Number of doors":
                         try {
                        nod=Integer.parseInt(datchild.getTextContent().substring(0,2));
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        nod=-1;
                        }break;
                    case "Wheelbase":
                        try{
                        wheelbase_in_mm=Float.parseFloat(datchild.getTextContent());
                        }
                        catch(NumberFormatException e){
                        wheelbase_in_mm=-1;
                        
                        }
                        break;
                    case "Length":
                         try{
                        lenght_in_mm=Float.parseFloat(datchild.getTextContent());
                        }
                        catch(NumberFormatException e){
                        lenght_in_mm=-1;
                        
                        }
                         break;
                    case "Width":
                        try{
                        width_in_mm=Float.parseFloat(datchild.getTextContent());
                        }
                        catch(NumberFormatException e){
                        width_in_mm=-1;
                        
                        }
                         break;
                    case "Height":
                        try{
                        height_in_mm=Float.parseFloat(datchild.getTextContent());
                        }
                        catch(NumberFormatException e){
                        height_in_mm=-1;
                        
                        }
                         break;
                    case "Ground clearance":
                        try{
                        ground_clr_in_mm=Float.parseFloat(datchild.getTextContent());
                        }
                        catch(NumberFormatException e){
                        ground_clr_in_mm=-1;
                        
                        }
                         break;
                    
                    default:
                        break;
                }
             
             }             
        
        
        
        
        
        
        
        }
        
        
    }
    
    
}
