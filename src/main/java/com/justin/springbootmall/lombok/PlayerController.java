package com.justin.springbootmall.lombok;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @GetMapping("/test")
    public Player test(){
        Player player = new Player();
        player.setId(1);
        player.setName("Justin");
        return player;
    }
}
