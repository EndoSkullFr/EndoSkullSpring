package fr.endoskull.EndoSkullSpring.utils;

public class Profile {
    private String uuid;
    private String name;
    private int level;
    private double xp;
    private double money;
    private long firstJoin;
    private long lastLogin;
    private long lastLogout;
    private PvpKitStats pvpkit;
    private BedwarsStats bedwars;


    public Profile(String uuid, String name, int level, double xp, double money, long firstJoin, long lastLogin, long lastLogout, PvpKitStats pvpkit, BedwarsStats bedwars) {
        this.uuid = uuid;
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.money = money;
        this.firstJoin = firstJoin;
        this.lastLogin = lastLogin;
        this.lastLogout = lastLogout;
        this.pvpkit = pvpkit;
        this.bedwars = bedwars;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getXp() {
        return xp;
    }

    public double getMoney() {
        return money;
    }

    public long getFirstJoin() {
        return firstJoin;
    }

    public long getLastLogin() {
        return lastLogin;
    }

    public long getLastLogout() {
        return lastLogout;
    }

    public PvpKitStats getPvpkit() {
        return pvpkit;
    }

    public BedwarsStats getBedwars() {
        return bedwars;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setFirstJoin(long firstJoin) {
        this.firstJoin = firstJoin;
    }

    public void setLastLogin(long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setLastLogout(long lastLogout) {
        this.lastLogout = lastLogout;
    }

    public static class PvpKitStats {
        private int kill;
        private int death;

        public PvpKitStats(int kill, int death) {
            this.kill = kill;
            this.death = death;
        }

        public int getKill() {
            return kill;
        }

        public int getDeath() {
            return death;
        }

        public void setKill(int kill) {
            this.kill = kill;
        }

        public void setDeath(int death) {
            this.death = death;
        }
    }

    public static class BedwarsStats {
        private int kill;
        private int death;
        private int win;
        private int lose;
        private int finalKill;
        private int bedBroken;
        private int goulagWin;
        private int goulagLose;

        public BedwarsStats(int kill, int death, int win, int lose, int finalKill, int bedBroken, int goulagWin, int goulagLose) {
            this.kill = kill;
            this.death = death;
            this.win = win;
            this.lose = lose;
            this.finalKill = finalKill;
            this.bedBroken = bedBroken;
            this.goulagWin = goulagWin;
            this.goulagLose = goulagLose;
        }

        public int getKill() {
            return kill;
        }

        public int getDeath() {
            return death;
        }

        public int getWin() {
            return win;
        }

        public int getLose() {
            return lose;
        }

        public int getFinalKill() {
            return finalKill;
        }

        public int getBedBroken() {
            return bedBroken;
        }

        public int getGoulagWin() {
            return goulagWin;
        }

        public int getGoulagLose() {
            return goulagLose;
        }

        public void setKill(int kill) {
            this.kill = kill;
        }

        public void setDeath(int death) {
            this.death = death;
        }

        public void setWin(int win) {
            this.win = win;
        }

        public void setLose(int lose) {
            this.lose = lose;
        }

        public void setFinalKill(int finalKill) {
            this.finalKill = finalKill;
        }

        public void setBedBroken(int bedBroken) {
            this.bedBroken = bedBroken;
        }

        public void setGoulagWin(int goulagWin) {
            this.goulagWin = goulagWin;
        }

        public void setGoulagLose(int goulagLose) {
            this.goulagLose = goulagLose;
        }
    }
}
