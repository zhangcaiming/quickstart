package com.scloud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Page<User> getUserList(){
        return userService.getUserList();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    private User getUserById(@RequestParam("id") Long id){
       return userService.getUserById(id);
    }

    // 更新user对象的全部信息用 PUT 更新部分信息用PATCH
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public User update(@RequestParam("user") User user){
       return userService.update(user);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable("id") Long id){
        userService.delete(id);
    }

    //新建一个User对象用 POST
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public User addUser(@RequestParam("user") User user){
       return userService.add(user);
    }


}
