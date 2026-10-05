public class Main {

    public static void main(String[] args) {

        if (args.length == 1 && args[0].equals("--demo")) {
            runDemo();
        } else {
            System.out.println("Usage: java -cp out Main --demo");
        }
    }

    private static void runDemo() {

        int passed = 0;
        int total = 7;

        Shape circleVector = new Circle(
                1,
                2,
                new VectorRenderer()
        );

        String t1Actual = circleVector.execute();
        String t1Expected = "VECTOR circle radius=2";

        boolean t1 = t1Actual.equals(t1Expected);

        printResult(
                "T1",
                t1,
                "Circle + VectorRenderer",
                t1Actual,
                t1Expected
        );

        if (t1) {
            passed++;
        }


        Shape circleRaster = new Circle(
                1,
                2,
                new RasterRenderer()
        );

        String t2Actual = circleRaster.execute();
        String t2Expected = "RASTER circle radius=2";

        boolean t2 = t2Actual.equals(t2Expected);

        printResult(
                "T2",
                t2,
                "Circle + RasterRenderer",
                t2Actual,
                t2Expected
        );

        if (t2) {
            passed++;
        }


        Shape squareVector = new Square(
                2,
                3,
                new VectorRenderer()
        );

        String t3Actual = squareVector.execute();
        String t3Expected = "VECTOR square side=3";

        boolean t3 = t3Actual.equals(t3Expected);

        printResult(
                "T3",
                t3,
                "Square + VectorRenderer",
                t3Actual,
                t3Expected
        );

        if (t3) {
            passed++;
        }


        Shape squareRaster = new Square(
                2,
                3,
                new RasterRenderer()
        );

        String t4Actual = squareRaster.execute();
        String t4Expected = "RASTER square side=3";

        boolean t4 = t4Actual.equals(t4Expected);

        printResult(
                "T4",
                t4,
                "Square + RasterRenderer",
                t4Actual,
                t4Expected
        );

        if (t4) {
            passed++;
        }


        Shape circleSwitch = new Circle(
                3,
                2,
                new VectorRenderer()
        );

        Shape originalReference = circleSwitch;

        String before = circleSwitch.execute();

        int originalId = circleSwitch.getId();

        circleSwitch.setImplementation(new RasterRenderer());

        Shape afterReference = circleSwitch;

        String after = circleSwitch.execute();

        boolean sameObject = originalReference == afterReference;
        boolean sameId = originalId == circleSwitch.getId();

        boolean correctBefore =
                before.equals("VECTOR circle radius=2");

        boolean correctAfter =
                after.equals("RASTER circle radius=2");

        boolean t5 =
                sameObject &&
                        sameId &&
                        correctBefore &&
                        correctAfter;

        printT5(
                t5,
                sameObject,
                sameId,
                before,
                after
        );

        if (t5) {
            passed++;
        }




        System.out.println(
                "SUMMARY: " + passed + "/" + total + " PASS"
        );
    }


    private static void printResult(
            String id,
            boolean passed,
            String classes,
            String actual,
            String expected
    ) {

        String status = passed ? "PASS" : "FAIL";

        System.out.println(
                id + " " + status +
                        " | " + classes +
                        " | result=" + actual
        );

        if (!passed) {
            System.out.println(
                    "  expected=" + expected
            );
        }
    }


    private static void printT5(
            boolean passed,
            boolean sameObject,
            boolean sameId,
            String before,
            String after
    ) {

        String status = passed ? "PASS" : "FAIL";

        System.out.println(
                "T5 " + status +
                        " | sameObject=" + sameObject +
                        " | sameId=" + sameId +
                        " | before=" + before +
                        " | after=" + after
        );

        if (!passed) {
            System.out.println(
                    "  expected=sameObject=true, sameId=true, " +
                            "before=VECTOR circle radius=2, " +
                            "after=RASTER circle radius=2"
            );
        }
    }
}