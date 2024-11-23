// 일직선일때는 0
// 시계 방향이면 1, 반시계 방향이면 -1
// (p2x-p1x, p2y-p1y), (p3x-p2x,p3y-p2y)
// p2x-p1x / p2y-p1y == p3x-p2x / p3y-p2y => 0
// p2x-p1x / p2y-p1y > p3x-p2x / p3y-p2y => 1
// p2x-p1x / p2y-p1y < p3x-p2x / p3y-p2y => -1
import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] p = new int[3][2];
        for(int i = 0; i < 3; i++){
            String[] input = reader.readLine().split(" ");
            p[i][0] = Integer.parseInt(input[0]);
            p[i][1] = Integer.parseInt(input[1]);
        }

        // double vector1 = (p[2][0]-p[1][0])/(p[2][1]-p[1][1]);
        // double vector2 = (p[1][0]-p[0][0])/(p[1][1]-p[0][1]);
        int vector1 = (p[2][0]-p[1][0]) * (p[1][1]-p[0][1]);
        int vector2 = (p[1][0]-p[0][0]) * (p[2][1]-p[1][1]);

        if(vector1 == vector2){
            writer.write("0\n");
        }else if(vector1 > vector2){
            writer.write("-1\n");
        }else if(vector1 < vector2){
            writer.write("1\n");
        }

        writer.flush();
        writer.close();
    }
}