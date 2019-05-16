package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;
    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Circle());
        shapeCollector.addFigure(new Triangle());
        shapeCollector.addFigure(new Square());

        Assert.assertEquals(3, shapeCollector.getFiguresQuantity());
    }

    @Test
    public void testRemoveFigureNotExisting() {
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle();

        boolean result = shapeCollector.removeFigure(circle);
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle();

        shapeCollector.addFigure(circle);
        boolean result = shapeCollector.removeFigure(circle);

        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getFiguresQuantity());
    }

    @Test
    public void getFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle();

        shapeCollector.addFigure(circle);

        Shape checkCircle;
        checkCircle = shapeCollector.getFigure(0);

        Assert.assertEquals(circle, checkCircle);
    }

    @Test
    public void getFigureNegativeIndex() {
        ShapeCollector shapeCollector = new ShapeCollector();

        Shape shapeToCheck;
        shapeToCheck= shapeCollector.getFigure(-3);

        Assert.assertNull(shapeToCheck);
    }
    @Test
    public void getFigureBeyondSize() {
        ShapeCollector shapeCollector = new ShapeCollector();

        Shape shapeToCheck;
        shapeToCheck= shapeCollector.getFigure(shapeCollector.getFiguresQuantity() + 1);

        Assert.assertNull(shapeToCheck);
    }
}
