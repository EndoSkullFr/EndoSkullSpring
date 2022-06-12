package fr.endoskull.EndoSkullSpring.controllers;

import fr.endoskull.EndoSkullSpring.EndoSkullSpringApplication;
import fr.endoskull.EndoSkullSpring.utils.Profile;
import fr.endoskull.EndoSkullSpring.utils.ProfileManager;
import fr.endoskull.EndoSkullSpring.utils.TokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProfileController {

    @GetMapping("/profile")
    public Profile profile(@RequestParam(value = "token", defaultValue = "none") String token, @RequestParam(value = "uuid", defaultValue = "none") String uuid, @RequestParam(value = "name", defaultValue = "none") String name) {
        Profile stats = null;
        boolean invalidToken = false;
        if (token.equalsIgnoreCase("none")) {
            invalidToken = true;
        } else if (!TokenUtils.tokenExist(token)) {
            invalidToken = true;
        }
        if (invalidToken) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Invalid token");
        }
        if (!EndoSkullSpringApplication.getTokens().containsKey(token)) EndoSkullSpringApplication.getTokens().put(token, 0);
        if (EndoSkullSpringApplication.getTokens().get(token) >= EndoSkullSpringApplication.getMaxRequest()) {
            throw new ResponseStatusException(
                    HttpStatus.BANDWIDTH_LIMIT_EXCEEDED, "API limit reached, please wait");
        }
        EndoSkullSpringApplication.getTokens().put(token, EndoSkullSpringApplication.getTokens().get(token) + 1);
        if (!uuid.equalsIgnoreCase("none")) {
            try {
                stats = new ProfileManager(UUID.fromString(uuid)).getStats();
                return stats;
            } catch (IllegalArgumentException ex) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, uuid + " is not a uuid", ex);
            }
        } else if (!name.equalsIgnoreCase("none")) {
            UUID uniqueId = ProfileManager.getUuidFromName(name);
            if (uniqueId == null) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, name + " is not in our database");
            }
            stats = new ProfileManager(uniqueId).getStats();
            return stats;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "invalid name or uuid");
    }
}
