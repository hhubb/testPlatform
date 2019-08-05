package com.icode.testplatform.control;

import com.icode.testplatform.dto.BasicResponseDTO;
import com.icode.testplatform.entity.User;
import com.icode.testplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/layout",method = RequestMethod.GET)
    public String indexPost(){
        return "layout";
    }


    @RequestMapping(value="/home/index",method = RequestMethod.GET)
    public String index(){
        return "home/index";
    }

    /**
     * 注册
     * @param registerUser
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/layout/register",method = RequestMethod.POST)
    public BasicResponseDTO register(@RequestBody User registerUser){
        BasicResponseDTO responseDTO = userService.register(registerUser);

        return responseDTO;
    }
    /**
     * 登陆
     * @param registerUser
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/layout/login",method = RequestMethod.POST)
    public BasicResponseDTO login(@RequestBody User registerUser, HttpServletRequest request){
        BasicResponseDTO responseDTO = userService.login(registerUser,request);

        return responseDTO;
    }
    /**
     * 退出
     */
    @ResponseBody
    @RequestMapping(value="/layout/loginOut" ,method = RequestMethod.POST)
    public BasicResponseDTO loginOut(@RequestBody String userId, HttpServletRequest request){
        BasicResponseDTO responseDTO = userService.loginOut(userId,request);
        return responseDTO;
    }
}
