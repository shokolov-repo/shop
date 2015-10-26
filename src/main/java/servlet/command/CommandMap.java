package servlet.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmity on 21.10.15.
 */
public class CommandMap {
    private static Map<String, Command> commandMap = new HashMap<>();

    static {
        commandMap.put("indexPage", new IndexPage());
        commandMap.put("login", new Login());
        commandMap.put("logout", new Logout());
        commandMap.put("registration", new Registration());
        commandMap.put("buy", new Buy());
        commandMap.put("updateAccount", new UpdateAccount());
        commandMap.put("findAll", new FindAllOrders());
        commandMap.put("showSellerPage", new SellerPage());
        commandMap.put("customerPage", new CustomerPage());
        commandMap.put("sellerPage", new SellerPage());
        commandMap.put("adminPage", new AdminPage());
        commandMap.put("addProductToBasket", new AddProductToBasket());

        commandMap.put("replaceRole", new ReplaceRole());
        commandMap.put("addUser", new AdminPage());
        commandMap.put("deleteUser", new DeleteUser());
        commandMap.put("updateUserComment", new UpdateUserComments());

    }

    public static Command getCommand(String name) {
        return commandMap.get(name);
    }
}
