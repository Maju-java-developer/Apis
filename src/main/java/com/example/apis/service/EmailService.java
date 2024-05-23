package com.example.apis.service;

import com.example.apis.entities.WorkerEntity;
import com.example.apis.repo.WorkerRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final WorkerRepo workerRepo;
    public void sendEmail(String name, String contactNumber, String service, Integer workerId, String address, String preferredTime) throws MessagingException {
        if (workerId == null) {
            throw new RuntimeException("Worker Id is required!");
        }
        WorkerEntity workerEntity = workerRepo.findById(workerId).orElseThrow(() -> new RuntimeException("Worker not found with given Id: " + workerId));
        String htmlBody = generateEmailContent(name, contactNumber, service, address, preferredTime);

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true); // true indicates multipart message
        helper.setTo(Objects.requireNonNull(workerEntity.getEmail(), workerId + " Worker Email is null"));
        helper.setSubject("BOOKING DETAILS");
        helper.setText(htmlBody, true); // true indicates html

        javaMailSender.send(message);
        System.out.println("Mail has been sent successfully!");
    }

    private String generateEmailContent(String name, String contactNumber, String service, String address, String preferredTime) {
        return "<html>" +
                "<body>" +
                "<h2>BOOKING DETAILS</h2>" +
                "<table style='border: 1px solid black; border-collapse: collapse; width: 100%;'>" +
                "<tr>" +
                "<th style='border: 1px solid black; padding: 8px; text-align: left;'>Field</th>" +
                "<th style='border: 1px solid black; padding: 8px; text-align: left;'>Details</th>" +
                "</tr>" +
                createTableRow("Name", name) +
                createTableRow("Contact Number", contactNumber) +
                createTableRow("Service", service) +
//                createTableRow("Worker", worker) +
                createTableRow("Address", address) +
                createTableRow("Preferred Time", preferredTime) +
                "</table>" +
                "</body>" +
                "</html>";
    }

    private String createTableRow(String title, String data) {
        return "<tr>" +
                "<td style='border: 1px solid black; padding: 8px;'>" + title + "</td>" +
                "<td style='border: 1px solid black; padding: 8px;'>" + data + "</td>" +
                "</tr>";
    }

//    private String generateEmailContent(String name, String contactNumber, String service, String worker, String address, String preferredTime) {
//        StringBuilder htmlContent = new StringBuilder();
//        htmlContent.append("<html>");
//        htmlContent.append("<head>");
//        htmlContent.append("<style>");
//        // Define CSS for odd and even rows
//        htmlContent.append("tr.odd-row { background-color: rgb(45, 235, 135); }");
//        htmlContent.append("tr.even-row { background-color: rgb(255, 255, 255); }");
//        htmlContent.append("</style>");
//        htmlContent.append("</head>");
//        htmlContent.append("<body>");
//        htmlContent.append("<h2>BOOKING DETAILS</h2>");
//        htmlContent.append("<table style='border: 1px solid black; border-collapse: collapse; width: 100%;'>");
//        htmlContent.append("<tr>");
//        htmlContent.append("<th style='border: 1px solid black; padding: 8px; text-align: left;'>Field</th>");
//        htmlContent.append("<th style='border: 1px solid black; padding: 8px; text-align: left;'>Details</th>");
//        htmlContent.append("</tr>");
//        htmlContent.append("<tr><td style='border: 1px solid black; padding: 8px;'>Name</td><td style='border: 1px solid black; padding: 8px;'>").append(name).append("</td></tr>");
//        htmlContent.append("<tr><td style='border: 1px solid black; padding: 8px;'>Contact Number</td><td style='border: 1px solid black; padding: 8px;'>").append(contactNumber).append("</td></tr>");
//        htmlContent.append("<tr><td style='border: 1px solid black; padding: 8px;'>Service</td><td style='border: 1px solid black; padding: 8px;'>").append(service).append("</td></tr>");
//        htmlContent.append("<tr><td style='border: 1px solid black; padding: 8px;'>Worker</td><td style='border: 1px solid black; padding: 8px;'>").append(worker).append("</td></tr>");
//        htmlContent.append("<tr><td style='border: 1px solid black; padding: 8px;'>Address</td><td style='border: 1px solid black; padding: 8px;'>").append(address).append("</td></tr>");
//        htmlContent.append("<tr><td style='border: 1px solid black; padding: 8px;'>Preferred Time</td><td style='border: 1px solid black; padding: 8px;'>").append(preferredTime).append("</td></tr>");
//        htmlContent.append("</table>");
//        htmlContent.append("</body>");
//        htmlContent.append("</html>");
//
//        return htmlContent.toString();
//    }

}