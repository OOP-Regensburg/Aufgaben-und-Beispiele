import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.world.FieldColor;


public class CopyAndPaste extends BouncerApp {

    private static final int COLUMNS = 15;
    private static final int ROWS = 15;
    private int steps = 0;

    @Override
    public void bounce() {
        loadMap("CopyAndPaste");
        mirrorImage();
    }


    private void mirrorImage() {
        for (int i = 0; i < ROWS; i++) {
            mirrorRow();
            moveToNextRow();
        }
    }

    private void mirrorRow() {
        steps = 0;
        checkField();
        for (int i = 0; i < COLUMNS / 2; i++) {
            bouncer.move();
            steps = steps + 1;
            checkField();
        }
    }

    private void checkField() {
        if (bouncer.isOnFieldWithColor(FieldColor.GREEN)) {
            copyField();
            returnToLastCheckedField();
        }
    }

    private void copyField() {
        moveToWall();
        turnAround();
        for (int i = 0; i < steps; i++) {
            bouncer.move();
        }
        bouncer.paintField(FieldColor.GREEN);
    }

    private void returnToLastCheckedField() {
        moveToWall();
        turnAround();
        for (int i = 0; i < steps; i++) {
            bouncer.move();
        }
    }

    private void moveToWall() {
        while (bouncer.canMoveForward()) {
            bouncer.move();
        }
    }

    private void moveToNextRow() {
        while (bouncer.isFacingWest() == false) {
            bouncer.turnLeft();
        }
        while (bouncer.canMoveForward()) {
            bouncer.move();
        }
        bouncer.turnLeft();
        bouncer.move();
        bouncer.turnLeft();
    }

    private void turnAround() {
        bouncer.turnLeft();
        bouncer.turnLeft();
    }

    private void turnRight() {
        turnAround();
        bouncer.turnLeft();
    }


}

