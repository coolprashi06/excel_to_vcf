package com.prashast.impl;


import com.prashast.Converter;
import com.prashast.ExcelUtil;
import com.prashast.model.Person;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConverterImpl implements Converter {

    private static String DATA_SOURCE_NAME="excel_to_vcf";
    private static String SQL_EXCEL_STATEMENT="select * from [Contacts$]";
    private static String FOLDER_PATH="C:\\all\\";

    public void getAllVCF() {

        Statement statement;
        ResultSet resultSet;
        Connection connection;

        try{
            connection=establishConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(SQL_EXCEL_STATEMENT);
            while(resultSet.next()){
                Person person=new Person();
                person.setFirstName(resultSet.getString("FirstName"));
                person.setLastName(resultSet.getString("LastName"));
                person.setDob(resultSet.getString("DateOfBirth"));
                person.setMobNumber(resultSet.getString("MobileNumber"));
                person.setExtn(resultSet.getString("OfficeExtn"));
                person.setEmailAddr(resultSet.getString("EmailAddress"));
                person.setGender(resultSet.getString("Gender"));

                String fileName=FOLDER_PATH+person.getFirstName()+".vcf";
                File file=new File(fileName);
                FileOutputStream fos=new FileOutputStream(file);

                String vcardStr=prepareVcard(person);
                fos.write(vcardStr.getBytes());
                fos.flush();
                fos.close();
            }
            resultSet.close();
            statement.close();
            connection.close();


        } catch (SQLException sqle){
            sqle.printStackTrace();
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public String prepareVcard(Person person){

        String vcardString =
                "BEGIN:VCARD "+"\n" +
                "VERSION 4.0 "+"\n" +
                "N:"+person.getFirstName()+" \n" +
                "FN:"+person.getFirstName()+" "+person.getLastName()+" \n"+
                "EMAIL;PREF;INTERNET:"+person.getEmailAddr()+" \n"+
                "TEL;WORK;VOICE:"+person.getExtn()+" \n"+
                "TEL;HOME;VOICE:"+person.getMobNumber()+" \n"+
                "BDAY:"+person.getDob()+" \n"+
                "GENDER:"+person.getGender()+" \n"+
                "END:VCARD";

        return vcardString;
    }

    public Connection establishConnection(){
        ExcelUtil util=new ExcelUtil();
        util.setDataSource(DATA_SOURCE_NAME);
        return util.makeConnection();
    }

    public static void main(String args[])throws IOException{
        ConverterImpl impl=new ConverterImpl();
        impl.getAllVCF();
    }







}
