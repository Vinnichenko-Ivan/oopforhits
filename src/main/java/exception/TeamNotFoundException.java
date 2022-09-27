package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ivan Vinnichenko
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Team not found")
public class TeamNotFoundException extends RuntimeException {
}
