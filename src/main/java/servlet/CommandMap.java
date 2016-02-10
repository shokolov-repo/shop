package servlet;

import servlet.command.*;

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
        commandMap.put("editProfile", new EditProfile());
        commandMap.put("customerPage", new CustomerPage());
        commandMap.put("sellerPage", new SellerPage());
        commandMap.put("adminPage", new AdminPage());
        commandMap.put("addProductToCart", new AddProductToCart());
        commandMap.put("cart", new Cart());
        commandMap.put("delFromCart", new DelFromCart());
        commandMap.put("orderPage", new OrderPage());
        commandMap.put("deleteUser", new DeleteUser());
        commandMap.put("createUser", new CreateUser());
        commandMap.put("editUser", new EditUser());
        commandMap.put("edit", new Edit());
        commandMap.put("editStatus", new EditStatus());
        commandMap.put("getCustomer", new GetCustomer());
        commandMap.put("costProductCart", new CostProductCart());
    }

    public static Command getCommand(String name) {
        return commandMap.get(name);
    }
}
