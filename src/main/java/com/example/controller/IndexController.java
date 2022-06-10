package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.enitity.User;
import com.example.form.LoginForm;
import com.example.form.RegisterForm;
import com.example.service.UserService;

@Controller
public class IndexController {

@Autowired
UserService userService;

@Autowired
//セッションを取得
HttpSession session;
	//トップ画面表示
	@RequestMapping("/top")
	public String index(Model model) {
		return "top";
	}

	// ログイン画面遷移
	    @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(@ModelAttribute("login") LoginForm form, Model model) {
	        return "login";
	    }
	    
	 // ログアウト画面遷移
	    @RequestMapping("/logout")
	    public String logout(Model model) {
	        return "logout";
	    }
	    
		// 登録画面遷移
	    @RequestMapping(value = "/register", method = RequestMethod.GET)
	    public String register(@ModelAttribute("register") RegisterForm legisterform, Model model) {
	        return "register";
	    }

	//    // ログイン処理
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String auth(@Validated @ModelAttribute("login") LoginForm form, BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			System.out.print("adfs");
			return "login";
		}
		// 入力値取得
		String userId = form.getUserId();
		String password = form.getPassword();
//		System.out.print(loginId);
//		System.out.print(password);

		User user =userService.login(userId, password);
		if(user == null) {
			model.addAttribute("errorMsg", "IDまたはパスワードが不正です。");
			return "/login";
		}

		session.setAttribute("user",user);
		session.setAttribute("userId",user.getUserId());
		session.setAttribute("userName",user.getName());
		session.setAttribute("userIcon",user.getImg());
		session.setAttribute("userProfile",user.getProfile());
//		
		
		return "userPage";

	}
//登録処理	
	@RequestMapping(value = "register", method = RequestMethod.POST)
    public String insert(@Validated @ModelAttribute("register") RegisterForm registerform, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        User user = new User(registerform.getUserId(),  registerform.getPassword(),registerform.getName(),registerform.getProfile(),registerform.getImg());
     
        userService.insert(user);

        return "insertResult";
    }
}
