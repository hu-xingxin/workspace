package com.springboot.demo2;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.demo1.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

/**
 * @author huxingxin
 * @createTime 2021年08月13日 10:43:30
 * @Description
 */
@Controller
public class OrderController {

    @PostMapping("editOrder")
    public String editOrder(Order order, Model model){
        model.addAttribute("order",order);

        //将order 转换成json格式返回
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("order",order);
        model.addAttribute("data",jsonObject.toString());
        return "/demo2/editOrder";
    }
}
