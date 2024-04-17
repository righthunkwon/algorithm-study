package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_17140_이차원배열과연산 {
	
	static int r, c, k;
	static int[][] map, res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) -1;
		c = Integer.parseInt(st.nextToken()) -1;
		k = Integer.parseInt(st.nextToken());
		
		map = new int[100][100];
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int rSize = 3;
		int cSize = 3;
		
		int cnt = 0;
		while(cnt <= 100) {
			
			if(r <= rSize && c <= cSize && map[r][c] == k) {
				System.out.println(cnt);
				return;
			}
			
			if(rSize >= cSize) {
				int newCSize = 0;
				HashMap<Integer, Integer> m;
				for(int j = 0; j < cSize; j++) {
					m = new HashMap<Integer, Integer>();
					for(int k = 0; k < rSize; k++) {
						if(map[j][k] == 0) continue;
						m.put(map[j][k], m.getOrDefault(map[j][k], 0)+1);
					}
					List<Map.Entry<Integer, Integer>> list = new ArrayList<>(m.entrySet());
					list.sort((a, b)-> {
						if(a.getValue().equals(b.getValue())) return a.getKey().compareTo(b.getKey());
						else return a.getValue().compareTo(b.getValue());
					});
					
					int idx = 0;
					for(Map.Entry<Integer, Integer> entry : list) {
						if(idx == 100) break;
						map[j][idx++] = entry.getKey();
						if(idx == 100) break;
						map[j][idx++] = entry.getValue();
					}
					newCSize = Math.max(newCSize, idx);
					for(;idx < 100; idx++) map[j][idx] = 0;
					
					cSize = newCSize;
					
//					for(int x = 0; x < 3; x++) {
//						for(int y = 0; y < 3; y++) {
//							System.out.print(map[x][y] + " ");
//						}
//						System.out.println();
//					}
//					
//					for(int l = 0; l < list.size(); l++) {
//						System.out.print(list.get(l) + " ");
//					}
//					System.out.println();
				}
			} else {
				int newRSize = 0;
				HashMap<Integer, Integer> m;
				for(int j = 0; j < rSize; j++) {
					m = new HashMap<Integer, Integer>();
					for(int k = 0; k < cSize; k++) {
						if(map[j][k] == 0) continue;
						m.put(map[j][k], m.getOrDefault(map[j][k], 0)+1);
					}
					List<Map.Entry<Integer, Integer>> list = new ArrayList<>(m.entrySet());
					list.sort((a, b)-> {
						if(a.getValue().equals(b.getValue())) return a.getKey().compareTo(b.getKey());
						else return a.getValue().compareTo(b.getValue());
					});
					
					int idx = 0;
					for(Map.Entry<Integer, Integer> entry : list) {
						if(idx == 100) break;
						map[idx][j] = entry.getKey();
						if(idx == 100) break;
						map[idx++][j] = entry.getValue();
					}
					newRSize = Math.max(newRSize, idx);
					for(;idx < 100; idx++) map[idx][j] = 0;
					
					rSize = newRSize;
				}
			}
			cnt++;
		}
		
		System.out.println(-1);
	}
}
