
package utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import models.HopDongModel1;

public class SendEmailHopDong {
    public static void SendEmailHopDong(HopDongModel1 hopDong,String text, String email, boolean status) throws MessagingException, UnsupportedEncodingException {
        final String fromEmail = "n21dccn007@student.ptithcm.edu.vn";
        // Mat khai email cua ban
        final String password = "gada nxya ynnx igam";
        // dia chi email nguoi nhan
        final String toEmail = email;
        final String subject = "Hợp đồng sử dụng nước";
//        String body = "Mã xác nhận của bạn là: " + code;
        String body = "";
        if(status){
            body = """
              <!DOCTYPE html>
              <html lang="en">
              <head>
              </head>
              <body>
                <h2 style="red: blue;">Phần mềm quản lý nước Quận 9</h2>
                <h3 style="color: blue;">Xin chào: %s</h3>
                <p>%s</p>
              </body>
              </html>
              """.formatted(hopDong.getTenNguoiDangKy(),text);
        }else{
            body = """
              <!DOCTYPE html>
              <html lang="en">
              <head>
              </head>
              <body>
                <h2 style="red: bule;">Phần mềm quản lý nước Quận 9</h2>
                <h3 style="color: blue;">Xin chào: %s</h3>
                <p>Hợp đồng của bạn bị từ chối vì lý do sau:</p>
                <p style="color: red;>%s</p>
                <p>Bạn hãy chỉnh sửa theo đúng yêu cầu hợp đồng của chúng tôi.</p>
                <p>Nếu có gì thắc mắc hãy đến trung tâm cấp nước của chúng tôi.</p>
                <p>Hoặc liên hệ số điện thoại: 0123456789 để được giúp đỡ</p>
              </body>
              </html>
              """.formatted(hopDong.getTenNguoiDangKy(),text);
        }

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        MimeMessage msg = new MimeMessage(session);
        //set message headers

        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");
        msg.setHeader("X-Mailer", "JavaMail");
        msg.setHeader("X-MimeOLE", "Produced By Microsoft MimeOLE V6.00.2900.2869");
        msg.setFrom(new InternetAddress(fromEmail, "Quan Ly Nuoc Quan 9"));
        msg.setReplyTo(InternetAddress.parse(fromEmail, false));
        msg.setSubject(subject, "UTF-8");
        msg.setContent(body, "text/html; charset=utf-8");
        msg.setSentDate(new Date());
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        Transport.send(msg);
        System.out.println("Gui mail thanh cong");
    }
}
