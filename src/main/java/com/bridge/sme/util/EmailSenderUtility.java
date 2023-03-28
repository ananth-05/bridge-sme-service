package com.bridge.sme.util;

import com.bridge.sme.dto.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailSenderUtility {

    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;

    public void sendHtmlMessage(Email email) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            Context context = new Context();
            context.setVariables(email.getProperties());
            helper.setFrom(email.getFrom());
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            String html = templateEngine.process(email.getTemplate(), context);
            helper.setText(html, true);
            emailSender.send(message);
            log.info("Email sent...");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
