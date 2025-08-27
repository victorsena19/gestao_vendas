package com.java.gestao_vendas.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarEmailRedefinicaoSenha(String email, String nomeUsuario, String linkRedefinicao) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(email);
            helper.setSubject("Redefinir sua senha");
            helper.setFrom("pcoe@sistema.com");

            String htmlContent = carregarTemplateEmail(nomeUsuario, linkRedefinicao);
            helper.setText(htmlContent, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Erro ao enviar email", e);
        }
    }

    private String carregarTemplateEmail(String nomeUsuario, String linkRedefinicao) {
        String template = """
            <!DOCTYPE html>
            <html lang="pt-BR">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Redefinir Senha</title>
                </head>
                <body style="margin: 0; padding: 0; font-family: Arial, sans-serif; background-color: #f5f5f5;">
                    <div style="max-width: 600px; margin: 0 auto; background-color: white; padding: 40px 20px;">
                        <div style="text-align: center; margin-bottom: 40px;">
                            <div style="width: 60px; height: 60px; background-color: #1D4ED8; border-radius: 50%; margin: 0 auto; display: flex; align-items: center; justify-content: center;">
                                <span style="color: white; font-size: 24px; font-weight: bold;">S</span>
                            </div>
                            <h2 style="color: #1D4ED8; margin-top: 10px; font-size: 24px;">Sistema PCOE</h2>
                        </div>
    
                        <h1 style="font-size: 32px; color: #1f2937; text-align: center; margin-bottom: 30px; font-weight: bold;">
                            Olá, {{NOME_USUARIO}}!
                        </h1>
    
                        <p style="font-size: 16px; color: #4b5563; line-height: 1.6; text-align: center; margin-bottom: 30px;">
                            Está com problemas para acessar sua conta? A gente ajuda.
                            Selecione o botão abaixo para <strong style="background-color: #fef3c7;">redefinir</strong> sua <strong style="background-color: #fef3c7;">senha</strong>.
                            Este link é válido por 30 minutos.
                        </p>
    
                        <div style="text-align: center; margin: 40px 0;">
                            <a href="{{LINK_REDEFINICAO}}"
                               style="background-color: #1D4ED8; color: white; padding: 15px 40px;
                                      text-decoration: none; border-radius: 25px; font-weight: bold;
                                      font-size: 16px; display: inline-block; text-transform: uppercase;">
                                REDEFINIR SENHA
                            </a>
                        </div>
                        <div style="margin-top: 50px; padding-top: 20px; border-top: 1px solid #e5e7eb; text-align: center;">
                            <p style="font-size: 12px; color: #9ca3af;">
                                Se você não solicitou esta alteração, pode ignorar este e-mail com segurança.
                            </p>
                            <p style="font-size: 12px; color: #9ca3af; margin-top: 10px;">
                                © 2025 Sistema PCOE. Todos os direitos reservados.
                            </p>
                        </div>
                    </div>
                </body>
            </html>
        """;

    return template
            .replace("{{NOME_USUARIO}}", nomeUsuario)
            .replace("{{LINK_REDEFINICAO}}", linkRedefinicao);
    }
}
