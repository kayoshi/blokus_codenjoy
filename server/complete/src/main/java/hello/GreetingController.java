package hello;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import static hello.GameMain.currentPlayer;

@RestController
public class GreetingController {

    int color = 0;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(++color, GeneratedMatrix.getGameArea());
    }

    @RequestMapping("/state")
    public State getState() {
        return new State(GameMain.mState, GeneratedMatrix.getGameArea(), currentPlayer);
    }

    @RequestMapping(value = "/move", method = RequestMethod.POST)
    public Boolean postMove(@RequestBody Move move) {
        System.out.println("Move: "+move.getType());

        return true;
    }

}
