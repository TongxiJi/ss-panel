package cn.wowspeeder.shadowsocks.utils;

import cn.wowspeeder.shadowsocks.Application;
import cn.wowspeeder.shadowsocks.common.SpConst;
import cn.wowspeeder.shadowsocks.exception.TipException;
import cn.wowspeeder.shadowsocks.ext.Envelope;
import jetbrick.template.JetEngine;
import jetbrick.template.JetTemplate;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by biezhi on 2017/2/13.
 */
public final class EmailUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtils.class);

    private static JetEngine engine = JetEngine.create();

    public static String getHtml(String tpl, Map<String, Object> ary) {
        // 2. 获取一个模板对象 (从默认的 classpath 下面)
        JetTemplate template = engine.getTemplate(tpl);
        StringWriter writer = new StringWriter();
        Map<String, Object> context = new HashMap<>();
        context.put("config", Application.getContext().getEnvironment());
        context.put("analyticsCode", "");
        if (null != ary && ary.size() > 0) {
            context.putAll(ary);
        }
        template.render(context, writer);
        return writer.toString();
    }

    public static void send(final Envelope envelope) {
        if (null != envelope) {
            try {
                // Create the email message
                HtmlEmail email = new HtmlEmail();
                email.setHostName(Application.getEnvValue("mail.smtp.host"));
                email.addTo(envelope.getTo());
                //email.setStartTLSEnabled(true);
                email.setFrom(Application.getEnvValue("mail.user"), Application.getEnvValue("mail.from"));
                email.setAuthentication(Application.getEnvValue("mail.user"), Application.getEnvValue("mail.pass"));
                email.setCharset("UTF-8");

                email.setSubject(envelope.getSubject());
                String html = getHtml(envelope.getTpl(), envelope.getCry());
                email.setHtmlMsg(html);
                email.send();
            } catch (Exception e) {
                LOGGER.error("邮件发送失败", e);
                throw new TipException(e);
            }
        }

    }
}
