package com.scloud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/getList")
    public Page<User> getUserList(@RequestParam("address") String address){
      return userRepository.findByAddressOrderByUserNameDesc(address,new PageRequest(1,10));
    }

    @GetMapping(value = "/getByName")
    private User getUserByName(@RequestParam("name") String name){
        return userRepository.getUserByName(name);
    }

    @PostMapping(value = "/update")
    public User updateUserNameById(@RequestParam("name") String name,@RequestParam("id") Long id){
        return userRepository.updateUserName(name,id);
    }

    @GetMapping(value = "/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userRepository.delete(id);
    }

    @PostMapping(value = "/save")
    public User addUser(@RequestParam("userName") String userName,
                        @RequestParam("nickName") String nickName,
                        @RequestParam("password") String password,
                        @RequestParam("address") String address,
                        @RequestParam("phone") String phone,
                        @RequestParam("email") String email){

        User user = new User(userName,nickName,password,address,phone,email);
        return userRepository.save(user);
    }

    @GetMapping(value = "/getByNickName/{nickName}")
    public User getByNickName(@PathVariable("nickName") String nickName){
        return userRepository.getByNickName(nickName);
    }


}
