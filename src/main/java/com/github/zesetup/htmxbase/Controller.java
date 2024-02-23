package com.github.zesetup.htmxbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

  @GetMapping({"/"})
  public String getIdForm() {
    return "index";
  }

  @GetMapping({"/space/"})
  public String hello(@RequestParam(value = "username", required = true) String userName,
      Model model) {
    model.addAttribute("username", userName);
    return "space";
  }

  @GetMapping({"/validate-username/"})
  public String validateUserId(
      @RequestParam(value = "username", required = false) String userName) {
    if (userName == null || userName.isEmpty()) {
      System.out.println("button-disabled");
      return "button-disabled";
    }
    if (userName.length() >= 2) {
      System.out.println("button-enabled");
      return "button-enabled";
    } else {
      System.out.println("button-disabled");
      return "button-disabled";
    }
  }


}

