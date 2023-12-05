package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.controllers.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.UserDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserRegService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/reg")
public class UserRestController {
    private final IUserRegService service;

    public UserRestController(IUserRegService service) {
        this.service = service;
    }

    @GetMapping
    public User signUp(@RequestParam("login") String login,
                       @RequestParam("password") String password,
                       @RequestParam("username") String username,
                       @RequestParam("birthday") LocalDate birthday
    ) {
        UserDTO user = new UserDTO(login, password, username, birthday);
        return this.service.sighUp(user);
    }
}
