package com.iss.csv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.csvreader.*;

public class CSVToDB 
{	
	void retrieveData(CsvReader products)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try
		{
			con=ConnectionManager.getConnection();
			System.out.println(products.readHeaders());
		
			System.out.println(products.getHeaderCount());
	        
	        pstmt=con.prepareStatement("insert into product values(?,?)");
	        final int batchSize=1000;
	        int count=0;
      
	        while (products.readRecord())
	        {
	        	pstmt.setInt(1, Integer.parseInt(products.get("pid")));
                pstmt.setString(2, products.get("pname"));
                //pstmt.setDouble(3,Double.parseDouble(products.get("price")));
                pstmt.addBatch();
                if (++count % batchSize == 0) 
                {
                    pstmt.executeBatch();
                }
            }
	        pstmt.executeBatch();
		}
		catch(Exception e)
		{
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
		}
		finally
		{
			try
			{
				products.close();
				pstmt.close();
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
			
			try
			{
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("Records Created Successfully");
	}
}
