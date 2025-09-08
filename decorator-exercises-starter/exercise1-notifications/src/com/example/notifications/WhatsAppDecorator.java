package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private final String handle;

    public WhatsAppDecorator(Notifier wrapped, String handle) {
        super(wrapped);
        this.handle = handle;
    }

    @Override
    public void notify(String text) {
        System.out.println("[WHATSAPP -> " + handle + "]: " + text);
        wrapped.notify(text);
    }
}


