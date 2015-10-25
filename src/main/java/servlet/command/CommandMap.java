package servlet.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmity on 21.10.15.
 */
public class CommandMap {
    private static Map<String, Command> commandMap = new HashMap<>();

    static  {
        commandMap.put("login", new Login());
        commandMap.put("logout", new Logout());
        commandMap.put("registration", new Registration());
        commandMap.put("buy", new Buy());
        commandMap.put("updateAccount",new UpdAcc());
        commandMap.put("findAll",new FindAllOrders());
        commandMap.put("showSellerPage",new SellerPageCommand());
    }

    public static Command getCommand(String name) {
        return commandMap.get(name);
    }
}
