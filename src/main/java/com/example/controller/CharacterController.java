package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.enitity.Chara;
import com.example.form.CharaForm;
import com.example.service.CharaService;
@Controller
public class CharacterController {
	@Autowired
	//セッションを取得
	HttpSession session;
	@Autowired
	CharaService charaService;
	// 登録画面遷移
    @RequestMapping(value = "/characterRegister", method = RequestMethod.GET)
    public String characterRegister(@ModelAttribute("characterRegister") CharaForm charaform, Model model) {
        return "characterRegister";
    }
	//登録処理	
	@RequestMapping(value = "characterRegister", method = RequestMethod.POST)
    public String insert(@Validated @ModelAttribute("characterRegister") CharaForm charaform, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        Chara chara = new Chara(charaform.getCharacterId(),  charaform.getCharacterName(),charaform.getSex(),charaform.getOld(),charaform.getJob(),charaform.getProfile(),charaform.getImg());
     
        charaService.insert(chara);
      

        return "charaRegisterResult";
    }
	//全件表示
	@RequestMapping("/userPage")
	public String list(Model model) {
		List<Chara> chara = charaService.findAll();
		model.addAttribute("charaList", chara);
		return "userPage";
	}
	
	/*
	 * 詳細画面への遷移
	 */
	@GetMapping("/detail/{charaId}")
	public String detail(@PathVariable("charaId") String charaId, Model model) {
		model.addAttribute("chara", charaService.selectId(charaId));
		return "detail";
	}
	
	/*
	 * 検索ボタン押下時
	 */
	@RequestMapping(value = "/search")
	public String search(@RequestParam("characterName") String characterName ,Model model) {
		model.addAttribute("productList", charaService.selectName(characterName));
		System.out.println(charaService.selectName(characterName));
		return "userPage";
	}
//	//ID取得
//	// 入力値取得

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String auth(@Validated @ModelAttribute("login") CharaForm form, BindingResult bindingResult,Model model) {
//		if(bindingResult.hasErrors()) {
//			System.out.print("adfs");
//			return "login";
//		}
//		// 入力値取得
//		String charaId = form.getCharacterId();
//		CharaService charaService;
//		List<Chara> charaList =charaService.selectId(charaId);
////		System.out.print(loginId);
//////		System.out.print(password);
//
//	
//	
//	}
}
