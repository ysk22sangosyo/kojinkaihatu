package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.enitity.User;
import com.example.form.UpdateForm;
import com.example.service.UserService;

@Controller
public class UpdateController {
	   /**
     * メッセージリソース用
     */
    @Autowired
    MessageSource messageSource;
    @Autowired
    UserService userService;
    @Autowired
    //セッションを取得
    HttpSession session;
 // 更新画面遷移
 
    @RequestMapping(value = "/updateInput", method = RequestMethod.GET)
    public String update(@ModelAttribute("updateInput") UpdateForm updateform,Model model) {
    	System.out.println("honorr");
        return "updateInput";
        
    }
    
 
//	// 登録画面遷移
//    @RequestMapping(value = "/characterRegister", method = RequestMethod.GET)
//    public String characterRegister(@ModelAttribute("characterRegister") CharaForm charaform, Model model) {
//        return "characterRegister";
//    }
    //更新処理
	@RequestMapping(value = "updateInput", method = RequestMethod.POST)
    public String update(@Validated @ModelAttribute("updateInput") UpdateForm updateform, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
        	System.out.println("honorr");
            return "updateInput";
        }
        System.out.println("honorrsoto");
        User user = new User(updateform.getUserId(), updateform.getPassword(),updateform.getName(),updateform.getProfile(),updateform.getImg());
     
        userService.update(user);
    	session.setAttribute("user",user);
		session.setAttribute("userId",user.getUserId());
		session.setAttribute("userName",user.getName());
		session.setAttribute("userIcon",user.getImg());
		session.setAttribute("userProfile",user.getProfile());
        return "userPage";
    }
}
