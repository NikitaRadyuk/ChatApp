package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IMessageService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IStatisticsService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserRegService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.factory.UserRegServiceFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Реализация сервиса статистики
 */
public class StatisticsService implements IStatisticsService {

    public static final StatisticsService instance = new StatisticsService();

    private final AtomicLong sessionCounter;
    private final IUserRegService userService;
    private final IMessageService messageService;

    public StatisticsService() {
        this.sessionCounter = new AtomicLong(0);
        this.userService = UserRegServiceFactory.getInstance();
        this.messageService = MessageService.getInstance();
    }


    @Override
    public long incSessionCount() {
        return this.sessionCounter.incrementAndGet();
    }

    @Override
    public long decSessionCount() {
        return this.sessionCounter.decrementAndGet();
    }

    @Override
    public long getSessionCount() {
        return this.sessionCounter.get();
    }

    @Override
    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("Количество пользователей", this.userService.getCount());
        stats.put("Количество сообщений", this.messageService.getCount());
        stats.put("Количество активных пользователей", this.getSessionCount());
        return stats;
    }

    public static StatisticsService getInstance(){
        return instance;
    }
}
