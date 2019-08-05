package com.icode.testplatform.service;

import com.icode.testplatform.mapper.UserMapper;
import com.icode.testplatform.dto.BasicResponseDTO;
import com.icode.testplatform.entity.User;
import com.icode.testplatform.until.ResponseUntil;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
public class UserService {

    @Autowired
    UserMapper userDao;

    public BasicResponseDTO register(User user){
        BasicResponseDTO responseDTO=new BasicResponseDTO();
        responseDTO.setSuccess(false);
        if(Strings.isEmpty(user.getUsername()) || Strings.isEmpty(user.getPassword())){
            responseDTO.setCode(ResponseUntil.ARGERROR);
            return responseDTO;
        }
        try{
            user.setIsvalid(1);
            int flag= userDao.insertUser(user);
            if(flag>0){

                responseDTO.setSuccess(true);
                responseDTO.setCode(ResponseUntil.SUCCESS);
            }else{
                responseDTO.setSuccess(false);
                responseDTO.setCode(ResponseUntil.DBEERROR);
                responseDTO.setMessage("插入数据失败");
            }
        }catch (Exception ex){
            ex.getStackTrace();
            responseDTO.setCode(ResponseUntil.DBEERROR);
            responseDTO.setMessage("插入数据失败");
            return responseDTO;

        }
        return responseDTO;

    }
    public BasicResponseDTO login(User user, HttpServletRequest request){
        BasicResponseDTO responseDTO=new BasicResponseDTO();
        responseDTO.setSuccess(false);
        if(Strings.isEmpty(user.getUsername()) || Strings.isEmpty(user.getPassword())){
            responseDTO.setCode(ResponseUntil.ARGERROR);
            responseDTO.setMessage("用户名或密码为空，登陆失败");
            return responseDTO;
        }
        try{
            User userInfo= userDao.selectByUserNameAndPwd(user);
            if(userInfo!=null){

                responseDTO.setSuccess(true);
                responseDTO.setCode(ResponseUntil.SUCCESS);

                HttpSession session=request.getSession();
                session.setAttribute("userName",user.getUsername());
                session.setAttribute("userId",userInfo.getId());
            }else{
                responseDTO.setSuccess(false);
                responseDTO.setCode(ResponseUntil.DBEERROR);
                responseDTO.setMessage("用户名或密码错误，登陆失败");
            }
        }catch (Exception ex){
            ex.getStackTrace();
            responseDTO.setCode(ResponseUntil.DBEERROR);
            responseDTO.setMessage("登陆失败");
            return responseDTO;

        }
        return responseDTO;

    }
    public BasicResponseDTO loginOut(String userId, HttpServletRequest request){
        BasicResponseDTO responseDTO=new BasicResponseDTO();
        responseDTO.setSuccess(false);
        Long userID=Long.parseLong(userId);
        User user=userDao.selectById(userID);
        if(user!=null){
            request.getSession().removeAttribute("userName");
            request.getSession().removeAttribute("userId");
            responseDTO.setSuccess(true);
            responseDTO.setCode(ResponseUntil.SUCCESS);
        }
        return responseDTO;


    }

}
