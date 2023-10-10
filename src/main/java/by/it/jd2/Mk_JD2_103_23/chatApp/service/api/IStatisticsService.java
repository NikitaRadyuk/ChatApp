package by.it.jd2.Mk_JD2_103_23.chatApp.service.api;

import java.util.Map;

public interface IStatisticsService {
    long incSessionCount();
    long decSessionCount();
    long getSessionCount();
    Map<String, Object> getStats();
}
