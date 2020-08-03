package com.example.common.eventbusmanager;

/**
 * @Package: com.example.common.eventbusmanager
 * @ClassName: EventBusMessage
 * @Description: java类作用描述
 * @CreateDate: 2020/7/3 17:47
 * @UpdateDate: 2020/7/3 17:47
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class EventBusMessage {
    private String message;

    private EventBusMessage() {

    }

    private EventBusMessage(String message) {
        this.message = message;
    }

    public EventBusMessage getInstance(String message) {
        return new EventBusMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
