package test;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

public class SendGridExample {
  public static void main(String[] args) {

    SendGrid sendgrid = new SendGrid("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"); // recommended

    SendGrid.Email email = new SendGrid.Email();

    email.addTo("prasad.inna@gmail.com");
    email.setFrom("test@prapp-devincorp.com");
    email.setSubject("Sending with SendGrid is Fun");
    email.setHtml("and easy to do anywhere, even with Java");


    try {
		SendGrid.Response response = sendgrid.send(email);
	} catch (SendGridException e) {
		
		e.printStackTrace();
	}
  }
}
