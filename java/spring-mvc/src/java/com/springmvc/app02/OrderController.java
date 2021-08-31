package com.springmvc.app02;

import com.springmvc.app02.domain.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author huxingxin
 * @createTime 2021年08月11日 22:36:30
 * @Description
 */
@Controller
public class OrderController {

    /**
     * 添加订单
     * @param model
     * @param order
     * @return
     */
    @PostMapping("addOrder")
    public String addOrder(Model model, Order order){
        model.addAttribute("order",order);
        return "/jsp/editOrder";
    }
}
