package cn.wowspeeder.shadowsocks.controller.admin;

import cn.wowspeeder.shadowsocks.common.SpConst;
import cn.wowspeeder.shadowsocks.ext.Result;
import cn.wowspeeder.shadowsocks.model.Node;
import cn.wowspeeder.shadowsocks.model.NodeExample;
import cn.wowspeeder.shadowsocks.service.NodeService;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller("")
@RequestMapping("/admin/node")
public class NodeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NodeController.class);

    @Autowired
    private NodeService nodeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView node() {
        List<Node> nodes = nodeService.getNodes(new NodeExample(), new RowBounds());
        return new ModelAndView("/admin/node/index", "nodes", nodes);
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("/admin/node/create", "method", SpConst.METHODS);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestParam String name, @RequestParam String server,
                      @RequestParam String method, @RequestParam(required = false) Integer custom_method,
                      @RequestParam(required = false) Float rate, @RequestParam String info,
                      @RequestParam(required = false) Integer type, @RequestParam String status, @RequestParam(required = false) Integer sort) {
        Node node = new Node();
        node.setName(name);
        node.setServer(server);
        node.setMethod(method);
        node.setCustomMethod(custom_method == 1);
        node.setTrafficRate(rate);
        node.setInfo(info);
        node.setType(type);
        node.setStatus(status);
        node.setSort(sort);

        try {
            nodeService.save(node);
        } catch (Exception e) {
            LOGGER.error("添加节点失败", e);
            return Result.fail("添加失败");
        }
        return Result.ok("节点添加成功");
    }

    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Integer id) {
        Node node = nodeService.byId(id);
        HashMap<String, Object> data = new HashMap<>();
        data.put("node", node);
        data.put("method", SpConst.METHODS);
        return new ModelAndView("/admin/node/edit", data);
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@PathVariable Integer id, @RequestParam String name, @RequestParam String server,
                         @RequestParam String method, @RequestParam int custom_method,
                         @RequestParam Float rate, @RequestParam String info,
                         @RequestParam int type, @RequestParam String status, @RequestParam int sort) {

        Node node = new Node();
        node.setId(id);
        node.setName(name);
        node.setServer(server);
        node.setMethod(method);
        node.setCustomMethod(custom_method == 1);
        node.setTrafficRate(rate);
        node.setInfo(info);
        node.setType(type);
        node.setStatus(status);
        node.setSort(sort);

        try {
            nodeService.update(node);
        } catch (Exception e) {
            LOGGER.error("修改节点失败", e);
            return Result.fail("修改失败");
        }
        return Result.ok("修改成功");
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable Integer id) {
        try {
            nodeService.delete(id);
        } catch (Exception e) {
            LOGGER.error("删除节点失败", e);
            return Result.fail("删除失败");
        }
        return Result.ok("删除成功");
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    public ModelAndView deleteGet(@PathVariable Integer id) {
        try {
            nodeService.delete(id);
            return new ModelAndView("redirect:/admin/node");
        } catch (Exception e) {
            LOGGER.error("删除节点失败", e);
            return new ModelAndView("redirect:/error");
        }
    }

}
