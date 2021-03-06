package com.example.sbs.lolHi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.sbs.lolHi.dto.Member;
import com.example.sbs.lolHi.service.MemberService;
import com.example.sbs.lolHi.util.Util;

@Component("beforeActionInterceptor") // 컴포넌트 이름 설정
public class BeforeActionInterceptor implements HandlerInterceptor {

	@Autowired
	private MemberService memberService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		boolean isAjax = false;
		boolean isLogined = false;
		Member loginedMember = null;
		int loginedMemberId = 0;

		if (session.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) session.getAttribute("loginedMemberId");
			loginedMember = memberService.getMemberById(loginedMemberId);
		}

		request.setAttribute("isLogined", isLogined);
		request.setAttribute("isAjax", isAjax);
		request.setAttribute("loginedMemberId", loginedMemberId);
		request.setAttribute("loginedMember", loginedMember);

		// 현재 URL

		String currentUri = request.getRequestURI();

		if (request.getQueryString() != null) {
			currentUri += "?" + request.getQueryString();
		}

		String encodedCurrentUri = Util.getUriEncoded(currentUri);

		request.setAttribute("currentUri", currentUri);
		request.setAttribute("encodedCurrentUri", encodedCurrentUri);

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
