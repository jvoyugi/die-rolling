
/**
 * A die ADT
 * 
 * @author Javan Oyugi
 */

public class Die {

    /** A die face ADT */
    static class Face {
        /** doubleing point representing number on a face */
        private float faceShown;
        /** Integer for a face number */
        private int faceNumber;

        public Face() {
            this.faceNumber = 1;
        }

        /** Sets double point representing number on a face */
        public void setFaceShown(float num) {
            this.faceShown = num;
        }

        /** Returns double point representing number on a face */
        public float getFaceShown() {
            return this.faceShown;
        }

        /** Sets an integer for a face number */
        public void setFaceNum(int num) {
            int counter;
            for (counter = 0; counter <= num; counter++) {
                if (this.getFaceShown() >= (float) (counter / num)
                        && this.getFaceShown() < (float) (counter + 1) / num) {
                    break;
                }
                this.faceNumber += 1;
            }
        }

        /** Gets an integer for a face number */
        public int getFaceNumber() {
            return this.faceNumber;
        }

    }

    private Face face = new Face();
    /** Number of faces on the die */
    private int numberOfFaces;

    /** Sets a seed for the random number */
    public Die() {
    }

    /**
     * Mutator for {@link #numberOfFaces number of faces}
     * 
     * @param num {@code int} representing number of faces
     */
    public void setNumberOfFaces(int num) {
        if (num > 0) {
            this.numberOfFaces = num;
        }
    }

    /**
     * Accessor for {@link #numberOfFaces number of faces}
     * 
     * @return @param num {@code int} representing number of faces
     */
    public int getNumberOfFaces() {
        return this.numberOfFaces;
    }

    /**
     * Sets a face to the die
     * 
     * @param face {@code Face} object representing a face of the die
     */
    public void setFace(Face face) {
        this.face = face;
    }

    /**
     * Gets a face object of the die
     * 
     * @return face {@code Face} object representing a face of the die
     */
    public Face getFace() {
        return this.face;
    }

    /**
     * "Rolls" a die
     * 
     * @return {@code float} representing a number in the probability space
     */
    public float roll() {
        return (float) Math.random();
    }
}
