package com.example.escrowapp.model;
public class AdminUser {
    private String name;
    private String subtitle;
    private boolean flagged;

    public AdminUser(String name, String subtitle, boolean flagged) {
        this.name = name;
        this.subtitle = subtitle;
        this.flagged = flagged;
    }

    public String getName() { return name; }
    public String getSubtitle() { return subtitle; }
    public boolean isFlagged() { return flagged; }

    public String getInitials() {
        String[] parts = name.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            if (!p.isEmpty()) sb.append(Character.toUpperCase(p.charAt(0)));
            if (sb.length() >= 2) break;
        }
        return sb.toString();
    }
}
