package cn.wowspeeder.shadowsocks.controller.admin;

import cn.wowspeeder.shadowsocks.common.SpConst;
import cn.wowspeeder.shadowsocks.ext.Envelope;
import cn.wowspeeder.shadowsocks.ext.Result;
import cn.wowspeeder.shadowsocks.utils.DateKit;
import cn.wowspeeder.shadowsocks.utils.EmailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
//@Controller("admin")
//public class TestController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
//
//    @RequestMapping(value = "test/sendmail", method = RequestMethod.GET)
//    public ModelAndView sendmail(){
//        return new ModelAndView("admin/test/sendmail");
//    }
//
//    @RequestMapping(value = "test/sendmail", method = RequestMethod.POST)
//    @ResponseBody
//    public Result sendmailPost(@RequestParam String email){
//        Map<String, Object> ary = new HashMap<>();
//        ary.put("time", DateKit.getToday("yyyy-MM-dd HH:mm:ss"));
//        ary.put("appName", SpConst.APP_PROPERTIES.get("app.appName"));
//        try {
//            Envelope envelope = new Envelope(email, "/email/test.html", "Test", ary);
//            EmailUtils.send(envelope);
//        } catch (Exception e){
//            LOGGER.error("邮件发送失败", e);
//            return Result.fail("发送失败");
//        }
//        return Result.ok("发送成功");
//    }
//
//}
