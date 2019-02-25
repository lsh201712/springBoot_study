package com.sky.controller;

import com.sky.pojo.Users;
import com.sky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    /**
     * 页面跳转
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return  page;
    }


    /**
     * 添加用户
     * 增加数据校验
     */
    @RequestMapping("addUser")
    public  String addUser(@Valid  Users users, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/users/findUserAll";
        }
        this.userService.addUser(users);
        return "ok";
    }

    /**
     * 查询用户
     */
    @RequestMapping("findUserAll")
    public String findUserAll(Model model){
        List<Users> list = this.userService.findUserAll();
        model.addAttribute("list",list);
        return "showUsers";
    }

    /**
     * 根据id查询用户
     */
    @RequestMapping("findUserById")
    public String findUserById(Integer id,Model model){
        Users users = this.userService.selectUsersById(id);
        model.addAttribute("user",users);
        return "updateUsers";
    }
    /**
     * 更新用户
     */
    @RequestMapping("editUser")
    public String editUser(Users users){
        this.userService.updateUser(users);
        return  "ok";
    }
    /**
     * 删除用户
     */
    @RequestMapping("delUser")
    public String delUser(Integer id){
        this.userService.deleteUserById(id);
        return "redirect:/users/findUserAll";
    }

}
