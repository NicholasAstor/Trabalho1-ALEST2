import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long start = System.nanoTime();
// ...
        var map = new ArrayList<String>();
        try{
            File file = new File("Trabalho/lib/casos-de-teste-E/casoE50.txt");
            Scanner in = new Scanner(file);

            while(in.hasNextLine()){
                map.add(in.nextLine());
            }
            in.close();
        }catch(Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }

        var carPos = getStartPos(map);
        var carDirection = Direction.RIGHT;
        var totalPilas = 0;
        var pilas = "";

        while(true){
            switch(carDirection){
                case UP: carPos.decreaseY(); break;
                case DOWN: carPos.increaseY(); break;
                case RIGHT: carPos.increaseX(); break;
                case LEFT: carPos.decreaseX(); break;
            }

            var value = getCarValue(map, carPos);

            carDirection = switch (value) {
                case '/' -> switch (carDirection) {
                    case UP -> Direction.RIGHT;
                    case DOWN -> Direction.LEFT;
                    case LEFT -> Direction.DOWN;
                    case RIGHT -> Direction.UP;
                };
                case '\\' -> switch (carDirection) {
                    case UP -> Direction.LEFT;
                    case DOWN -> Direction.RIGHT;
                    case LEFT -> Direction.UP;
                    case RIGHT -> Direction.DOWN;
                };
                default -> carDirection;
            };

            switch (value){
                case'0','1','2','3','4','5','6','7','8','9':
                    pilas += value;
                    break;
                default:
                    if(!pilas.isEmpty()){
                        totalPilas += Integer.parseInt(pilas);
                        pilas = "";
                    }
                    break;
            }

            if(getCarValue(map,carPos)=='#'){
                break;
            }
        }
        System.out.println(totalPilas);

        long finish = System.nanoTime();
        long timeElapsed = finish - start;

        System.out.println(timeElapsed + " nano seconds");
        // 197milli_525micro_256nano
    }
    public static Vec2 getStartPos(ArrayList<String> map){
        for(int i = 0; i<map.size(); i++){
            String linha = map.get(i);
            var primerioCharDaLinha = linha.charAt(0);
            if(primerioCharDaLinha == '-'){
                return new Vec2(0,i);
            }
        }
        throw new RuntimeException();
    }

    public static char getCarValue(ArrayList<String> map, Vec2 carPos){
        return map.get(carPos.getY()).charAt(carPos.getX());
    }
}
