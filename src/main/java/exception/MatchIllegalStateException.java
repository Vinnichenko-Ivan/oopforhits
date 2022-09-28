package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ivan Vinnichenko
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Match not found")
public class MatchIllegalStateException extends RuntimeException {
}
