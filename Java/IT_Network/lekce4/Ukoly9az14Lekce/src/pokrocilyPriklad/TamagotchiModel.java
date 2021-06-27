package pokrocilyPriklad;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TamagotchiModel {

    private boolean petAlive;
    private int feed;
    private LocalDateTime lastFeed;
    private int sleep;
    private LocalDateTime lastSlept;
    private int wash;
    private LocalDateTime lastWashed;
    private int walk;
    private LocalDateTime lastWalked;

    public TamagotchiModel() {
        setPetAlive(Boolean.getBoolean(PropertyToolkit.getInstance().get("alive")));
        setFeed(Integer.parseInt(PropertyToolkit.getInstance().get("feed")));
        setLastFeed(LocalDateTime.ofInstant(
                Instant.ofEpochMilli(Long.parseLong(PropertyToolkit.getInstance().get("lastFeeded"))), ZoneOffset.UTC));
        setSleep(Integer.parseInt(PropertyToolkit.getInstance().get("sleep")));
        setLastSlept(LocalDateTime.ofInstant(
                Instant.ofEpochMilli(Long.parseLong(PropertyToolkit.getInstance().get("lastSlept"))), ZoneOffset.UTC));
        setWash(Integer.parseInt(PropertyToolkit.getInstance().get("wash")));
        setLastWashed(LocalDateTime.ofInstant(
                Instant.ofEpochMilli(Long.parseLong(PropertyToolkit.getInstance().get("lastWashed"))), ZoneOffset.UTC));
        setWalk(Integer.parseInt(PropertyToolkit.getInstance().get("walk")));
        setLastWalked(LocalDateTime.ofInstant(
                Instant.ofEpochMilli(Long.parseLong(PropertyToolkit.getInstance().get("lastWalked"))), ZoneOffset.UTC));
    }

    public boolean isPetAlive() {
        return petAlive;
    }

    public void setPetAlive(boolean petAlive) {
        this.petAlive = petAlive;
    }

    public int getFeed() {
        return feed;
    }

    public void setFeed(int feed) {
        this.feed = feed;
    }

    public LocalDateTime getLastFeed() {
        return lastFeed;
    }

    public void setLastFeed(LocalDateTime lastFeed) {
        this.lastFeed = lastFeed;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public LocalDateTime getLastSlept() {
        return lastSlept;
    }

    public void setLastSlept(LocalDateTime lastSlept) {
        this.lastSlept = lastSlept;
    }

    public int getWash() {
        return wash;
    }

    public void setWash(int wash) {
        this.wash = wash;
    }

    public LocalDateTime getLastWashed() {
        return lastWashed;
    }

    public void setLastWashed(LocalDateTime lastWashed) {
        this.lastWashed = lastWashed;
    }

    public int getWalk() {
        return walk;
    }

    public void setWalk(int walk) {
        this.walk = walk;
    }

    public LocalDateTime getLastWalked() {
        return lastWalked;
    }

    public void setLastWalked(LocalDateTime lastWalked) {
        this.lastWalked = lastWalked;
    }

}
