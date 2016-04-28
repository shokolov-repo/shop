package dao.impl.jdbc;

import dao.CommentDao;
import entity.Comment;
import org.junit.Test;

import java.util.List;

/**
 * Created by dmity on 16.10.15.
 */
public class CommentDaoImplTest extends BeforeTestShop {
    CommentDao commentDao = new CommentDaoImpl();

    @Test
    public void testCreate() throws Exception {
//      given
        Comment testComment = new Comment();
        testComment.setProductId(3);
        testComment.setUserId(3);
        testComment.setUserName("vasily");
        testComment.setContent("Some content test");

//      when
        commentDao.create(testComment);
        List<Comment> comments = commentDao.findByProductId(3);

//      then
        assertEquals(1, comments.size());
        assertEquals(3, comments.get(0).getProductId());
        assertEquals(3, comments.get(0).getUserId());
        assertEquals("vasily", comments.get(0).getUserName());
        assertEquals("Some content test", comments.get(0).getContent());
    }

    @Test
    public void testUpdate() throws Exception {
//      given
        Comment testComment = commentDao.findByProductId(2).get(0);
        testComment.setContent("update content");

//      when
        commentDao.update(testComment);
        List<Comment> comments = commentDao.findByProductId(2);

//      then
        assertEquals(1, comments.size());
        assertEquals("update content", comments.get(0).getContent());
    }

    @Test
    public void testDelete() throws Exception {
//      when
        commentDao.delete(2);
        List<Comment> comments = commentDao.findByUserId(2);

//      then
        assertEquals(0, comments.size());
    }

    @Test
    public void testFindByCustomerId() throws Exception {
//        when
        List<Comment> comments = commentDao.findByUserId(2);

//        then
        assertEquals(1, comments.size());
        assertEquals(3, comments.get(0).getId());
        assertEquals("bruce", comments.get(0).getUserName());
        assertEquals("contentBruce", comments.get(0).getContent());
    }

    @Test
    public void testFindByProductId() throws Exception {
//        when
        List<Comment> comments = commentDao.findByProductId(1);

//        then
        assertEquals(2, comments.size());
        assertEquals("chuck", comments.get(0).getUserName());
        assertEquals("content1Chuck", comments.get(0).getContent());
        assertEquals("bruce", comments.get(1).getUserName());
        assertEquals("contentBruce", comments.get(1).getContent());
    }
}