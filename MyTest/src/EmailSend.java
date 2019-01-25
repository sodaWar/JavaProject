import java.util.*;
import javax.mail.*;                                                                                                    // 该jar包需要下载后,引入到该项目中,然后才能导入成功
import javax.mail.internet.*;
import javax.mail.Message.RecipientType;

public class EmailSend {
    public static void main(String[] args) throws MessagingException {
        final Properties props = new Properties();

        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        // 发件人的账号
        props.put("mail.user", "893026750@qq.com");
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", "bmnvhnpikgjsbeji");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人
        InternetAddress to = new InternetAddress("893026750@qq.com");
        message.setRecipient(RecipientType.TO, to);

        // 设置邮件标题
        message.setSubject("java send your email");

        // 设置邮件的内容体
//        message.setContent("自己发送邮件的内容体", "text/html;charset=UTF-8");
        message.setContent("hello,this is java send email to you!", "text/html;charset=UTF-8");

        // 发送邮件
        Transport.send(message);
    }

}
