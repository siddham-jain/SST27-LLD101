package com.example.notifications;

/**
 * Starter demo that uses only the existing Email notifier.
 * TODOs guide you to add decorators and compose them.
 */
public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline behavior (already works)
        base.notify("Baseline email only.");

        // Email + SMS
        Notifier emailSms = new SmsDecorator(base, "+91-99999-11111");
        emailSms.notify("Build green ✅");

        // Email + WhatsApp
        Notifier emailWa = new WhatsAppDecorator(base, "user_wa");
        emailWa.notify("Release tagged v1.2.3");

        // Email + Slack
        Notifier emailSlack = new SlackDecorator(base, "deployments");
        emailSlack.notify("Deployment completed 🚀");

        // Email + WhatsApp + Slack
        Notifier emailWaSlack = new SlackDecorator(new WhatsAppDecorator(base, "user_wa"), "alerts");
        emailWaSlack.notify("High latency on API");
    }
}
