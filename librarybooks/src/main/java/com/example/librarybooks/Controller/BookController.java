package com.example.librarybooks.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class BookController {
	public String title = "Data Programming";
	public String author = "Carl Marks";
	public String description = "Book about Data programming";
	public String price = "299";
	public String publishedDate = "22-08-2021";
	
	@GetMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("title",title);
		model.addAttribute("author",author );
		model.addAttribute("description", description);
		model.addAttribute("price", price);
		model.addAttribute("publishedDate",publishedDate );
		return "books";
	}
	
	@GetMapping("/generate-book-pdf")
    public void generateProductPdf(HttpServletResponse response )throws Exception {
		
		response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=book.pdf");

            try (PDDocument document = new PDDocument()) {
                PDPage page = new PDPage();
                document.addPage(page);

                try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
                    contentStream.beginText();
                    contentStream.newLineAtOffset(50, 750);
                    contentStream.showText("Book Details");
                    contentStream.endText();

                    contentStream.setFont(PDType1Font.HELVETICA, 12);
                    int yPosition = 720;
                    contentStream.beginText();
                    contentStream.newLineAtOffset(50, yPosition);
                    contentStream.showText("Name: " + title);
                    contentStream.endText();

                    yPosition -= 20;
                    contentStream.beginText();
                    contentStream.newLineAtOffset(50, yPosition);
                    contentStream.showText("Author: " + author);
                    contentStream.endText();

                    yPosition -= 20;
                    contentStream.beginText();
                    contentStream.newLineAtOffset(50, yPosition);
                    contentStream.showText("Description: " + description);
                    contentStream.endText();
                    
                    yPosition -= 20;
                    contentStream.beginText();
                    contentStream.newLineAtOffset(50, yPosition);
                    contentStream.showText("Price: " + price);
                    contentStream.endText();


                    yPosition -= 20;
                    contentStream.beginText();
                    contentStream.newLineAtOffset(50, yPosition);
                    contentStream.showText("Published Date: " + publishedDate);
                    contentStream.endText();
                }
                document.save(response.getOutputStream());

            }   
    }

}
