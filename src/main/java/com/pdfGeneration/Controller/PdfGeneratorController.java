package com.pdfGeneration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.pdfGeneration.Service.PdfGeneratorService;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class PdfGeneratorController {
    @Autowired
    PdfGeneratorService pdfGeneratorService;
// http://localhost:8989/pdf1
    @GetMapping("/pdf1")
    public void generatepdf(HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        String currentdate = dateFormat.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentdate + ".pdf";
        response.setHeader(headerKey, headerValue);

        pdfGeneratorService.export(response);
    }
}