package Diving_and_Conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class l4_q1 {

    static class Point{
        double x;
        double y;
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }

        public double dist(Point other){
            return Math.sqrt((this.x - other.x)*(this.x - other.x) + (this.y - other.y)*(this.y - other.y));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n != 0){
            Point[] arr = new Point[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new Point((double) scanner.nextInt(), (double) scanner.nextInt());
            }
            Arrays.sort(arr, (p1, p2) -> Double.compare(p1.x, p2.x));
            double ans = closestPairOfPoints(arr, 0, n-1);
            if(ans >= 10000) System.out.println("INFINITY");
            else{
                System.out.printf("%.4f", ans);
                System.out.println();
            }
            n = scanner.nextInt();
        }
    }

    private static double closestPairOfPoints(Point[] arr, int l, int r) {
        int mid = l + (r-l)/2;
        if(r-l <= 3){
            double min = Double.MAX_VALUE;
            for (int i = l; i <= r; i++) {
                for (int j = i+1; j <= r; j++) {
                    min = Math.min(min, arr[i].dist(arr[j]));
                }
            }
            return min;
        }
        double left = closestPairOfPoints(arr, l, mid);
        double right = closestPairOfPoints(arr, mid+1, r);
        double min_dist = Math.min(left, right);
        return Math.min(min_dist, merge(arr, l, r, min_dist));
    }

    private static double merge(Point[] arr, int l, int r, double min_dist) {
        ArrayList<Point> pts = new ArrayList<>();
        int mid = l + (r-l)/2;
        for (int i = l; i < r; i++) {
            Point p = arr[i];
            if(Math.abs(p.x - arr[mid].x) < min_dist){
                pts.add(p);
            }
        }
        Collections.sort(pts, (p1, p2) -> Double.compare(p1.y, p2.y));
        double min = min_dist;
        for (int i = 0; i < pts.size(); i++) {
            for (int j = i+1; j < pts.size(); j++) {
                if(Math.abs(pts.get(i).y - pts.get(j).y) > min_dist){
                    break;
                }
                min = Math.min(min, pts.get(i).dist(pts.get(j)));
            }
        }
        return min;
    }
}
