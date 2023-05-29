package com.iss.csv;

import java.io.FileNotFoundException;
import java.io.Reader;

import com.csvreader.*;

public class CSVLoader 
{
	static CSVToDB cd=new CSVToDB();
	CsvReader products=null;
	
	public void loadCSV(String filename)
	{	
		try
		{
			products=new CsvReader(filename);
		}catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		
		cd.retrieveData(products);
		products.close();
	}
	
	public void loadCSV(Reader reader)
	{
		products=new CsvReader(reader);
		//products=new CsvReader(new FileReader(filename));
		
		cd.retrieveData(products);
		products.close();
	}
}
