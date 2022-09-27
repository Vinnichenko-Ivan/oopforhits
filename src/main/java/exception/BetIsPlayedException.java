package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ivan Vinnichenko
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Bet is played")
public class BetIsPlayedException extends RuntimeException {

}
