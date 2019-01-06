package com.wisely.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 通过@ControllerAdvice可以将对控制器的全局配置放置在这个建言中
 * 这样注解了@Controller的类的方法就可以使用@ExceptionHandler/@InitBinder/@ModelAttribute注解到方法上
 * 这对所有注解了@RequestMapping的方法都有效
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 用于全局处理控制器里的异常
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)//这里表示会拦截所有的Exception
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    /**
     * 让@RequestMapping注解的方法都能获得用@ModelAttribute方法设置的键值对
     * @param model
     */
    @ModelAttribute
    public void addAttribute(Model model) {
        //将键值对添加到全局model
        model.addAttribute("msg", "额外信息");
    }

    /**
     * 用来设置WebDataBinder，WebDataBinder用来自动绑定前台请求参数到Model中
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        //表示忽视request的参数id
        webDataBinder.setDisallowedFields("id");
    }
}
