package com.dengji85.demo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafTemplateAvailabilityProvider;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class TestEmail {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VelocityEngine velocityEngine;

	@Test
	public void testSimple() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("874504403@qq.com");
		message.setTo("dengji85@outlook.com");
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");
		mailSender.send(message);

	}

	@Test
	public void sendAttachmentsMail() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("874504403@qq.com");
		helper.setTo("dengji85@outlook.com");
		helper.setSubject("主題：有附件");
		helper.setText("有附件的郵件");
		File file = ResourceUtils
				.getFile("file:C:\\Users\\yangw\\Downloads\\a.jpg");

		helper.addAttachment("附件-1.jpg", file);
		helper.addAttachment("附件-2.jpg", file);
		mailSender.send(mimeMessage);
	}

	@Test
	public void sendInlineMail() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("874504403@qq.com");
		helper.setTo("dengji85@outlook.com");
		helper.setSubject("主題：有附件");
		helper.setText("<html><body><img src = \"cid:a\"></body></html>");
		File file = ResourceUtils
				.getFile("file:C:\\Users\\yangw\\Downloads\\a.jpg");
		helper.addInline("a", file);
		mailSender.send(mimeMessage);
	}

	@Test
	public void sendTemplaMail() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("874504403@qq.com");
		helper.setTo("dengji85@outlook.com");
		helper.setSubject("主題：模板邮件");
		Map<String, Object> model = new HashMap<>();
		model.put("username", "dengji85");
		String test = VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, "email.vm", "utf-8", model);
		helper.setText(test);
		mailSender.send(mimeMessage);
	}
}
