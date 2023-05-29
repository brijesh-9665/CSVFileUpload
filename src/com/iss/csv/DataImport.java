package com.iss.csv;

public class DataImport 
{
	public static void main(String a[])
	{
		CSVLoader csvLoader=new CSVLoader();
		String filename="C:\\Users\\5490\\Desktop\\Java Programs\\Book1.csv";
		csvLoader.loadCSV(filename);
	}
}
