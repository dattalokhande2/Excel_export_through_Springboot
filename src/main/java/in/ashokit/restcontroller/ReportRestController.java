package in.ashokit.restcontroller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.ReportService;
@RestController
public class ReportRestController {
	@Autowired
	private ReportService reportService;
	
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws Exception {
		
		
		response.setContentType("application/octet-stream");
		String  headerkey = "Content-Disposition";
		String 	headervalue= "attachment;filename=courses.xls";
		response.setHeader(headerkey, headervalue);
		
		reportService.generateExcel(response);
	}

}
