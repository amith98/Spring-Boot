package com.example.springmail.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class MailController {
	

    @Autowired
    private JavaMailSender sender;

	private static String UPLOADED_FOLDER = "uploads/";
	@GetMapping("/uploadFile")
	public String showUploadPage() {
	    return "upload";
	}

	@PostMapping("/uploadFile")
	public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
	    if (file.isEmpty()) {
	        model.addAttribute("message", "Please select a file to upload.");
	        return "upload";
	    }

	    try {
	        // Create the directory if it doesn't exist
	        Path uploadPath = Paths.get(UPLOADED_FOLDER);
	        if (!Files.exists(uploadPath)) {
	            Files.createDirectories(uploadPath);
	        }

	        byte[] bytes = file.getBytes();
	        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	        Files.write(path, bytes);

	        model.addAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "' and a confirmation email has been send!");
	        try {

	            // Prepare the email content
	            SimpleMailMessage msg = new SimpleMailMessage();
	            msg.setTo("*****");  // Replace with your Mailtrap address or receiver's email
	            msg.setSubject("File uploaded successfully");
	            msg.setText("The file " +file.getOriginalFilename() + "was uploaded successfully in the uploads folder from the upload page");

	            // Send the email
	            sender.send(msg);
	        } catch (MailException ex) {
	            System.err.println(ex.getMessage());
	        }

	    } catch (Exception e) {
	        model.addAttribute("message", "Failed to upload '" + file.getOriginalFilename() + "' -> " + e.getMessage());
	    }
	    return "upload";
	}

}
