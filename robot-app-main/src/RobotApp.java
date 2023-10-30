import java.util.Scanner;
import Model.Layout;
import Model.Robot;
import Model.Position;

public class RobotApp {
    public static void main(String[] args) {
        new RobotApp();
    }

    private Layout layout;
    private Robot robot;
    private Scanner scanner;
    public RobotApp() {
        this.layout = new Layout(10, 10, '*');
        this.robot = new Robot('o', new Position(1, 1));
        this.scanner = new Scanner(System.in);
        String instruction = "";
        System.out.println("-------- Permainan Dimulai --------");
        do {
            draw();
            instruction = waitInstruction();
            if (instruction.length() >= 2) {
                char direction = instruction.charAt(0);
                int steps = 0;

                try {
                    steps = Integer.parseInt(instruction.substring(1));
                } catch (NumberFormatException e) {
                    System.out.println("Jumlah langkah tidak valid.");
                }

                int newX = robot.getPosition().getX();
                int newY = robot.getPosition().getY();

                switch (direction) {
                    case 'd':
                        newX += steps;
                        break;
                    case 'a':
                        newX -= steps;
                        break;
                    case 'w':
                        newY -= steps;
                        break;
                    case 's':
                        newY += steps;
                        break;
                    default:
                        System.out.println("Instruksi tidak valid.");
                }

                if (newX >= 1 && newX <= layout.getMaxX() && newY >= 1 && newY <= layout.getMaxY()) {
                    robot.getPosition().setX(newX);
                    robot.getPosition().setY(newY);
                }
            } else if (!instruction.equals("x")) {
                System.out.println("Instruksi tidak valid.");
            }
        } while (!instruction.equals("x"));
        System.out.println("-------- Permainan Selesai --------");
    }

    private String waitInstruction() {
        System.out.println("-------- Instruksi --------");
        System.out.println("Instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah}");
        System.out.println("Contoh: w3 berarti 'ke atas 3 langkah'");
        System.out.print("Masukkan instruksi: ");
        return scanner.nextLine();
    }

    private void draw() {
        System.out.println("------ Posisi Terbaru ------");
        for (int y = 1; y <= layout.getMaxY(); y++) {
            for (int x = 1; x <= layout.getMaxX(); x++) {
                if (x == robot.getPosition().getX() && y == robot.getPosition().getY()) {
                    System.out.print(robot.getIcon());
                } else {
                    System.out.print(layout.getArea()[x - 1][y - 1]);
                }
            }
            System.out.println();
        }
    }
}