package com.vote.interceptor;

import com.vote.service.UserService;
import com.vote.utils.HyResult;
import com.vote.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class VoteInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 比赛的id
        String voteId = request.getParameter("voteId");

        // 用户的ip
        String ip = request.getRemoteAddr();
        ip = ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
        System.out.println("ip=" + ip);

        boolean isVote = userService.checkUserIsVote(Integer.valueOf(voteId), ip);
        // 已经投过票了
        if (isVote){
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Cache-Control","no-cache");
            response.setContentType("application/json;charset=UTF-8");
            String result = JsonUtil.pojoToJson(HyResult.build(400, "你已经投过票了"));
            response.getWriter().write(result);
            return false;
        }
        // 没有投过票
        return true;
    }
}
