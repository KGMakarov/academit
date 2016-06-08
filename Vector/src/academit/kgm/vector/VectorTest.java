package academit.kgm.vector;

import static org.junit.Assert.*;

public class VectorTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void testGetSize() throws Exception {
        double temp[] = {5, 5, 5, 5, 5};
        Vector testVector = new Vector(temp);
        assertEquals(5, testVector.getSize());
    }

    @org.junit.Test
    public void testSum() throws Exception {
        double temp1[] = {1, 6, 3};
        double temp2[] = {1, 2};
        Vector testVector1 = new Vector(temp1);
        Vector testVector2 = new Vector(temp2);
        double testRes[] = {2, 8, 3};
        Vector testVectorResult = new Vector(testRes);
        assertEquals(testVectorResult, testVector1.sum(testVector2));
    }

    @org.junit.Test
    public void testGetElement() throws Exception {
        double temp1[] = {1, 6, 3};
        Vector testVector1 = new Vector(temp1);
        assertEquals(6, testVector1.getElement(1), 0.0001);
    }

    @org.junit.Test
    public void testGetSub() throws Exception {
        double temp1[] = {1, 6, 3};
        double temp2[] = {1, 2};
        Vector testVector1 = new Vector(temp1);
        Vector testVector2 = new Vector(temp2);
        double testRes[] = {0, 4, 3};
        Vector testVectorResult = new Vector(testRes);
        assertEquals(testVectorResult, Vector.getSub(testVector1,testVector2));
    }
}