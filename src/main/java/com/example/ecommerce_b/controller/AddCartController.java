package com.example.ecommerce_b.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce_b.form.AddCartForm;
import com.example.ecommerce_b.service.AddCartService;

/**
 * 
 * 
 * @author 萩田
 *
 */
@Controller
@RequestMapping("/cart")
public class AddCartController {

	@Autowired
	private AddCartService addCartService;

	@Autowired
	private HttpSession session;

	/**
	 * 商品詳細ページ.
	 * 
	 * @return
	 */
	@GetMapping("")
	public String index() {
		return "item_detail";
	}

	/**
	 * カート追加.
	 * 
	 * @param form   カートフォーム
	 * @param userId ユーザーID
	 * @param model  リクエストパラメータ
	 * @return カート画面
	 */
	@PostMapping("/cart-add")
	public String addCart(AddCartForm form, Integer userId, Model model) {
//		String num = session.getAttribute(session.getId()).toString();
//		List<String> itemId = new ArrayList<>();
		if (session.getAttribute("userId") == null) {
//			itemId.add(num);
//			itemId.add(form.getItemId().toString());
//			session.setAttribute(session.getId(), itemId);
//			Integer nums = session.hashCode();
//			System.out.println(session.hashCode());
			return "redirect:/login";
		}
		addCartService.AddOrder(form, userId);
		return "redirect:/show-cart";
	}

//	@GetMapping("/")

}
