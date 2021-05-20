package ru.vienoulis.karabin.hostel.listener;

public interface MessageListener<T> {

    void messageReceived(T data);
}
