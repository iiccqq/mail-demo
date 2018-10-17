package com.demo.mail.maildemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class MailDemoApplication implements CommandLineRunner {

	@Autowired
	private JavaMailSender mailSender;

	public static void main(String[] args) {
		SpringApplication.run(MailDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("feng.chuang@163.com");
		message.setTo("feng.chuang@163.com");
		message.setSubject("it is a test for spring boot");
		message.setText("你好，我正在测试发送邮件。");
		try {
			mailSender.send(message);
			System.out.println("测试邮件已发送。");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
