package academit.kgm.vectortest;

import org.junit.Assert;

import academit.kgm.vector.Vector;

public class VectorTest {
    private Vector testVector1;
    private Vector testVector2;

    @org.junit.Before
    public void setUp() throws Exception {
        double[] temp1 = {5, 5, 5, 5, 5};
        double[] temp2 = {1, 6, 3};
        testVector1 = new Vector(temp1);
        testVector2 = new Vector(temp2);
    }

    @org.junit.Test
    public void testGetSize() throws Exception {
        Assert.assertEquals(3, testVector2.getSize());
    }

    @org.junit.Test
    public void testToString() throws Exception {
        String temp1 = "{5.0, 5.0, 5.0, 5.0, 5.0}";
        Assert.assertEquals(temp1, testVector1.toString());
    }

    @org.junit.Test
    public void testSum() throws Exception {
        Vector sourceVector2 = new Vector(testVector2);
        Vector currentVector2 = new Vector(testVector2);
        double[] testRes = {6, 11, 8, 5, 5};
        Vector testVectorResult = new Vector(testRes);
        Assert.assertEquals(testVectorResult, testVector1.sum(currentVector2));
        Assert.assertEquals(sourceVector2, currentVector2);
    }

    @org.junit.Test
    public void testSub() throws Exception {
        Vector sourceVector2 = new Vector(testVector2);
        Vector currentVector2 = new Vector(testVector2);
        double[] testRes = {4, -1, 2, 5, 5};
        Vector testVectorResult = new Vector(testRes);
        Assert.assertEquals(testVectorResult, testVector1.sub(currentVector2));
        Assert.assertEquals(sourceVector2, currentVector2);
    }

    @org.junit.Test
    public void testMultiply() throws Exception {
        double[] testRes = {-10, -10, -10, -10, -10};
        Vector testVectorResult = new Vector(testRes);
        Assert.assertEquals(testVectorResult, testVector1.multiply(-2));
    }

    @org.junit.Test
    public void testReverse() throws Exception {
        double[] testRes = {-5, -5, -5, -5, -5};
        Vector testVectorResult = new Vector(testRes);
        Assert.assertEquals(testVectorResult, testVector1.reverse());
    }

    @org.junit.Test
    public void testGetLength() throws Exception {
        double testRes = Math.sqrt(46);
        Assert.assertEquals(testRes, testVector2.getLength(), 0.0001);
    }

    @org.junit.Test
    public void testGetElement() throws Exception {
        Assert.assertEquals(5, testVector1.getElement(2), 0.0001);
    }

    @org.junit.Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetElementException() throws Exception {
        Assert.assertEquals(5, testVector1.getElement(99), 0.0001);
    }

    @org.junit.Test
    public void testSetElement() throws Exception {
        testVector1.setElement(2, 8);
        double testElement = testVector1.getElement(2);
        Assert.assertEquals(8, testElement, 0.0001);
    }

    @org.junit.Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetElementException() throws Exception {
        testVector1.setElement(99, 8);
    }

    @org.junit.Test
    public void testEquals() throws Exception {
        Assert.assertEquals(false, testVector1.equals(testVector2));
    }

    @org.junit.Test
    public void testGetSum() throws Exception {
        Vector sourceVector1 = new Vector(testVector1);
        Vector currentVector1 = new Vector(testVector1);
        Vector sourceVector2 = new Vector(testVector2);
        Vector currentVector2 = new Vector(testVector2);
        double[] testRes = {6, 11, 8, 5, 5};
        Vector testVectorResult = new Vector(testRes);
        Assert.assertEquals(testVectorResult, Vector.getSum(currentVector1, currentVector2));
        Assert.assertEquals(sourceVector1, currentVector1);
        Assert.assertEquals(sourceVector2, currentVector2);
    }

    @org.junit.Test
    public void testGetSub() throws Exception {
        Vector sourceVector1 = new Vector(testVector1);
        Vector currentVector1 = new Vector(testVector1);
        Vector sourceVector2 = new Vector(testVector2);
        Vector currentVector2 = new Vector(testVector2);
        double[] testRes = {4, -1, 2, 5, 5};
        Vector testVectorResult = new Vector(testRes);
        Assert.assertEquals(testVectorResult, Vector.getSub(currentVector1, currentVector2));
        Assert.assertEquals(sourceVector1, currentVector1);
        Assert.assertEquals(sourceVector2, currentVector2);
    }

    @org.junit.Test
    public void testGetMultiply() throws Exception {
        Vector sourceVector1 = new Vector(testVector1);
        Vector currentVector1 = new Vector(testVector1);
        double[] testRes = {10, 10, 10, 10, 10};
        Vector testVectorResult = new Vector(testRes);
        Assert.assertEquals(testVectorResult, Vector.getMultiply(currentVector1, 2));
        Assert.assertEquals(sourceVector1, currentVector1);
    }

    @org.junit.Test
    public void testGetVectorMultiply() throws Exception {
        Vector sourceVector1 = new Vector(testVector1);
        Vector currentVector1 = new Vector(testVector1);
        Vector sourceVector2 = new Vector(testVector2);
        Vector currentVector2 = new Vector(testVector2);
        double testRes = 50;
        Assert.assertEquals(testRes, Vector.getVectorMultiply(currentVector1, currentVector2), 0.0001);
        Assert.assertEquals(sourceVector1, currentVector1);
        Assert.assertEquals(sourceVector2, currentVector2);
    }
}