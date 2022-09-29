package de.paulcornelissen.pong;

public class CollisionListener {

    private final BouncePad bouncePadLeft;
    private final BouncePad bouncePadRight;
    private final Ball ball;
    private final GameManager game;
    private final GameManager gameManager;
    private Pong pong;

    public CollisionListener(Pong pong) {
        bouncePadLeft = pong.getBouncePadLeft();
        bouncePadRight = pong.getBouncePadRight();
        ball = pong.getBall();
        game = pong.getGameManager();
        gameManager = pong.getGameManager();
        this.pong = pong;
    }

    public int checkCollision() {
        if (ball.getX() >= 580 && (ball.getY() - bouncePadRight.getY()) < 150 && (ball.getY() - bouncePadRight.getY()) > 0 && !ball.rightCollision) {
            ball.rightCollision = true;
            ball.changeDirection();
            return 1;
        }
        if (ball.getX() <= 120 && (ball.getY() - bouncePadLeft.getY()) < 150 && (ball.getY() - bouncePadLeft.getY()) > 0 && ball.rightCollision) {
            ball.rightCollision = false;
            ball.changeDirection();
            return 2;
        }
        if (ball.getX() > 675) {
            game.goalL();
            pong.getScoreManager().refresh(gameManager.scoreLeft, gameManager.scoreRight);

            game.resetMatch();
            return 3;
        }
        if (ball.getX() < 0) {
            game.goalR();
            pong.getScoreManager().refresh(gameManager.scoreLeft, gameManager.scoreRight);

            game.resetMatch();
            return 4;
        }
        if (ball.getY() > 475 || ball.getY() < 0) {
            ball.bounce();
            return 5;
        }
        return 0;
    }


}
