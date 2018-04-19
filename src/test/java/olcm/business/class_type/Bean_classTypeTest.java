/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.class_type;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class Bean_classTypeTest {

    private static Context ctx;
    private static EJBContainer ejbContainer;

    public Bean_classTypeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        ejbContainer = EJBContainer.createEJBContainer();
        ctx = ejbContainer.getContext();
    }

    @AfterClass
    public static void tearDownClass() {
        ejbContainer.close();

    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class Bean_classType.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        ClassType object = new ClassType();
        object.setName("name");

        Bean_classType instance = (Bean_classType) ctx.lookup("java:global/classes/Bean_classType");
        assertNotNull(instance);
        Boolean expResult = null;
        Boolean result = instance.save(object);
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
