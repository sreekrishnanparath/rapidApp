package com.jst.rapidapp.utils.mail;

import com.jst.rapidapp.beans.RapidTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;

@Component
public class EmailService {


    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String subject, RapidTransactions rapidTransactions) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("parathsree@gmail.com","d00242703@student.dkit.ie","d00226111@student.dkit.ie");
        //msg.setSubject(subject);
        StringBuffer contentBuffer = new StringBuffer();
        contentBuffer.append("<html>\n" +
                "<head><title>Tables</title></head>\n" +
                "<body>\n" +
                "table border=1>");
        Map<String,String> dataMap = rapidTransactions.getResultData();
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            contentBuffer.append("<tr>");
            contentBuffer.append("<td style=\"border:solid #cccccc 1.0pt;background:#00416e;padding:3.75pt 2.25pt 3.75pt 2.25pt\">");
            contentBuffer.append("<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center\"><b><span style=\"font-size:9.0pt;font-family:&quot;Verdana&quot;,sans-serif;color:white\">" + entry.getKey() + "<u></u><u></u></span></b></p></td>");
            contentBuffer.append("<td style=\"border:solid #cccccc 1.0pt;background:#00416e;padding:3.75pt 2.25pt 3.75pt 2.25pt\">");
            contentBuffer.append("<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center\"><b><span style=\"font-size:9.0pt;font-family:&quot;Verdana&quot;,sans-serif;color:white\">" + entry.getValue() + "<u></u><u></u></span></b></p></td>");

            contentBuffer.append("</tr>");
            //contentBuffer.append("<tr><td>" +entry.getKey() + "</td><td>" + entry.getValue() +"</td></tr>");
        }
        contentBuffer.append("</table>\n" +
                "</body>\n" +
                "</html>");
        //msg.set(rapidTransactions.toString() +"\n\n"+contentBuffer.toString(),true);
        //emailSender.send(msg);
        InternetAddress[] sendTo = new InternetAddress[2];
        sendTo[0] = new InternetAddress("d00242703@student.dkit.ie");
        sendTo[1] = new InternetAddress("d00226111@student.dkit.ie");
        helper.setText(rapidTransactions.toString()+"\n\n"+String.valueOf(contentBuffer), true); // Use this or above line.
        helper.setTo(sendTo);
        helper.setTo("parathsree@gmail.com");
        helper.setSubject(subject);
        emailSender.send(mimeMessage);
    }
    }


