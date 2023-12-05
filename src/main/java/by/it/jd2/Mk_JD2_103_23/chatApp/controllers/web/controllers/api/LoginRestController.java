package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.controllers.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.CredentialsDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserLoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginRestController {
    private final IUserLoginService service;

    public LoginRestController(IUserLoginService service) {
        this.service = service;
    }

    @GetMapping
    public User login(@RequestParam("login") String login,
                      @RequestParam("password") String password
    ) {
        CredentialsDTO credentials = new CredentialsDTO(login, password);
        return this.service.login(credentials);
    }
}
