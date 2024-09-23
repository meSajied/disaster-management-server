package org.disastermanagement.users;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
@RequestMapping("/user")
public class UserController {
  private final UserService userService;

  UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{username}")
  Optional<AppUser> getUser(@PathVariable String username) {
    return userService.findUserByUsername(username);
  }

  @GetMapping("/login")
  public Optional<AppUser> login(@RequestParam String username, 
      @RequestParam String password) {
    Optional<AppUser> userOptional = userService.findUserByUsername(username);

    if (userOptional.isPresent()) {
      AppUser userDb = userOptional.get();

      if (!password.equals(userDb.getPassword())) {
        return null;
      }else {
        return userOptional;
      }
    }else {
      return null;
    }
  }

  @PostMapping("/signup")
  public AppUser signup(@RequestBody AppUser user) {
    return userService.createUser(user);
  }

  @PutMapping("/update")
  public Optional<AppUser> update(@RequestBody AppUser userData) {
    return userService.updateUser(userData);
  }

  @GetMapping("/get-all")
  public List<AppUser> getAllUsers() {
    return userService.getAllUsers();
  }
}