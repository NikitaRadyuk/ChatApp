package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IStatisticsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Реализация сервиса статистики
 */
@Service
public class StatisticsService implements IStatisticsService {
    private final AtomicLong sessionCounter;
    //private final IUserRegService userService;
    //private final IMessageService messageService;

    public StatisticsService() {
        this.sessionCounter = new AtomicLong(0);
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
        //stats.put("Количество пользователей", this.userService.getCount());
        //stats.put("Количество сообщений", this.messageService.getCount());
        stats.put("Количество активных пользователей", this.getSessionCount());
        return stats;
    }
}
