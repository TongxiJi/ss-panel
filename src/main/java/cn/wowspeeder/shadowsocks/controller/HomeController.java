package cn.wowspeeder.shadowsocks.controller;


import cn.wowspeeder.shadowsocks.model.InviteCode;
import cn.wowspeeder.shadowsocks.model.InviteCodeExample;
import cn.wowspeeder.shadowsocks.service.ConfigService;
import cn.wowspeeder.shadowsocks.service.InviteCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private ConfigService configService;

    @Autowired
    private InviteCodeService inviteCodeService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        String homeIndexMsg = configService.getConfig("home-index");
        return new ModelAndView("index", "homeIndexMsg", homeIndexMsg);
    }

    @RequestMapping(value = "code", method = RequestMethod.GET)
    public ModelAndView code() {
        Map<String, Object> data = new HashMap<>();
        String msg = configService.getConfig("home-code");
        InviteCodeExample example = new InviteCodeExample();
        example.createCriteria().andUserIdEqualTo(0);
        example.setOrderByClause("id desc limit 10");
        List<InviteCode> codes = inviteCodeService.getCodes(example);
        data.put("msg", msg);
        data.put("codes", codes);
        return new ModelAndView("code", data);
    }

    @RequestMapping(value = "tos", method = RequestMethod.GET)
    public ModelAndView tos() {
        return new ModelAndView("tos");
    }

}
