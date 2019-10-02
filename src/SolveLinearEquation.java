//solve linear equation challenge
//right now it can solve the following forms of a linear equation:
//      --> x + a = b
//      --> x - a = b
//      --> ax + b = c
//      --> ax - b = c
//      --> x/a + b = c
//      --> x/a - b = c


class SolveLinearEquation {

    String xIs(String equation) {

        //we split the equation by the equal sign
        String[] leftAndRightSides = equation.split("=");

        //right side of the equation
        String rightSide = leftAndRightSides[1];

        //left side of the equation
        String leftSide = leftAndRightSides[0];

        //this holds the value that the left side of the equation must be equal to
        int leftSideEquals = 0;

        // holds the operand in the left side that contains x
        String leftSideXMultiplier;

        //when the left side contains x
        if (leftSide.contains("x")) {

            //store the right side value
            leftSideEquals = Integer.parseInt(leftAndRightSides[1]);

            //when the left side contains a sum
            if (leftSide.contains("+")) {

                //the right side equals its current value minus the left side operand that does not contain x
                leftSideEquals -= Integer.parseInt(leftSide.split("\\+")[1]);

                //store the operand that contains x
                leftSideXMultiplier = leftSide.split("\\+")[0];

                //
                if (leftSideXMultiplier.equals("x")) {
                    return "x = " + leftSideEquals;
                } else if (leftSideXMultiplier.contains("/")) {
                    return "x = " + (leftSideEquals * Integer.parseInt(leftSideXMultiplier.split("/")[1]));
                } else {
                    return "x = " + ((leftSideEquals / (double) Integer.parseInt(leftSideXMultiplier.split("x")[0])));
                }
            }

            //same as before but when the left side contains a difference
            if (leftSide.contains("-")) {

                leftSideEquals += Integer.parseInt(leftSide.split("-")[1]);

                leftSideXMultiplier = leftSide.split("-")[0];

                if (leftSideXMultiplier.length() == 1) {
                    return "x = " + leftSideEquals;
                } else if (leftSideXMultiplier.contains("/")) {
                    return "x = " + (leftSideEquals * Integer.parseInt(leftSideXMultiplier.split("/")[1]));
                } else {
                    return "x = " + ((leftSideEquals / (double) Integer.parseInt(leftSideXMultiplier.split("x")[0])));
                }
            }
        }

        return "0";
    }

}
