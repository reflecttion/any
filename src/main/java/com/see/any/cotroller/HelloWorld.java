package com.see.any.cotroller;

import com.see.any.dao.pojo.Hello;
import com.see.any.modol.HelloModel;
import com.see.any.modol.ReqBody;
import com.see.any.service.HelloService;
import com.see.any.utils.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@Controller
public class HelloWorld {
    @Autowired
    private HelloService HelloService;

    @Autowired
    private Resource resource;

//    @RequestMapping(value = "index")
//    public String index(ModelMap map){
//        map.addAttribute("list",resource);
//        return "freemarker/index";
//    }

    @RequestMapping("index")
    public String index(Model model) {
        Map map = new LinkedHashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put("key" + i, "value" + i);
        }
        model.addAttribute("list", Arrays.asList("string1", "string2", "string3", "string4", "string5", "string6"));
        model.addAttribute("map", map);
        model.addAttribute("name", "   htTps://wWw.zHyD.mE   ");
        model.addAttribute("htmlText", "<span style=\"color: red;font-size: 16px;\">html内容</span>");
        model.addAttribute("num", 123.012);
        model.addAttribute("null", null);
        model.addAttribute("dateObj", new Date());
        model.addAttribute("bol", true);
        return "freemarker/index";
    }

    @RequestMapping(value ="center")
    public String  center(ModelMap map){
        map.put("users",parseUsers());
        map.put("title","用户列表");
        return "freemarker/center/center";
    }

    private List<Map> parseUsers(){
        List<Map> list= new ArrayList<>();
        for(int i=0;i<10;i++){
            Map map= new HashMap();
            map.put("name","kevin_"+i);
            map.put("age",10+i);
            map.put("phone","1860291105"+i);
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value = "/")
    public String index() {
        return "home/index";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Hello> list() {
        return HelloService.selectAll();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post(
            @RequestBody ReqBody map
    ) throws IOException {
        return "输入的姓名是" + map.getName() + ",电子邮件是:" + map.getEmail();
    }
}
