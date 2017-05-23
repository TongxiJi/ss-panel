package cn.wowspeeder.shadowsocks.controller;

import cn.wowspeeder.shadowsocks.ext.Result;
import cn.wowspeeder.shadowsocks.model.Node;
import cn.wowspeeder.shadowsocks.model.NodeExample;
import cn.wowspeeder.shadowsocks.model.User;
import cn.wowspeeder.shadowsocks.model.UserToken;
import cn.wowspeeder.shadowsocks.service.NodeService;
import cn.wowspeeder.shadowsocks.service.TokenService;
import cn.wowspeeder.shadowsocks.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private NodeService nodeService;

    @RequestMapping(value = "token", method = RequestMethod.GET)
    public Result token(@RequestParam String token) {
        UserToken t = tokenService.byToken(token);
        if (null == t) {
            return Result.fail("token is null");
        }
        return Result.ok("ok").setData(token);
    }

    @RequestMapping(value = "token", method = RequestMethod.POST)
    public Result newToken(@RequestParam String email,
                           @RequestParam String passwd) {

        if (StringUtils.isEmpty(email)) {
            return Result.fail("邮箱不能为空");
        }

        User user = userService.byEmail(email);
        if (null == user) {
            return Result.fail("401 邮箱或者密码错误");
        }


        if (!DigestUtils.md5DigestAsHex(passwd.getBytes()).equals(user.getPass())) {
            return Result.fail("402 邮箱或者密码错误");
        }

        try {
            String token = tokenService.create(user.getId());
            return Result.ok("ok").setData(token);
        } catch (Exception e) {
            LOGGER.error("创建token失败", e);
            return Result.fail("system error");
        }
    }

    @RequestMapping(value = "node", method = RequestMethod.GET)
    public Result node() {
        NodeExample example = new NodeExample();
        example.createCriteria()
                .andTypeEqualTo(1);
        example.setOrderByClause("sort desc");
        List<Node> nodes = nodeService.getNodes(example, null);
        return Result.ok("ok").setData(nodes);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public Result userInfo(@PathVariable int id, @RequestHeader(required = false,name = "token") String token, @RequestParam(required = false,name = "access_token") String access_token) {
        if (StringUtils.isEmpty(token)) {
            token = access_token;
        }
        UserToken t = tokenService.byToken(token);
        if (null == t || !t.getUserId().equals(id)) {
            return Result.fail("access denied");
        }
        User user = userService.getUserById(t.getUserId());
        return Result.ok("ok").setData(user);
    }

}