package cn.wowspeeder.shadowsocks.controller.mu2;

import cn.wowspeeder.shadowsocks.ext.Result;
import cn.wowspeeder.shadowsocks.model.User;
import cn.wowspeeder.shadowsocks.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:TongxiJi E-MAIL:694270875@qq.com
 * Function:
 * Create Date:五月23,2017
 * https://github.com/orvice/ss-panel/blob/master/app/Controllers/MuV2/UserController.php
 */
@RestController("mu2UserController")
@RequestMapping("/mu2")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public Result index() {
        // TODO: 2017/5/23
        List<User> users = userService.getUsers(null, new RowBounds());
        return Result.ok().setData(users);
    }
}
