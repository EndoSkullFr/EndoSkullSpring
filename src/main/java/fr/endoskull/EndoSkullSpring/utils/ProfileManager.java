package fr.endoskull.EndoSkullSpring.utils;

import fr.endoskull.EndoSkullSpring.data.MySQL;

import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class ProfileManager {
    private Profile stats = new Profile("", "none", 0, 0, 0, 0, 0, 0, new Profile.PvpKitStats(0, 0), new Profile.BedwarsStats(0, 0, 0, 0, 0, 0, 0, 0));

    public ProfileManager(UUID uuid) {
        stats.setUuid(uuid.toString());
        MySQL.getInstance().query("SELECT * FROM accounts WHERE uuid='" + uuid + "'", rs -> {
            try {
                if (rs.next()) {
                    stats.setName(rs.getString("name"));
                    stats.setLevel(rs.getInt("level"));
                    stats.setXp(rs.getDouble("xp"));
                    stats.setMoney(rs.getDouble("solde"));
                    stats.setFirstJoin(rs.getLong("first_join"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        MySQL.getInstance().query("SELECT * FROM properties WHERE uuid='" + uuid + "' AND `key`='lastLogout'", rs -> {
            try {
                if (rs.next()) {
                    stats.setLastLogout(Long.parseLong(rs.getString("value")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        MySQL.getInstance().query("SELECT * FROM properties WHERE uuid='" + uuid + "' AND `key`='lastLogin'", rs -> {
            try {
                if (rs.next()) {
                    stats.setLastLogin(Long.parseLong(rs.getString("value")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        MySQL.getInstance().query("SELECT * FROM stats WHERE uuid='" + uuid + "' AND `key`='pvpkit/kill'", rs -> {
            try {
                if (rs.next()) {
                    stats.getPvpkit().setKill(rs.getInt("value"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        MySQL.getInstance().query("SELECT * FROM stats WHERE uuid='" + uuid + "' AND `key`='pvpkit/death'", rs -> {
            try {
                if (rs.next()) {
                    stats.getPvpkit().setDeath(rs.getInt("value"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public Profile getStats() {
        return stats;
    }

    public static UUID getUuidFromName(String name) {
        if (name.equalsIgnoreCase("none")) return null;
        AtomicReference<UUID> uuid = new AtomicReference<>(null);
        MySQL.getInstance().query("SELECT * FROM accounts WHERE name='" + name + "'", rs -> {
            try {
                if(rs.next()){
                    uuid.set(UUID.fromString(rs.getString("uuid")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        return uuid.get();
    }
}
