class Solution {
    enum Position {
        NORTH, EAST, SOUTH, WEST
    }
    private int maxSquare = 0;

    private final int[] currentPoint = new int[2];
    private Position currentPosition = Position.NORTH;

    public int robotSim(int[] commands, int[][] obstacles) {
        for (int command : commands) {
            if (command < 0) {
                rotate(parseCommand(command));
            } else {
                move(command, obstacles);
            }
        }

        return maxSquare;
    }

    private void move(int command, int[][] obstacles) {
        final int[] newPoint = new int[2];
        switch (currentPosition) {
            case NORTH -> {
                    newPoint[0] = currentPoint[0];
                    newPoint[1] = currentPoint[1] + command;
            }
            case EAST  -> {
                newPoint[0] = currentPoint[0] + command;
                newPoint[1] = currentPoint[1];
            }
            case SOUTH -> {
                newPoint[0] = currentPoint[0];
                newPoint[1] = currentPoint[1] - command;
            }
            case WEST  -> {
                newPoint[0] = currentPoint[0] - command;
                newPoint[1] = currentPoint[1];
            }
        }

        int[] r = handleObstacles(currentPoint, newPoint, obstacles);
        currentPoint[0] = r[0];
        currentPoint[1] = r[1];
        maxSquare = Math.max(maxSquare, getDistance());
    }

    private int[] handleObstacles(int[] from, int[] to, int[][] obstacles) {
        int x = to[0];
        int y = to[1];

        for (int[] obstacle : obstacles) {
            boolean isObstacleOnPath = false;

            switch (currentPosition) {
                case NORTH -> {
                    if (from[0] == obstacle[0] && obstacle[1] > from[1] && obstacle[1] <= to[1]) {
                        y = Math.min(y, obstacle[1] - 1);
                        isObstacleOnPath = true;
                    }
                }
                case EAST -> {
                    if (from[1] == obstacle[1] && obstacle[0] > from[0] && obstacle[0] <= to[0]) {
                        x = Math.min(x, obstacle[0] - 1);
                        isObstacleOnPath = true;
                    }
                }
                case SOUTH -> {
                    if (from[0] == obstacle[0] && obstacle[1] < from[1] && obstacle[1] >= to[1]) {
                        y = Math.max(y, obstacle[1] + 1);
                        isObstacleOnPath = true;
                    }
                }
                case WEST -> {
                    if (from[1] == obstacle[1] && obstacle[0] < from[0] && obstacle[0] >= to[0]) {
                        x = Math.max(x, obstacle[0] + 1);
                        isObstacleOnPath = true;
                    }
                }
            }

            if (isObstacleOnPath) {
                return new int[]{x, y};
            }
        }

        return to;
    }

    private void rotate(int command) {
        currentPosition = Position.values()[(currentPosition.ordinal() + command + 4) % 4];
    }

    private int parseCommand(int command) {
        return command == -2 ? -1 : 1;
    }

    private int getDistance() {
        return (int) Math.pow(currentPoint[0], 2) + (int) Math.pow(currentPoint[1], 2);
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] commands = new int[]{7,-2,-2,7,5};
        final int[][] obstacles = new int[][]{{-3,2},{-2,1},{0,1},{-2,4},{-1,0},{-2,-3},{0,-3},{4,4},{-3,3},{2,2}};
        final int result = solution.robotSim(commands, obstacles);
        System.out.println(result);
    }
}

// TODO learn the LC solution:

//class Solution {
//
//    private static final int HASH_MULTIPLIER = 60013; // Slightly larger than 2 * max coordinate value
//
//    public int robotSim(int[] commands, int[][] obstacles) {
//        // Store obstacles in an HashSet for efficient lookup
//        Set<Integer> obstacleSet = new HashSet<>();
//        for (int[] obstacle : obstacles) {
//            obstacleSet.add(hashCoordinates(obstacle[0], obstacle[1]));
//        }
//
//        // Define direction vectors: North, East, South, West
//        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
//
//        int[] currentPosition = { 0, 0 };
//        int maxDistanceSquared = 0;
//        int currentDirection = 0; // 0: North, 1: East, 2: South, 3: West
//
//        for (int command : commands) {
//            if (command == -1) {
//                // Turn right
//                currentDirection = (currentDirection + 1) % 4;
//                continue;
//            }
//            if (command == -2) {
//                // Turn left
//                currentDirection = (currentDirection + 3) % 4;
//                continue;
//            }
//
//            // Move forward
//            int[] direction = directions[currentDirection];
//            for (int step = 0; step < command; step++) {
//                int nextX = currentPosition[0] + direction[0];
//                int nextY = currentPosition[1] + direction[1];
//                if (obstacleSet.contains(hashCoordinates(nextX, nextY))) {
//                    break;
//                }
//                currentPosition[0] = nextX;
//                currentPosition[1] = nextY;
//            }
//
//            maxDistanceSquared = Math.max(
//                    maxDistanceSquared,
//                    currentPosition[0] * currentPosition[0] +
//                            currentPosition[1] * currentPosition[1]
//            );
//        }
//
//        return maxDistanceSquared;
//    }
//
//    // Hash function to convert (x, y) coordinates to a unique integer value
//    private int hashCoordinates(int x, int y) {
//        return x + HASH_MULTIPLIER * y;
//    }
//}