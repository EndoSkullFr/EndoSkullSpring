package fr.endoskull.EndoSkullSpring.utils;

import fr.endoskull.EndoSkullSpring.data.MySQL;

import java.sql.SQLException;

public class TokenUtils {

    public static boolean tokenExist(String token) {
        return (boolean) MySQL.getInstance().query("SELECT `#` FROM properties WHERE `key`='" + "api/token" + "' AND `value`='" + token + "'", rs -> {
            try {
                return rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        });
    }
}
