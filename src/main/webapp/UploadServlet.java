package main.webapp;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iss.csv.CSVLoader;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold=1024*1024,maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    /**
	 * 
	 */
	Properties properties;
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        Part filePart = request.getPart("File");
        //String filename = filePart.getSubmittedFileName();
        System.out.println(filePart.getSubmittedFileName());
        CSVLoader csvLoader = new CSVLoader();
        csvLoader.loadCSV(new InputStreamReader(filePart.getInputStream()));
        
        response.getWriter().write("Processing completed!");
    }
}
