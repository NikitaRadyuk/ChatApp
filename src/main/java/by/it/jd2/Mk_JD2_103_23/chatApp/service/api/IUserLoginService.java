package by.it.jd2.Mk_JD2_103_23.chatApp.service.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.CredentialsDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;

import java.util.Collection;

/**
 * Интерфейс Сервис для авторизации пользователя
 */
public interface IUserLoginService {

    User login(CredentialsDTO credentialsDTO);

    Collection<User> getAllUsers();
}
