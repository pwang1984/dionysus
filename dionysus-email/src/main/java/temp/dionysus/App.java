package temp.dionysus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import temp.dionysus.mailservice.impl.SimpleMailService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
                new ClassPathXmlApplicationContext("bean.xml");
       	 
       	SimpleMailService sms = (SimpleMailService) context.getBean("simpleMailService");
       	sms.sendMail("no_reply@volantesystems.com",
       		   "czhang@volantesystems.com",
       		   "Testing123", 
       		   "Testing only \n\n Hello Spring Email Sender");
    }
}
