package academit.kgm.vectortest;

import org.junit.Assert;

import academit.kgm.vector.Vector;

public class VectorTest {

    private final double[] temp1 = {5, 5, 5, 5, 5};
    private final double[] temp2 = {1, 6, 3};
    Vector testVector1 = new Vector(temp1);
    Vector testVector2 = new Vector(temp2);

    @org.junit.Test
    public void setElement() throws Exception {
        testVector1.setElement(2, 8);
        double testElement = testVector1.getElement(2);
        Assert.assertEquals(8, testElement, 0.0001);
    }

    @org.junit.Test
    public void testGetSize() throws Exception {
        Assert.assertEquals(3, testVector2.getSize());
    }

    @org.junit.Test
    public void testSum() throws Exception {
        Vector sourceVector2 = new Vector(testVector2);
        Vector currentVector2 = new Vector(testVector2);
        double testRes[] = {6, 11, 8, 5, 5};
        Vector testVectorResult = new Vector(testRes);
        Assert.assertEquals(testVectorResult, testVector1.sum(currentVector2));
        Assert.assertEquals(sourceVector2,currentVector2);
    }

    @org.junit.Test
    public void testGetElement() throws Exception {
        Assert.assertEquals(5, testVector1.getElement(2), 0.0001);
    }

    @org.junit.Test
    public void testGetSub() throws Exception {
        Vector sourceVector1 = new Vector(testVector1);
        Vector currentVector1 = new Vector(testVector1);
        Vector sourceVector2 = new Vector(testVector2);
        Vector currentVector2 = new Vector(testVector2);
        double testRes[] = {4, -1, 2, 5, 5};
        Vector testVectorResult = new Vector(testRes);
        Assert.assertEquals(testVectorResult, Vector.getSub(currentVector1, currentVector2));
        Assert.assertEquals(sourceVector1,currentVector1);
        Assert.assertEquals(sourceVector2,currentVector2);
    }
}