package temp.dionysus.mailservice.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import temp.dionysus.mailservice.MailService;

public class MimeMailService implements MailService {

	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }
    
	@Override
	public void sendMail(String from, String to, String subject, String msg) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
            	MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(to);
                message.setFrom(from); // could be parameterized...
                message.setSubject(subject);
                message.setText(msg, true);
            }
        };

        try {
            this.mailSender.send(preparator);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
	}

	@Override
	public void sendRegConfirmMail(String from, String to, Object customer) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
            	MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(to);
                message.setFrom(from); // could be parameterized...
                message.setSubject("Thank you for registering");
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("user", customer);
                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, "templates/registration-confirmation.vm", "UTF-8", model);
                message.setText(text, true);
            }
        };

        try {
            this.mailSender.send(preparator);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
	}

}
