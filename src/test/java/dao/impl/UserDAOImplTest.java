package dao.impl;

import entity.User;
import org.junit.Test;

import java.util.List;

/**
 * Created by dmity on 14.10.15.
 */
public class UserDAOImplTest extends BeforeTestShop {
    UserDAOImpl userDAO = new UserDAOImpl();

    @Test
    public void testCreate() throws Exception {

//      given
        User testUser = new User();
        testUser.setId(4);
        testUser.setFirstName("taras");
        testUser.setLastName("bulba");
        testUser.setAddress("Ukraine");
        testUser.setPhone("4567");
        testUser.setEmail("taras@bulba.us");
        testUser.setPassword("shablya");
        testUser.setRole("seller");

//      when
        userDAO.create(testUser);
        User user = userDAO.findById(4);

//      then
        assertEquals("taras", user.getFirstName());
        assertEquals("bulba", user.getLastName());
        assertEquals("Ukraine", user.getAddress());
        assertEquals("4567", user.getPhone());
        assertEquals("taras@bulba.us", user.getEmail());
        assertEquals("shablya", user.getPassword());
        assertEquals("seller", user.getRole());
    }

    @Test
    public void testUpdate() throws Exception {
//      given
        User user = userDAO.findById(1);
        user.setPassword("texas");

//      when
        userDAO.update(user);
        user = userDAO.findById(1);

//      then
        assertEquals("chuck", user.getFirstName());
        assertEquals("norris", user.getLastName());
        assertEquals("USA", user.getAddress());
        assertEquals("1234", user.getPhone());
        assertEquals("chuck@norris.us", user.getEmail());
        assertEquals("texas", user.getPassword());
    }

    @Test
    public void testDelete() throws Exception {
//      when
        userDAO.delete(3);
        User user = userDAO.findById(3);

//      then
        assertNull(user);
    }

    @Test
    public void testFindById() throws Exception {
//      when
        User user = userDAO.findById(1);

//      then
        assertEquals("chuck", user.getFirstName());
    }

    @Test
    public void testFindByEmail() throws Exception {
//      when
        User user = userDAO.findByEmail("chuck@norris.us");

//      then
        assertEquals(1, user.getId());
        assertEquals("chuck", user.getFirstName());
    }

    @Test
    public void testFindByRole() throws Exception {
//      when
        List<User> users = userDAO.findByRole("admin");

//      then
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
        assertEquals("chuck", users.get(0).getFirstName());
    }

    @Test
    public void testFindAll() throws Exception {
//      when
        List<User> users = userDAO.findAll();

//      then
        assertEquals(3, users.size());
        assertEquals(1, users.get(0).getId());
        assertEquals("chuck", users.get(0).getFirstName());
        assertEquals(2, users.get(1).getId());
        assertEquals("bruce", users.get(1).getFirstName());
        assertEquals(3, users.get(2).getId());
    }
}