package services;

import java.io.IOException;
import java.net.URISyntaxException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;


public class EmailService<Response> {
	public void sendEmail(String email, String subj, String toe, String body) throws IOException, URISyntaxException {
		Email from = new Email(email);
	    String subject = subj;
	    Email to = new Email(toe);
	    Content content = new Content("text/plain", body);
	    Mail mail = new Mail(from, subject, to, content);
	    String key = "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"; 
	    System.out.println(key);
	    SendGrid sg = new SendGrid(key);
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(((Object) response).getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      throw ex;
	    }
	}


}
