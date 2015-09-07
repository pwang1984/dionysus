package temp.dionysus.mailservice;

public interface MailService {
	public void sendMail(String from, String to, String subject, String msg);
	
	public void sendRegConfirmMail(String from, String to, Object customer);
}
