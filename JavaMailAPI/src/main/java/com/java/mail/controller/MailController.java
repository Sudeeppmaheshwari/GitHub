package com.java.mail.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {

	@RequestMapping("/sendmail")
	public ModelAndView sendEmail() {

		String to = "sudip.maheshwari@indianic.com";// change accordingly

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.zoho.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"help@ticketsgrab.com", "difference2020");// change
																		// accordingly
					}
				});

		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("help@ticketsgrab.com"));// change
																			// accordingly
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject("Hello");
			message.setText("Testing.......");

			// send message
			Transport.send(message);

			System.out.println("message sent successfully");
			return (new ModelAndView("sentmail"));
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		

	}

}
