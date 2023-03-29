package in.ashokit.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import in.ashokit.Entity.Course;
import in.ashokit.repository.CourseRepository;
@Service
public class ReportService {
	@Autowired
	private CourseRepository courserepo;
	
	
	public void generateExcel(HttpServletResponse responce) throws IOException
	{
		List<Course>  courses= courserepo.findAll();
		
		
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet= workbook.createSheet("Course Info");
		
		HSSFRow row = sheet.createRow(0);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("Name");
				row.createCell(2).setCellValue("Price");
		
		int	datarowindex= 1;
	
		for(Course course:courses)
			{
			 HSSFRow datarow = sheet.createRow(datarowindex);
			 		 datarow.createCell(0).setCellValue(course.getCid());
			 		 datarow.createCell(1).setCellValue(course.getCname());
			 		 datarow.createCell(2).setCellValue(course.getPrice());
			 		 
			 		 datarowindex++;
			 		  
	}
		ServletOutputStream outputStream = responce.getOutputStream();
				workbook.write(outputStream);
				workbook.close();
				outputStream.close();
				
		
	}

}
