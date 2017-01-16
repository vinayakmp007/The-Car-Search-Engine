/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataloader;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;
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
    
    //Later Dictionary could be used to store this data
   String model_name,man_name,designer,head,image,fuel_system,bmep,engine_coolant,engine_man,engine_type;
   String engine_pos,engine_layout,drive_wheels,steering,gearbox,tyres_front,tyres_rear,mileages,cyclinders;
   boolean img;
   int image_id;
    int year,nod;
    float wheelbase_in_mm,lenght_in_mm,width_in_mm,height_in_mm,ground_clr_in_mm,fuel_tank_cap_in_ltr,weight_in_kg,max_speed;
    float front_brake_dia,rear_brake_dia,mileage;
    public String makeInsertString(String table){
        image_id=0;

    String str;
       str = "INSERT INTO "+table+"(BMEP,CYCLINDERS,DESIGNERS,DRIVE_WHEELS,ENGINE_COOLANT,ENGINE_LAYOUT,ENGINE_MAN,ENGINE_POS,ENGINE_TYPE,FRONT_BRAKE_DIA,FUEL_SYSTEM,FUEL_TANK_CAP,GEAR_BOX,GROUND_CLR_IN_MM,HEAD,HEIGHT_IN_MM,IMAGE_ID,IMAGE_Y_N,LENGHT_IN_MM,MAN_NAME,MAX_SPEED,MILEAGE,MILEAGES,MODEL_NAME,NOD,REAR_BRAKE_DIA,STEERING,TYRES_FRONT,TYRES_REAR,WEIGHT_IN_KG,WHEELBASE_IN_MM,WIDTH_IN_MM,YEAR,CAR_ID)"  + "VALUES('"+bmep+"','"+cyclinders+"','"+designer+"','"+drive_wheels+"','"+engine_coolant+"','"+engine_layout+"','"+engine_man+"','"+engine_pos+"','"+engine_type+"',"+front_brake_dia+",'"+fuel_system+"',"+fuel_tank_cap_in_ltr+",'"+gearbox+"',"+ground_clr_in_mm+",'"+head+"',"+height_in_mm+","+image_id+",'"+String.valueOf(img)+"',"+lenght_in_mm+",'"+man_name+"',"+max_speed+","+mileage+",'"+mileages+"','"+model_name+"',"+nod+","+rear_brake_dia+",'"+steering+"','"+tyres_front+"','"+tyres_rear+"',"+weight_in_kg+","+wheelbase_in_mm+","+"'"+width_in_mm+"',"+year+",0)";
     str =str.replace(",null",",NULL");
     str =str.replace(",'null'",",NULL");
     str =str.replace(",-1.0",",NULL");
      str =str.replace(",-1",",NULL");
     str =str.replace("&","AND");
     str =str.replace("\"\"","NULL");
    return str;
    }
    public void getFromResultSet(ResultSet rs){
    try{
        
        bmep=rs.getString("BMEP");
        cyclinders=rs.getString("CYCLINDERS");
        designer=rs.getString("DESIGNER");
        drive_wheels=rs.getString("DRIVE_WHEELS");
        engine_coolant=rs.getString("ENGINE_COOLANT");
        engine_layout=rs.getString("ENGINE_LAYOUT");
        engine_man=rs.getString("ENGINE_MAN");
        engine_pos=rs.getString("ENGINE_POS");
        engine_type=rs.getString("ENGINE_TYPE");
        front_brake_dia=rs.getFloat("FRONT_BRAKE_DIA");
        fuel_system=rs.getString("FUEL_SYSTEM");
        fuel_tank_cap_in_ltr=rs.getFloat("FUEL_TANL_CAP");
        gearbox=rs.getString("GEARBOX");
        ground_clr_in_mm=rs.getFloat("GROUND_CLR_IN_MM");
        head=rs.getString("HEAD");
        height_in_mm=rs.getFloat("HEIGHT_IN_MM");
        image_id=rs.getInt("IMAGE_ID");
        img=rs.getBoolean("IMAGE_Y_N");
        lenght_in_mm=rs.getFloat("LENGHT_IN_MM");
        man_name=rs.getString("MAN_NAME");
        max_speed=rs.getFloat("MAX_SPEED");
        mileage=rs.getFloat("MILEAGE");
        mileages=rs.getString("MILEAGES");
        model_name=rs.getString("MODEL_NAME");
        nod=rs.getInt("NOD");
        rear_brake_dia=rs.getFloat("REAR_BRAKE_DIA");
        steering=rs.getString("STEERING");
        tyres_front=rs.getString("TYRES_FRONT");
        tyres_rear=rs.getString("TYRES_REAR");
        weight_in_kg=rs.getFloat("WEIGHT_IN_KG");
        wheelbase_in_mm=rs.getFloat("WHEELBASE_IN_MM");
        width_in_mm=rs.getFloat("WIDTH_IN_MM");
        year=rs.getInt("YEAR");
    }
    catch(SQLException e){}
    }
    public void insertIntoDbms(jdbcconn as,String table) throws SQLException, InterruptedException{
    String a=makeInsertString(table);
    as.executeUpdate(a);
    
    }
    public void getdata(String fil) throws ParserConfigurationException, SAXException, IOException
    {
        img=false;
        int a =fil.length();
        image=(fil.substring(0,a-4).concat(".jpg"));
        //System.out.println(image);
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
              
                        man_name=man_name.trim();
                        break;
                    case "modelname":
                        model_name=datchild.getTextContent();
                        model_name=model_name.trim();
                        model_name=model_name.replace("'"," ");
                        if(model_name.isEmpty())System.out.println("empty name\n");
                        System.out.println(model_name);
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
                        nod=Integer.parseInt(datchild.getTextContent());
                        }
                        catch(StringIndexOutOfBoundsException |NumberFormatException e){
                        
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
                    case "fuel tank capacity":
                        try{
                        fuel_tank_cap_in_ltr=Float.parseFloat(datchild.getTextContent());
                        }
                        catch(NumberFormatException e){
                        fuel_tank_cap_in_ltr=-1;
                        }
                                          
                        break;
                    case "Kerb weight":
                        try{
                        weight_in_kg=Float.parseFloat(datchild.getTextContent().replace(" kg",""));
                        }
                        catch(NumberFormatException e){
                        weight_in_kg=-1;
                        }
                        break;
                        case "Maximum speed":
                        try{
                            String tem=datchild.getTextContent();
                            tem=tem.substring(0,tem.indexOf("km/h"));
                            tem=tem.trim();
                        max_speed=Float.parseFloat(tem);
                        //System.out.println(tem);
                        }
                        catch(StringIndexOutOfBoundsException | NumberFormatException e){
                            max_speed=-1;
                        }
                        break;
                        case "Front brake diameter":
                        try{
                            String tem=datchild.getTextContent();
                            tem=tem.substring(0,tem.indexOf("mm"));
                            tem=tem.trim();
                        front_brake_dia=Float.parseFloat(tem);
                        //System.out.println(tem);
                        }
                        catch(StringIndexOutOfBoundsException | NumberFormatException e){
                            front_brake_dia=-1;
                        }
                        break;
                        case "Rear brake diameter":
                        try{
                            String tem=datchild.getTextContent();
                            tem=tem.substring(0,tem.indexOf("mm"));
                            tem=tem.trim();
                        rear_brake_dia=Float.parseFloat(tem);
                        //System.out.println(tem);
                        }
                        catch(StringIndexOutOfBoundsException | NumberFormatException e){
                            rear_brake_dia=-1;
                        }
                        break;
                        case "km per litre":
                        try{
                           mileages=datchild.getTextContent();
                            String tem=mileages.substring(0,mileages.indexOf("/"));
                            tem=tem.trim();
                        mileage=Float.parseFloat(tem);
                        //System.out.println(mileage+" "+mileages);
                        }
                        catch(StringIndexOutOfBoundsException | NumberFormatException e){
                            mileage=-1;
                        }
                        break;
                        case "Fuel system":
                        try {
                        fuel_system=datchild.getTextContent();
                        fuel_system=fuel_system.trim();
                        fuel_system=fuel_system.replace("'"," ");
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        fuel_system="";
                        }
                        break;
                        
                        case "bmep (brake mean effective pressure)":
                        try {
                        bmep=datchild.getTextContent();
                        bmep=bmep.trim();
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        bmep="";
                        }
                        break;
                        case "Engine coolant":
                        try {
                        engine_coolant=datchild.getTextContent();
                        engine_coolant=engine_coolant.trim();
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        engine_coolant="";
                        }
                        break;
                        case "Engine manufacturer":
                        try {
                        engine_man=datchild.getTextContent();
                        engine_man=engine_man.trim();
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        engine_man="";
                        }
                        break;
                        case "engine type":
                        try {
                        engine_type=datchild.getTextContent();
                        engine_type=engine_type.trim();
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        engine_type="";
                        }
                        break;
                        case "Engine layout":
                        try {
                        engine_layout=datchild.getTextContent();
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        engine_layout="";
                        }
                        break;
                        case "Engine position":
                        try {
                        engine_pos=datchild.getTextContent();
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        engine_pos="";
                        }
                        break;
                        case "Drive wheels":
                        try {
                        drive_wheels=datchild.getTextContent();
                        drive_wheels=drive_wheels.trim();
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        drive_wheels="";
                        }
                        break;
                        case "Steering":
                        try {
                        steering=datchild.getTextContent();
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        steering="";
                        }
                        break;
                        case "Gearbox":
                        try {
                        gearbox=datchild.getTextContent();
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        gearbox="";
                        }
                        break;
                        case "Tyres front":
                        try {
                        tyres_front=datchild.getTextContent();
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        tyres_front="";
                        }
                        break;
                         case "Tyres rear":
                        try {
                        tyres_rear=datchild.getTextContent();
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        tyres_rear="";
                        }
                        break;
                        case "Cylinders":
                        try {
                        cyclinders=datchild.getTextContent();
                        }
                        catch(StringIndexOutOfBoundsException e){
                        
                        cyclinders="";
                        }
                        break;
                        
                        
                        
                        
                        
                        
                    default:
                        break;
                }
             
             }             
        
        
        
        
        
        
        
        }
        
        
    }
    
    
}
