package com.company;

import java.awt.*;

import static com.company.TetrisSwing.*;

/**
 * UI class
 */
public class UI {
    private UI() {
        throw new IllegalStateException();
    }

    /**
     * Method which draws field
     * @param g object of class Graphics
     */
    static void paintField(Graphics g) {
        for (int i = 4; i < 24; i++) {
            for (int j = 1; j < 11; j++) {
                if (TetrisSwing.finishPaint) {
                    switch (TetrisSwing.field[i][j]) {
                        case 1 -> g.setColor(Color.RED.darker());
                        case 2 -> g.setColor(Color.ORANGE.darker());
                        case 3 -> g.setColor(Color.YELLOW.darker());
                        case 4 -> g.setColor(Color.GREEN.darker());
                        case 5 -> g.setColor(Color.CYAN.darker());
                        case 6 -> g.setColor(Color.BLUE.darker());
                        case 7 -> g.setColor(Color.MAGENTA.darker());
                        default -> g.setColor(Color.BLACK);
                    }
                } else {
                    switch (TetrisSwing.field[i][j]) {
                        case 1 -> g.setColor(Color.RED);
                        case 2 -> g.setColor(Color.ORANGE);
                        case 3 -> g.setColor(Color.YELLOW);
                        case 4 -> g.setColor(Color.GREEN);
                        case 5 -> g.setColor(Color.CYAN);
                        case 6 -> g.setColor(Color.BLUE);
                        case 7 -> g.setColor(Color.MAGENTA);
                        default -> g.setColor(Color.BLACK);
                    }
                }
                g.fillRect((j+1)*30,(i-3)*30,30,30);
                g.setColor(Color.GRAY);
                g.drawRect((j+1)*30,(i-3)*30,30,30);
            }
        }
    }

    /**
     * Method which draws fallen figure
     * @param g object of class Graphics
     */
    static void paintFigure(Graphics g) {
        switch (TetrisSwing.figure) {
            case 2 -> g.setColor(Color.ORANGE);
            case 3 -> g.setColor(Color.YELLOW);
            case 4 -> g.setColor(Color.GREEN);
            case 5 -> g.setColor(Color.CYAN);
            case 6 -> g.setColor(Color.BLUE);
            case 7 -> g.setColor(Color.MAGENTA);
            default -> g.setColor(Color.RED);
        }
        if (aY >= 5) {
            g.fillRect((aX + 1) * 30, (aY - 4) * 30, 30, 30);
        }
        if (bY >= 5) {
            g.fillRect((bX + 1) * 30, (bY - 4) * 30, 30, 30);
        }
        if (cY >= 5) {
            g.fillRect((cX + 1) * 30, (cY - 4) * 30, 30, 30);
        }
        if (dY >= 5) {
            g.fillRect((dX + 1) * 30, (dY - 4) * 30, 30, 30);
        }
        g.setColor(Color.GRAY);
        if (aY >= 5) {
            g.drawRect((aX + 1) * 30, (aY - 4) * 30, 30, 30);
        }
        if (bY >= 5) {
            g.drawRect((bX + 1) * 30, (bY - 4) * 30, 30, 30);
        }
        if (cY >= 5) {
            g.drawRect((cX + 1) * 30, (cY - 4) * 30, 30, 30);
        }
        if (dY >= 5) {
            g.drawRect((dX + 1) * 30, (dY - 4) * 30, 30, 30);
        }
    }

    /**
     * Method which draws next figure
     * @param g object of class Graphics
     */
    static void paintNextFigure(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(390,60,150,180);
        switch (nextFigure) {
            case 2 -> g.setColor(Color.ORANGE);
            case 3 -> g.setColor(Color.YELLOW);
            case 4 -> g.setColor(Color.GREEN);
            case 5 -> g.setColor(Color.CYAN);
            case 6 -> g.setColor(Color.BLUE);
            case 7 -> g.setColor(Color.MAGENTA);
            default -> g.setColor(Color.RED);
        }
        if (!gameOver) {
            g.fillRect(TetrisSwing.NEXTAX, TetrisSwing.NEXTAY, 30, 30);
            g.fillRect(nextBX, nextBY, 30, 30);
            g.fillRect(nextCX, TetrisSwing.nextCY, 30, 30);
            g.fillRect(nextDX, nextDY, 30, 30);
            g.setColor(Color.GRAY);
            g.drawRect(NEXTAX, NEXTAY, 30, 30);
            g.drawRect(nextBX, nextBY, 30, 30);
            g.drawRect(nextCX, nextCY, 30, 30);
            g.drawRect(nextDX, nextDY, 30, 30);
        }
    }
}